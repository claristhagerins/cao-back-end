package cao.relationship;

import cao.user.User;

public class Relationship extends User {
	private String friendId;
	private String friendName;
	private String userOneId;
	private String userOneName;
	private String userTwoId;
	private String userTwoName;
	private int statusUserOne;
	private int statusUserTwo;
	private String actionUserId;
	private String status;
//	private String dateCreate;

	public String getStatus() {
		return status;
	}

	@Override
	public String toString() {
		return "Relationship [friendId=" + friendId + ", friendName=" + friendName + ", userOneId=" + userOneId
				+ ", userOneName=" + userOneName + ", userTwoId=" + userTwoId + ", userTwoName=" + userTwoName
				+ ", statusUserOne=" + statusUserOne + ", statusUserTwo=" + statusUserTwo + ", actionUserId="
				+ actionUserId + ", status=" + status + "]";
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getFriendId() {
		return friendId;
	}

	public void setFriendId(String friendId) {
		this.friendId = friendId;
	}

	public String getFriendName() {
		return friendName;
	}

	public void setFriendName(String friendName) {
		this.friendName = friendName;
	}

	public String getUserOneId() {
		return userOneId;
	}

	public void setUserOneId(String userOneId) {
		this.userOneId = userOneId;
	}

	public String getUserOneName() {
		return userOneName;
	}

	public void setUserOneName(String userOneName) {
		this.userOneName = userOneName;
	}

	public String getUserTwoId() {
		return userTwoId;
	}

	public void setUserTwoId(String userTwoId) {
		this.userTwoId = userTwoId;
	}

	public String getUserTwoName() {
		return userTwoName;
	}

	public void setUserTwoName(String userTwoName) {
		this.userTwoName = userTwoName;
	}

	public int getStatusUserOne() {
		return statusUserOne;
	}

	public void setStatusUserOne(int statusUserOne) {
		this.statusUserOne = statusUserOne;
	}

	public int getStatusUserTwo() {
		return statusUserTwo;
	}

	public void setStatusUserTwo(int statusUserTwo) {
		this.statusUserTwo = statusUserTwo;
	}

	public String getActionUserId() {
		return actionUserId;
	}

	public void setActionUserId(String actionUserId) {
		this.actionUserId = actionUserId;
	}

}
