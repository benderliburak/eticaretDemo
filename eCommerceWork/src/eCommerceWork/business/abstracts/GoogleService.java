package eCommerceWork.business.abstracts;

import eCommerceWork.entities.concretes.User;

public interface GoogleService {
	 	void signIn(User user);//oturum acma olma
	    void signWithGoogleService(User user);//google i�lemleriyle google ile kay�t 
	    void signUp(User user);//kay�t olma 
	    void verify(User user, String code);//onay alma kodu 
}
