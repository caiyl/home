package home.dao;

import home.domain.User;

public interface BaseDao<T> {
	public void add(T obj);
	public void delete(int objId);
	public void update(User obj);
    public T query(int objId);
}
