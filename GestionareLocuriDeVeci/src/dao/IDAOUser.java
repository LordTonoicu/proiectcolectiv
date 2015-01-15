package dao;

import java.sql.SQLException;
import java.util.List;

import domain.User;

public interface IDAOUser {
	
	public void insert(User user) throws SQLException;

	public void update(User user) throws SQLException;

	public void delete(User user) throws SQLException;
	
	public List<User> getAll() throws SQLException;
	
	public User getByUsername(String username) throws SQLException;
}
