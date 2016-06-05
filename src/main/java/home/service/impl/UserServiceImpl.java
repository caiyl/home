package home.service.impl;

import java.util.List;

import org.activiti.engine.HistoryService;
import org.activiti.engine.history.HistoricTaskInstance;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import home.domain.User;
import home.domain.mapper.UserMapper;
import home.service.AbstractService;
import home.service.UserService;

@Service
@Transactional
public class UserServiceImpl extends AbstractService<User, Integer> implements UserService {
	@Autowired
	private UserMapper userMapper;
	@Autowired
	private HistoryService historyService;

	public User getUser() {
		// TODO Auto-generated method stub
		User user = new User();
		// 查询数据
		user.setName("Jessica");
		user.setPassword("123");
		return user;
	}

	public User getUser(Integer id) {
		return selectByPrimaryKey(id);
	}

	public User getUserByName(String name) {
		String processInstanceId = "1201";
		List<HistoricTaskInstance> htiList = historyService.createHistoricTaskInstanceQuery()// 历史任务表查询
				.processInstanceId(processInstanceId)// 使用流程实例ID查询
				.list();
		// 遍历集合，获取每个任务ID
		if (htiList != null && htiList.size() > 0) {
			for (HistoricTaskInstance hti : htiList) {
				// 任务ID
				String htaskId = hti.getId();
				// 获取批注信息
			}
		}
		
		
		return selectByPrimaryKey(1);
	}

	@Override
	@Transactional
	public int addUser(User user) {
		
		
        User user2 = new User();
        
        user2.setId(35);
        user2.setName("me");
        user2.setPassword("1");
        user2.setRoleid(1);
		insertSelective(user2);
//		int a = 4/0;
		return 1;
		
	}

	@Override
	public void setBaseMapper() {
		// TODO Auto-generated method stub
		
	}

}
