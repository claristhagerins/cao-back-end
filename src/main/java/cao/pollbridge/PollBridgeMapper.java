package cao.pollbridge;

import java.util.List;

import cao.user.User;

public interface PollBridgeMapper {
	public String getPollBridgeId(String prefix);
	public void insertPollBridge(String pollBridgeId, String pollEventId, String pollParticipantId,
			String pollLocationId, String pollDateTimeId, String pollQuestionId);
	public User getUserById(Integer userId);
	public List<User> getListUser();
	public void updateUser(User user);
	public void deleteUser(Integer userId);
}
