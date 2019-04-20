package cao.user;

import java.util.List;

import org.boon.json.JsonFactory;
import org.boon.json.ObjectMapper;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import cao.relationship.Relationship;
import common.Common;

@RestController
@RequestMapping("/user")
public class UserController {
	User user = new User();

	@PostMapping(value = "/register")
	public String getUserData(@RequestBody User user) {

		// Set bean untuk masukkan data ke database
		user.setUserName(user.getUserName());
		user.setEmail(user.getEmail());
		user.setPassword(user.getPassword());
		user.setRoleId(Common.ROLE_ID_USR);
		user.setPrefix(Common.PREFIX_MASTER_USER);

		UserService usrv = new UserService();

		if (usrv.getUserByUsername(user.getUserName()).size() < 1) {
			if (usrv.getUserByEmail(user.getEmail()).size() < 1) {
				user.setUserId(usrv.getUserId(user.getPrefix()));
				usrv.insertUser(user);
				return "REGISTER SUCCESS";
			} else {
				return "Email already registered";
			}
		} else {
			return "Username or email already registered";
		}
	}

	@PostMapping(value = "/login")
	public String validateUserForLogin(@RequestBody User user) {
		boolean match = false;

		UserService usrv = new UserService();
		ObjectMapper mapper = JsonFactory.create();
		String userData=null;
		
		try {
			if (usrv.getUserByEmail(user.getEmail()).size() > 0) {
				if (usrv.getPasswordByEmail(user.getEmail()).equals(user.getPassword())) {
					match = true;
					usrv.updateUserAfterLogin(user);					
					
					user.setUserId(usrv.getUserByEmail(user.getEmail()).get(0).getUserId());
					user.setUserName(usrv.getUserByEmail(user.getEmail()).get(0).getUserName());
					user.setRoleId(usrv.getUserByEmail(user.getEmail()).get(0).getRoleId());
					user.setStatus("Login Success");
					
					
					userData = mapper.writeValueAsString(user);
					return userData;
				} else {
					user.setStatus("Wrong Password");
					userData = mapper.writeValueAsString(user);
					return userData;
				}
			} else {
				user.setStatus("Wrong Email or Password");
				userData = mapper.writeValueAsString(user);
				return userData;
			}
		} catch (Exception e) {
			user.setStatus("System unavailable");
			userData = mapper.writeValueAsString(user);
			return userData;
		}
	}
}
