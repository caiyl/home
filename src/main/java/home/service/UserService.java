package home.service;

import home.domain.User;

public interface UserService {
	public User getUser();

	public User getUser(Integer id);

	public User getUserByName(String name);
}
