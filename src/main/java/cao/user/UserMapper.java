package cao.user;

import java.util.List;

import cao.user.User;

public interface UserMapper {
	public String getUserId(String prefix);
	public void insertUser(User user);
	public boolean isLoggedIn(User user);
	public void updateUserAfterLogin(User user);
	public User getUserById(Integer userId);
	public List<User> getUserByUserName(String userName);
	public List<User> getUserByEmail(String email);
	public List<User> getListUser();
	public String getPasswordByEmail(String email);
	public void updateUser(User user);
	public void deleteUser(Integer userId);
	public int checkUserName(String userNameBaru);
	public int checkRelationship(String userNameLama);
	public void updateUsername(User user);
	public void updateRelationshipUserOne(User user);
	public void updateRelationshipUserTwo(User user);
}