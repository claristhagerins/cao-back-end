package cao.polllocation;

import java.util.List;

import cao.user.User;

public interface PollLocationMapper {
	public String getPollLocationId(String prefix);
	public void insertPollLocation(String pollLocationId, String locationName, String locationContact);
	public void insertUser(User user);
	public String getContactByLocationName(String locationName);
	public User getUserById(Integer userId);
	public List<User> getListUser();
	public void updateUser(User user);
	public void deleteUser(Integer userId);
}
