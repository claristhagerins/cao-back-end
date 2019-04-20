package cao.relationship;

import java.util.HashMap;
import java.util.List;

import org.apache.ibatis.session.SqlSession;

import cao.events.EventsMapper;
import cao.user.User;
import cao.user.UserMapper;
import mybatis.MyBatisUtil;

public class RelationshipService {
	
	public List<Relationship> getFriendList(String userId, String friendName) {
		SqlSession sqlSession = MyBatisUtil.getSqlSessionFactory().openSession();
		try {
			RelationshipMapper relationshipMapper = sqlSession.getMapper(RelationshipMapper.class);
			return relationshipMapper.getFriendList(userId, friendName);
		} finally {
			sqlSession.close();
		}
	}
	
	public List<Relationship> searchFriend(String userId, String userName){
		SqlSession sqlSession = MyBatisUtil.getSqlSessionFactory().openSession();
		try {
			RelationshipMapper relationshipMapper = sqlSession.getMapper(RelationshipMapper.class);
			return relationshipMapper.searchFriend(userId, userName);
		} finally {
			sqlSession.close();
		}
	}
	
	public void addFriend(Relationship relationship){
		SqlSession sqlSession = MyBatisUtil.getSqlSessionFactory().openSession();
		try {
			RelationshipMapper relationshipMapper = sqlSession.getMapper(RelationshipMapper.class);
			relationshipMapper.addFriend(relationship);
			sqlSession.commit();
		} finally {
			sqlSession.close();
		}
	}
	
	public void deleteFriend(Relationship relationship){
		SqlSession sqlSession = MyBatisUtil.getSqlSessionFactory().openSession();
		try {
			RelationshipMapper relationshipMapper = sqlSession.getMapper(RelationshipMapper.class);
			relationshipMapper.deleteFriend(relationship);
			sqlSession.commit();
		} finally {
			sqlSession.close();
		}
	}
}
