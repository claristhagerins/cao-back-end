package cao.relationship;

import cao.user.*;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.boon.json.JsonFactory;
import org.boon.json.ObjectMapper;

import cao.user.User;
import cao.user.UserService;

@RestController
@RequestMapping("/relationship")
public class RelationshipController {
	User user = new User();
	Relationship relationship = new Relationship();

	@PostMapping(value = "/showFriendList")
	public @ResponseBody String showFriendList(@RequestParam String userId, @RequestBody Relationship friend) {
		RelationshipService rsrv = new RelationshipService();
		List<Relationship> listFriends = null;
		ObjectMapper mapper = JsonFactory.create();
		
		String friendName = friend.getFriendName();
		String listResultJson = null;
		
		if ("".equals(friendName)) friendName = null;		

		listFriends = rsrv.getFriendList(userId, friendName);		

		listResultJson = mapper.writeValueAsString(listFriends);
		return listResultJson;
	}
	
	@PostMapping(value = "/searchFriend")
	public @ResponseBody String searchFriend(@RequestParam String userId, @RequestBody Relationship friend) {
		RelationshipService rsrv = new RelationshipService();
		List<Relationship> listUser = null;
		List<Relationship> listFriends = null;
		ObjectMapper mapper = JsonFactory.create();
		
		String userName = friend.getFriendName();
		String listResultJson = null;
		
		listUser = rsrv.searchFriend(userId, userName);
		listFriends = rsrv.getFriendList(userId, userName);
		
		for(int i=0 ; i<listUser.size() ; i++) {	
			listUser.get(i).setFriendStatus("");
			for(int j=0 ; j<listFriends.size() ; j++) {
				if(listFriends.get(j).getFriendName().equals(listUser.get(i).getFriendName())) {
					listUser.get(i).setFriendStatus("Friend");
				}
			}
			
			if("".equals(listUser.get(i).getFriendStatus())) {
				listUser.get(i).setFriendStatus("Not a Friend");
			}
		}

		listResultJson = mapper.writeValueAsString(listUser);
		return listResultJson;
	}
	
	@PostMapping(value = "/addFriend")
	public @ResponseBody String addFriend(@RequestBody Relationship friend) {
		RelationshipService rsrv = new RelationshipService();
//		List<Relationship> friendDetail = null;
		ObjectMapper mapper = JsonFactory.create();
		
		String userId = friend.getUserId();
		String userName = friend.getUserName();
		String friendId = friend.getFriendId();
		String friendName = friend.getFriendName();

		friend.setActionUserId(userId);
		
		int x=userId.compareTo(friendId);
		
		if(x < 0) {
			friend.setUserOneId(userId);
			friend.setUserOneName(userName);
			friend.setUserTwoId(friendId);
			friend.setUserTwoName(friendName);
			friend.setStatusUserOne(1);
			friend.setStatusUserTwo(0);
		} else {
			friend.setUserOneId(friendId);
			friend.setUserOneName(friendName);
			friend.setUserTwoId(userId);
			friend.setUserTwoName(userName);
			friend.setStatusUserOne(0);
			friend.setStatusUserTwo(1);
		}
		
		System.out.println(friend.toString());
		
		rsrv.addFriend(friend);
		
		return "Friend Added";
	}
	
	@PostMapping(value = "/deleteFriend")
	public @ResponseBody String deleteFriend(@RequestBody Relationship friend) {
		RelationshipService rsrv = new RelationshipService();
//		List<Relationship> friendDetail = null;
		ObjectMapper mapper = JsonFactory.create();
		
		String userId = friend.getUserId();
		String userName = friend.getUserName();
		String friendId = friend.getFriendId();
		String friendName = friend.getFriendName();

		friend.setActionUserId(userId);
		
		int x=userId.compareTo(friendId);
		
		if(x < 0) {
			friend.setUserOneId(userId);
			friend.setUserOneName(userName);
			friend.setUserTwoId(friendId);
			friend.setUserTwoName(friendName);
			friend.setStatusUserOne(0);
			friend.setStatusUserTwo(1);
		} else {
			friend.setUserOneId(friendId);
			friend.setUserOneName(friendName);
			friend.setUserTwoId(userId);
			friend.setUserTwoName(userName);
			friend.setStatusUserOne(1);
			friend.setStatusUserTwo(0);
		}
		
		System.out.println(friend.toString());
		
		rsrv.deleteFriend(friend);
		
		return "Friend Deleted";
	}
}
