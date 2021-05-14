package eCommerceWork;

import eCommerceWork.business.abstracts.UserService;
import eCommerceWork.business.concretes.UserManager;

import eCommerceWork.dataAccsess.concretes.UserDaoManager;
import eCommerceWork.entities.concretes.User;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-g	enerated method stub
User user = new User(0, "burak", "benderli", "bende%rli@gmail.com", "123445", false, "1");
UserService userService = new UserManager(new UserDaoManager(user) );
userService.add(user);
System.out.println(userService.getAll());

	}

}
