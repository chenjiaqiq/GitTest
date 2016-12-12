package com.action;
import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.apache.struts2.ServletActionContext;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import org.apache.log4j.Logger;

import com.pojo.User;
import com.service.UserService;
@Controller
@Scope("prototype")
public class UserAction {

    private String id;
    private String username   ;
    private String password;
    @Resource
	private UserService userservice;
	private User user;
	private Logger logger = Logger.getLogger(UserAction.class);

	HttpServletRequest request = ServletActionContext.getRequest();
	
	public String index() throws Exception {
		return "index";
	}
	
	public String Login()  {
		try {
			 User u = userservice.Login(this.getUser());
			    String username = user.getUsername();
			    String password = user.getPassword();
				if(u != null){
					return "success";
				}else{
				    if(username.equals("")&&password.equals("")){
				        return "error1";
		            }else if(username.equals("")){
		                return "error1";
		            }else if(password.equals("")){
		                return "error1";
		            }else{
		                return "error2";
		            }
				}
		} catch (Exception e) {
			// TODO: handle exception
			logger.info("登录失败");
			return "error2";
		}
	   
    }
	
	public String Insert() throws Exception {	       
	    try {
			userservice.isInsert(user);
			return "success";
		} catch (Exception e) {
			logger.info("执行新增失败  "+ e.getMessage());
			return "failure";		
		}    
	        
    }
	    
	public String Delete()throws Exception{
        /*boolean b = userservice.isDelete(Integer.parseInt(this.getId()));
        if(b){
            return "success";
        }else{
            return "false";
        }*/
        
        try {
        	userservice.isDelete(Integer.parseInt(this.getId()));
			return "success";
		} catch (Exception e) {
			return "failure";		
		}    
        
    }
	   
	public String update() throws Exception {
		/*int id = this.getUser().getId();
	    boolean b = userservice.update(this.getUser());
	    
	    User u = userservice.queryById(id);
	    if (b) {
	      return "success";
        }else{
          return "failure";
        }*/
	    try {
	    	int id = this.getUser().getId();
		     userservice.update(this.getUser());
		    
		    User u = userservice.queryById(id);
			return "success";
		} catch (Exception e) {
			return "failure";		
		}    
	    
	}
	    
	public String queryById() throws Exception {
			int id  = Integer.parseInt(this.getId());
	        User u = userservice.queryById(id);
	        ServletActionContext.getRequest().setAttribute("user",u);
	        return "query";
	    }
	

    public String queryAll() throws Exception {
        List list = userservice.queryAll();
        if(list.size()==0){
            return "failure";
        }else{
        	ServletActionContext.getRequest().setAttribute("list",list);
        }
        return "success";
    }

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public UserService getUserservice() {
		return userservice;
	}

	public void setUserservice(UserService userservice) {
		this.userservice = userservice;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public HttpServletRequest getRequest() {
		return request;
	}

	public void setRequest(HttpServletRequest request) {
		this.request = request;
	}
    
    
}
