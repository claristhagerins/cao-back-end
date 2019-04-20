package cao.relationship;

import java.util.HashMap;
import java.util.List;

import cao.user.User;


public interface RelationshipMapper {
	public List<Relationship> getFriendList(String userId, String friendName);
	public List<Relationship> searchFriend(String userId, String userName);
	public void addFriend(Relationship relationship);
	public void deleteFriend(Relationship relationship);
}
