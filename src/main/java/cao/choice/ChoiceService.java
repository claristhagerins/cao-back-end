package cao.choice;

import java.util.List;

import org.apache.ibatis.session.SqlSession;

import cao.events.EventsMapper;
import cao.user.UserMapper;
import mybatis.MyBatisUtil;

public class ChoiceService {
	public String getChoiceId(String prefix) {
		SqlSession sqlSession = MyBatisUtil.getSqlSessionFactory().openSession();
		try {
			ChoiceMapper choiceMapper = sqlSession.getMapper(ChoiceMapper.class);
			return choiceMapper.getChoiceId(prefix);
		} finally {
			sqlSession.close();
		}
	}

	public void insertPollChoice(String pollQuestionId, String question, 
			String choiceId, String choice) {
		SqlSession sqlSession = MyBatisUtil.getSqlSessionFactory().openSession();
		try {
			ChoiceMapper choiceMapper = sqlSession.getMapper(ChoiceMapper.class);
			choiceMapper.insertPollChoice(pollQuestionId, question, choiceId, choice);
			sqlSession.commit();
		} finally {
			sqlSession.close();
		}
	}
}
