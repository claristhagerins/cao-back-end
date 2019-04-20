package cao.pollquestion;

import java.util.List;

import org.apache.ibatis.session.SqlSession;

import cao.events.EventsMapper;
import cao.user.UserMapper;
import mybatis.MyBatisUtil;

public class PollQuestionService {
	public String getPollQuestionId(String prefix) {
		SqlSession sqlSession = MyBatisUtil.getSqlSessionFactory().openSession();
		try {
			PollQuestionMapper pollQuestionMapper = sqlSession.getMapper(PollQuestionMapper.class);
			return pollQuestionMapper.getPollQuestionId(prefix);
		} finally {
			sqlSession.close();
		}
	}

	public void insertPollQuestion(String pollQuestionId, String question) {
		SqlSession sqlSession = MyBatisUtil.getSqlSessionFactory().openSession();
		try {
			PollQuestionMapper pollQuestionMapper = sqlSession.getMapper(PollQuestionMapper.class);
			pollQuestionMapper.insertPollQuestion(pollQuestionId, question);
			sqlSession.commit();
		} finally {
			sqlSession.close();
		}
	}
}
