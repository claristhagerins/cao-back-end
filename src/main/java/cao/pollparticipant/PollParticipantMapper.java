package cao.pollparticipant;

import java.util.List;

import cao.user.User;

public interface PollParticipantMapper {
	public String getPollParticipantId(String prefix);
	public void insertPollParticipant(String pollParticipantId, String pollUserId, String pollRoleEventId);
	public User getUserById(Integer userId);
	public List<User> getListUser();
	public void updateUser(User user);
	public void deleteUser(Integer userId);
}
