package cao.voteresult;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;
import org.json.JSONObject;

import cao.voteresult.VoteResult;
import cao.voteresult.VoteResultMapper;
import cao.user.UserMapper;
import mybatis.MyBatisUtil;

public class VoteResultService {
	public List<VoteResult> getVoteResultList(String eventId) {
		SqlSession sqlSession = MyBatisUtil.getSqlSessionFactory().openSession();
		try {
			VoteResultMapper voteResultMapper = sqlSession.getMapper(VoteResultMapper.class);
			return voteResultMapper.getVoteResultList(eventId);
		} finally {
			sqlSession.close();
		}
	}
	public String getTotalVoters(String eventId) {
		SqlSession sqlSession = MyBatisUtil.getSqlSessionFactory().openSession();
		try {
			VoteResultMapper voteResultMapper = sqlSession.getMapper(VoteResultMapper.class);
			return voteResultMapper.getTotalVoters(eventId);
		} finally {
			sqlSession.close();
		}
	}
	public int getNumberOfVoters(String chosenCategory, String chosenCategoryName) {
		SqlSession sqlSession = MyBatisUtil.getSqlSessionFactory().openSession();
		try {
			VoteResultMapper voteResultMapper = sqlSession.getMapper(VoteResultMapper.class);
			return voteResultMapper.getNumberOfVoters(chosenCategory, chosenCategoryName);
		} finally {
			sqlSession.close();
		}
	}
	public List<Map<String,String>> getChoices(String eventId) {
		SqlSession sqlSession = MyBatisUtil.getSqlSessionFactory().openSession();
		try {
			VoteResultMapper voteResultMapper = sqlSession.getMapper(VoteResultMapper.class);
			return voteResultMapper.getChoices(eventId);
		} finally {
			sqlSession.close();
		}
	}
	public void insertVoteResult(String eventId, String pollUserId) {
		SqlSession sqlSession = MyBatisUtil.getSqlSessionFactory().openSession();
		try {
			VoteResultMapper voteResultMapper = sqlSession.getMapper(VoteResultMapper.class);
			voteResultMapper.insertVoteResult(eventId, pollUserId);
		} finally {
			sqlSession.close();
		}
	}
	public void giveVote(String eventId, String userId, String inputChosenDateTime, 
			String inputChosenLocationName, String inputChosenChoiceName) {
		SqlSession sqlSession = MyBatisUtil.getSqlSessionFactory().openSession();
		try {
			VoteResultMapper voteResultMapper = sqlSession.getMapper(VoteResultMapper.class);
			voteResultMapper.giveVote(eventId, userId, inputChosenDateTime, 
					inputChosenLocationName, inputChosenChoiceName);
			System.out.println("-----------syso di voteResultService");
			System.out.println(eventId);
			System.out.println(userId);
			System.out.println(inputChosenDateTime);
			System.out.println(inputChosenLocationName);
			System.out.println(inputChosenChoiceName);
		} finally {
			sqlSession.close();
		}
	}
}
