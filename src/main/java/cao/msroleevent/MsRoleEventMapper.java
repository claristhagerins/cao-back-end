package cao.msroleevent;

import java.util.List;

import cao.user.User;

public interface MsRoleEventMapper {
	public String getUserId(String prefix);
	public void insertUser(User user);
	public User getUserById(Integer userId);
	public List<User> getListUser();
	public void updateUser(User user);
	public void deleteUser(Integer userId);
}
