package eCommerceWork.business.concretes;

import java.util.List;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import eCommerceWork.business.abstracts.UserService;
import eCommerceWork.dataAccsess.abstracts.UserDao;
import eCommerceWork.entities.concretes.User;

public class UserManager implements UserService {
	private UserDao userDao;

	public UserManager(UserDao userDao) {
		super();
		this.userDao = userDao;
	}

	@Override
	public void add(User user) {
		if (isValid(user) && !ifEmailExists(user)) {
			userDao.add(user);
			return ;
		}
		
	}

	@Override
	public void update(User user) {
		// TODO Auto-generated method stub
		if(isValid(user) && !ifEmailExists(user)) {
			userDao.update(user);
			return;
			}
	}

	@Override
	public void delete(User user) {
		// TODO Auto-generated method stub
		userDao.delete(user);
	}

	@Override
	public List<User> getAll() {
		// TODO Auto-generated method stub
		return userDao.getAll();
	}

	@Override
	public User get(int id) {
		// TODO Auto-generated method stub
		return userDao.get(id);
	}

	@Override
	public boolean ifEmailExists(User user) {
		// TODO Auto-generated method stub
		return userDao.isMailMatch(user);
	}

	@Override
	public boolean ifPasswordExists(User user) {
		// TODO Auto-generated method stub
		return userDao.isPasswordMatch(user);
	}

	private boolean isValid(User user) {
		String regex = "(.+)@(.+)$";
		Pattern pattern = Pattern.compile(regex);
		Matcher matcher = pattern.matcher(user.getEmail());
		if (user.getFirstName() == null || user.getLastName() == null || user.getEmail() == null
				|| user.getPassword() == null) {
			System.out.println("isim ,soyisim,email,þifre boþ býrakýlmaz.");
			return false;
		} else if (!matcher.matches()) {

			System.out.println("E-mail hatalý.");
			return false;

		} else if (user.getFirstName().length() < 2 && user.getLastName().length() < 2) {

			System.out.println("adýnýz ve soyadýnýz en az 2 karakterli olabilir");
			return false;
		} else if (user.getPassword().length() < 6) {
			System.out.println("þifreniz en az 6 karakterli olabilir");
			return false;
		}
		return true;
	}
}
