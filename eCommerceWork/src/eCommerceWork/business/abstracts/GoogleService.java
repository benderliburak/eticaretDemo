package eCommerceWork.business.abstracts;

import eCommerceWork.entities.concretes.User;

public interface GoogleService {
	 	void signIn(User user);//oturum acma olma
	    void signWithGoogleService(User user);//google iþlemleriyle google ile kayýt 
	    void signUp(User user);//kayýt olma 
	    void verify(User user, String code);//onay alma kodu 
}
