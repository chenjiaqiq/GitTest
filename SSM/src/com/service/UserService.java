package com.service;
import java.util.List;

import com.pojo.User;
public interface UserService {
	public User Login(User u);
	public void isInsert(User user)  throws Exception;
	public void isDelete(int id)  throws Exception;
	public void update(User user)  throws Exception;
	public User queryById(int id );
	public List<User> queryAll();
}
