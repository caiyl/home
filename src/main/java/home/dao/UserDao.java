package home.dao;

import home.domain.User;


public interface UserDao extends BaseDao<User>{ 
	public User queryByName(String name);
	public User queryUserByPage(String name);
	public int insertSelective(User user);
}

