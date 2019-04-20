package cao.pollquestion;

import java.util.List;

import cao.user.User;

public interface PollQuestionMapper {
	public String getPollQuestionId(String prefix);
	public void insertPollQuestion(String pollQuestionId, String question);
	public void insertUser(User user);
	public User getUserById(Integer userId);
	public List<User> getListUser();
	public void updateUser(User user);
	public void deleteUser(Integer userId);
}
