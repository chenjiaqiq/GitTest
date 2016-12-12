package com.mapper;
import java.util.List;

import org.springframework.stereotype.Repository;

import com.pojo.User;
@Repository
public interface UserMapper {
	public User Login(User u);
	public boolean isInsert(User user);
	public boolean isDelete(int id );
	public boolean update(User user);
	public User queryById(int id );
	public List<User> queryAll();
	public void insertRole();
	
}
