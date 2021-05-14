package eCommerceWork.business.concretes;

import eCommerceWork.business.abstracts.GoogleService;
import eCommerceWork.business.abstracts.UserService;
import eCommerceWork.core.concretes.googleServiceAdapter;
import eCommerceWork.entities.concretes.User;

public class GoogleManager implements GoogleService{
	private UserService userService;
	
	public GoogleManager(UserService userService) {
		super();
		this.userService = userService;
	}

	@Override
	public void signIn(User user) {
		// TODO Auto-generated method stub
		if (checkUserForLogin(user))
		{
			if (userService.ifEmailExists(user)&&userService.ifPasswordExists(user)) {
				System.out.println("giriş yapıldı");
			}
			else {
				System.out.println("kullanıcı adı veya şifre yanlış.");
			}
			return;
		}
		System.out.println("doğrulanmayan hesap");
	}

	@Override
	public void signWithGoogleService(User user) {
		// TODO Auto-generated method stub
		user.setisVerified(true);
		if (checkUserForLogin(user)) {
			googleServiceAdapter googleApi = new googleServiceAdapter();
			googleApi.signIn(user.getEmail(), user.getPassword());
			userService.add(user);
			return;
		}
		System.out.println("doğrulanmamış hesap");
		
	}

	@Override
	public void signUp(User user) {
		// TODO Auto-generated method stub
		userService.add(user);
		int random =(int)Math.floor(Math.random()*9999);
		String dogrulamaKodu=user.getFirstName().substring(0, 1)+user.getId()+" "+user.getLastName().substring(0, 1)+""+random;
		System.out.println("dogrulama: kodu"+dogrulamaKodu);
		user.setVerifyCode(dogrulamaKodu);
	}

	@Override
	public void verify(User user, String code) {
		// TODO Auto-generated method stub
		User verifiedUser = userService.get(user.getId());
        if(verifiedUser.getVerifyCode() == code) {
            verifiedUser.setisVerified(true);
            System.out.println("Kod doðrulandý");
            return;
        }
        System.out.println("Doðrulama Kodu Hatalý");
		
	}
	
	
	private boolean checkUserForLogin(User user)
	{
		if(user.isVerified() && !(user.getEmail().isBlank() && user.getEmail() == null) && 
		!(user.getPassword().isBlank() && user.getPassword() == null) ) {
			return true;
		}
		return false;
	}

}
