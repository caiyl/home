package home.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.activiti.engine.HistoryService;
import org.activiti.engine.history.HistoricTaskInstance;
import org.activiti.engine.task.Comment;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import home.dao.UserDao;
import home.domain.User;
import home.service.UserService;

@Service
public class UserServiceImpl implements UserService {
	@Autowired
	private UserDao userDao;
	@Autowired
	private HistoryService historyService;

	public User getUser() {
		// TODO Auto-generated method stub
		User user = new User();
		// 查询数据
		user.setName("Jessica");
		user.setPassword("123");
		System.out.println(userDao.query(1));
		return userDao.query(1);
	}

	public User getUser(Integer id) {
		System.out.println(userDao.query(id));
		return userDao.query(1);
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

		return userDao.queryByName(name);
	}

}
