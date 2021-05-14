package eCommerceWork.dataAccsess.abstracts;

import java.util.List;

import eCommerceWork.entities.concretes.User;

public interface UserDao {
	void add (User user);
	void update(User user);
	void delete(User user);
	List<User> getAll();//User tipte ait tüm özellikleri listeleyip  getiriyor
	User get(int id);
	List<String> getEmails(); // tüm emailleri listeleyi getiriyor
	boolean isMailMatch(User user);
	boolean isPasswordMatch(User user);
}
