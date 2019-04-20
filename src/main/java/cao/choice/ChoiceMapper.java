package cao.choice;

import java.util.List;

import cao.user.User;

public interface ChoiceMapper {
	public String getChoiceId(String prefix);
	public void insertPollChoice(String pollQuestionId, String question, String choiceId, String choice);
	public void insertUser(User user);
	public User getUserById(Integer userId);
	public List<User> getListUser();
	public void updateUser(User user);
	public void deleteUser(Integer userId);
}
