package home.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import home.dao.UserDao;
import home.domain.User;
import home.service.UserService;

@Service
public class UserServiceImpl implements UserService {
	@Autowired
	private UserDao userDao;
	
	public User getUser() {
		// TODO Auto-generated method stub
		User user = new User();
        //查询数据
        user.setName("Jessica");
        user.setPassword("123");
        System.out.println(userDao.query(1));
		return userDao.query(1);
	}

}
