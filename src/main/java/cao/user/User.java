package cao.user;

import cao.Base;

public class User extends Base {
	private String userId;
	private String userName;
	private String userNameBaru;
	private String email;
	private String password;
	private String roleId;
	private String isLoggedIn;
	private String dateCreated;
	private String status;
	private String friendStatus;

	@Override
	public String toString() {
		return "User [userId=" + userId + ", userName=" + userName + ", userNameBaru=" + userNameBaru + ", email="
				+ email + ", password=" + password + ", roleId=" + roleId + ", isLoggedIn=" + isLoggedIn
				+ ", dateCreated=" + dateCreated + ", status=" + status + ", friendStatus=" + friendStatus + "]";
	}

	public String getUserNameBaru() {
		return userNameBaru;
	}

	public void setUserNameBaru(String userNameBaru) {
		this.userNameBaru = userNameBaru;
	}

	public String getFriendStatus() {
		return friendStatus;
	}

	public void setFriendStatus(String friendStatus) {
		this.friendStatus = friendStatus;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
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

	public String getRoleId() {
		return roleId;
	}

	public String getDateCreated() {
		return dateCreated;
	}

	public void setDateCreated(String dateCreated) {
		this.dateCreated = dateCreated;
	}

	public void setRoleId(String roleId) {
		this.roleId = roleId;
	}

	public String getIsLoggedIn() {
		return isLoggedIn;
	}

	public void setIsLoggedIn(String isLoggedIn) {
		this.isLoggedIn = isLoggedIn;
	}

}
