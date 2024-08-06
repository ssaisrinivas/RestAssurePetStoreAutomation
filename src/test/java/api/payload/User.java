package api.payload;

public class User {
	
	
	/*
	 * "id": 0, 
	 * "username": "sai",
	 *  "firstName": "sai", 
	 *  "lastName": "srinivas",
	 * "email": "ssai@gmail.com", 
	 * "password": "123", 
	 * "phone": "4265655665",
	 * "userStatus": 1
	 */

	private int id;
	private String userName;
	private String firstName;
	private String lastName;
	private String email;
	private String password;
	private String phone;
	private int userStatus=1;
	
	
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
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
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	public int getUserStatus() {
		return userStatus;
	}
	public void setUserStatus(int userStatus) {
		this.userStatus = userStatus;
	}
	
	
	
	
	@Override
	public String toString() {
		return "User [id=" + id + ", userName=" + userName + ", firstName=" + firstName + ", lastName=" + lastName
				+ ", email=" + email + ", password=" + password + ", phone=" + phone + ", userStatus=" + userStatus
				+ "]";
	}
	
	
}
