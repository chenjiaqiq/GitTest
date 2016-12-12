package com.service;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.mapper.UserMapper;
import com.pojo.User;
@Service("userservice") 
public class UserServiceImpl implements UserService{
	@Resource
	UserMapper userdao;
 
	public User Login(User u){
		User user = userdao.Login(u);
		return user;
	}
	@Transactional
	public void isInsert(User user) throws Exception {
        userdao.isInsert(user);
        //userdao.insertRole();
        
    }
	@Transactional
	public void isDelete(int id )throws Exception{
            userdao.isDelete(id);
        
    }
	@Transactional
    public void update(User user)throws Exception {
            userdao.update(user);
        
    }
	    
    public User queryById(int id ) {
        User user = userdao.queryById(id);
        return user;
    }
    
    public List<User> queryAll(){
        List list = userdao.queryAll();
        return list;
    }
}
