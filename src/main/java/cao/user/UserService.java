package cao.user;

import java.util.List;

import org.apache.ibatis.session.SqlSession;

import cao.user.UserMapper;
import mybatis.MyBatisUtil;

public class UserService {
	// done
	public String getUserId(String prefix) {
		SqlSession sqlSession = MyBatisUtil.getSqlSessionFactory().openSession();
		try {
			UserMapper userMapper = sqlSession.getMapper(UserMapper.class);
			return userMapper.getUserId(prefix);
		} finally {
			sqlSession.close();
		}
	}

	// done
	public void insertUser(User user) {
		SqlSession sqlSession = MyBatisUtil.getSqlSessionFactory().openSession();
		try {
			UserMapper userMapper = sqlSession.getMapper(UserMapper.class);
			userMapper.insertUser(user);
			sqlSession.commit();
		} finally {
			sqlSession.close();
		}
	}

	public void updateUserAfterLogin(User user) {
		SqlSession sqlSession = MyBatisUtil.getSqlSessionFactory().openSession();
		try {
			UserMapper userMapper = sqlSession.getMapper(UserMapper.class);
			userMapper.updateUserAfterLogin(user);
			sqlSession.commit();
		} finally {
			sqlSession.close();
		}
	}

	public boolean isLoggedIn(User user) {
		boolean bool;
		SqlSession sqlSession = MyBatisUtil.getSqlSessionFactory().openSession();
		try {
			UserMapper userMapper = sqlSession.getMapper(UserMapper.class);
			bool = userMapper.isLoggedIn(user);
			sqlSession.commit();
		} finally {
			sqlSession.close();
		}
		return bool;
	}

	public void getParticipantList(User user) {
		SqlSession sqlSession = MyBatisUtil.getSqlSessionFactory().openSession();
		try {
			UserMapper userMapper = sqlSession.getMapper(UserMapper.class);
			userMapper.insertUser(user);
			sqlSession.commit();
		} finally {
			sqlSession.close();
		}
	}

	public User getUserById(Integer userId) {
		SqlSession sqlSession = MyBatisUtil.getSqlSessionFactory().openSession();
		try {
			UserMapper userMapper = sqlSession.getMapper(UserMapper.class);
			return userMapper.getUserById(userId);
		} finally {
			sqlSession.close();
		}
	}

	public List<User> getUserByUsername(String userName) {
		SqlSession sqlSession = MyBatisUtil.getSqlSessionFactory().openSession();
		try {
			UserMapper userMapper = sqlSession.getMapper(UserMapper.class);
			return userMapper.getUserByUserName(userName);
		} finally {
			sqlSession.close();
		}
	}

	// Added by RED : 02-Mar-2019
	public List<User> getUserByEmail(String email) {
		SqlSession sqlSession = MyBatisUtil.getSqlSessionFactory().openSession();
		try {
			UserMapper userMapper = sqlSession.getMapper(UserMapper.class);
			return userMapper.getUserByEmail(email);
		} finally {
			sqlSession.close();
		}
	}
	// End - Added by RED : 02-Mar-2019

	// Added by RED : 02-Mar-2019
	public String getPasswordByEmail(String email) {
		SqlSession sqlSession = MyBatisUtil.getSqlSessionFactory().openSession();
		try {
			UserMapper userMapper = sqlSession.getMapper(UserMapper.class);
			return userMapper.getPasswordByEmail(email);
		} finally {
			sqlSession.close();
		}
	}
	// End - Added by RED : 02-Mar-2019

	public List<User> getListUser() {
		SqlSession sqlSession = MyBatisUtil.getSqlSessionFactory().openSession();
		try {
			UserMapper userMapper = sqlSession.getMapper(UserMapper.class);
			return userMapper.getListUser();
		} finally {
			sqlSession.close();
		}
	}

	public void updateUser(User user) {
		SqlSession sqlSession = MyBatisUtil.getSqlSessionFactory().openSession();
		try {
			UserMapper userMapper = sqlSession.getMapper(UserMapper.class);
			userMapper.updateUser(user);
			sqlSession.commit();
		} finally {
			sqlSession.close();
		}

	}

	public void deleteUser(Integer userId) {
		SqlSession sqlSession = MyBatisUtil.getSqlSessionFactory().openSession();
		try {
			UserMapper userMapper = sqlSession.getMapper(UserMapper.class);
			userMapper.deleteUser(userId);
			sqlSession.commit();
		} finally {
			sqlSession.close();
		}

	}

	public int checkUserName(String userNameBaru) {
		SqlSession sqlSession = MyBatisUtil.getSqlSessionFactory().openSession();
		try {
			UserMapper userMapper = sqlSession.getMapper(UserMapper.class);
			return userMapper.checkUserName(userNameBaru);
		} finally {
			sqlSession.close();
		}
	}

	public int checkRelationship(String userNameLama) {
		SqlSession sqlSession = MyBatisUtil.getSqlSessionFactory().openSession();
		try {
			UserMapper userMapper = sqlSession.getMapper(UserMapper.class);
			return userMapper.checkRelationship(userNameLama);
		} finally {
			sqlSession.close();
		}
	}

	public void updateUsername(User user) {
		SqlSession sqlSession = MyBatisUtil.getSqlSessionFactory().openSession();
		try {
			UserMapper userMapper = sqlSession.getMapper(UserMapper.class);
			userMapper.updateUsername(user);
			sqlSession.commit();
		} finally {
			sqlSession.close();
		}
	}
	
	public void updateRelationship(User user) {
		SqlSession sqlSession = MyBatisUtil.getSqlSessionFactory().openSession();
		try {
			UserMapper userMapper = sqlSession.getMapper(UserMapper.class);
			userMapper.updateRelationshipUserOne(user);
			userMapper.updateRelationshipUserTwo(user);
			sqlSession.commit();
		} finally {
			sqlSession.close();
		}
	}
}
