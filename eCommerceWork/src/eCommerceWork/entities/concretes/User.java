package eCommerceWork.entities.concretes;

import eCommerceWork.entities.abstracts.Entity;

public class User implements Entity {

		private int id ;
		private String firstName;
		private String lastName;
		private String email;
		private String password;
		private boolean isVerified = false ;//bu true olmaz ise otamatik giriþ olmaz 
		private String verifyCode;
		
		public User(int id, String firstName, String lastName,String email, String password, boolean isVerified, String verifyCode) {
			super();
			this.id = id;
			this.firstName = firstName;
			this.lastName=lastName;
			this.email = email;
			this.password = password;
			this.isVerified = isVerified;
			this.verifyCode = verifyCode;
		}
		
		public int getId() {
			return id;
		}
		public void setId(int id) {
			this.id = id;
		}
		public String getFirstName() {
			return firstName;
		}
		public void setFirstName(String firstName) {
			this.firstName = firstName;
		}
		public String getEmail() {
			return email;
		}
		public void setEmail(String email) {
			this.email = email;
		}
		public String getPassword() {
			return password;
		}
		public void setPassword(String password) {
			this.password = password;
		}
		public boolean isVerified() {
			return isVerified;
		}
		public void setisVerified(boolean isVerified) {
			this.isVerified = isVerified;
		}
		public String getVerifyCode() {
			return verifyCode;
		}
		public void setVerifyCode(String verifyCode) {
			this.verifyCode = verifyCode;
		}

		public String getLastName() {
			return lastName;
		}

		public void setLastName(String lastName) {
			this.lastName = lastName;
		}
}
