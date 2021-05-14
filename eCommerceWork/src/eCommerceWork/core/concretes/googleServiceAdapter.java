package eCommerceWork.core.concretes;

import eCommerceWork.Googleservis.googleServis;
import eCommerceWork.core.abstracts.googleAutoService;

public class googleServiceAdapter implements googleAutoService{

	@Override
	public void signIn(String email, String password) {
		googleServis googleServis= new googleServis();
		googleServis.sign(email, password);
		
	}

}
