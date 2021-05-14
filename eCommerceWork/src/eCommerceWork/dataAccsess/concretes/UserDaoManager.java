package eCommerceWork.dataAccsess.concretes;

import java.util.ArrayList;
import java.util.List;

import eCommerceWork.dataAccsess.abstracts.UserDao;
import eCommerceWork.entities.concretes.User;

public class UserDaoManager implements UserDao
{
	private List<User> users;
	
	public UserDaoManager (User user)
	{
		super();
		this.users=new ArrayList<User>();
	}
	@Override
	public void add(User user) {
		users.add(user);
		System.out.println(user.getEmail()+" kayit oldu");
		
	}

	@Override
	public void update(User user) {
		// TODO Auto-generated method stub
		System.out.println(user.getEmail()+" güncellendi.");
	}

	@Override
	public void delete(User user) {
		// TODO Auto-generated method stub
		System.out.println(user.getEmail()+" silindi");
	}

	@Override
	public List<User> getAll() {
		// TODO Auto-generated method stub
		return users;
	}

	@Override
	public User get(int id) {
		// TODO Auto-generated method stub
		return users.stream().filter(u -> u.getId() == id).findFirst().get();
	}

	@Override
	public List<String> getEmails() {
		List<String> emails = new ArrayList<String>();
		for (User user : users)
		{
			emails.add(user.getEmail());
		}
		return emails;
	}

	@Override
	public boolean isMailMatch(User user) {
		// TODO Auto-generated method stub
		return getEmails().stream().anyMatch(x->x==user.getEmail());
	}

	@Override
	public boolean isPasswordMatch(User user) {
		// TODO Auto-generated method stub
		return users.stream().anyMatch(user_->user_.getPassword()==user.getPassword());
	}

}
