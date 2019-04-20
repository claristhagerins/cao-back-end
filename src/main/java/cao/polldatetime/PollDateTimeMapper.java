package cao.polldatetime;

import java.util.List;

import cao.user.User;

public interface PollDateTimeMapper {
	public String getPollDateTimeId(String prefix);
	public void insertPollDateTime(String pollDateTimeId, String eventDate
			//,String startTime, String endTime
			);
	public void insertUser(User user);
	public User getUserById(Integer userId);
	public List<User> getListUser();
	public void updateUser(User user);
	public void deleteUser(Integer userId);
}
