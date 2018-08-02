package com.zfz.handler;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.zfz.dao.NewUserDao;
import com.zfz.entities.NewUser;

@Controller
public class RegisterAndLogin {
	@RequestMapping("/RegisterPage")
    public String RegisterPage(){
        
        return "register";
    }
	@RequestMapping("/Register")
	public String Regester(NewUser user) {
		NewUserDao dao=new NewUserDao();
		SqlSessionFactory ssf=dao.getSqlSessionFactory();
		SqlSession ss=ssf.openSession();
		ss.insert("com.iotek.user.insert", user);
		ss.commit();
		System.out.println("×¢²á³É¹¦");
		return "success";
	}
	@RequestMapping("/Login")
	public String Login() {
		return "login";
	}
	@RequestMapping("/LoginIn")
	public String LoginIn(NewUser user) {
		NewUserDao dao=new NewUserDao();
		SqlSessionFactory ssf=dao.getSqlSessionFactory();
		SqlSession ss=ssf.openSession();
		NewUser a=ss.selectOne("com.iotek.user.select", user);
		System.out.println(a);
		System.out.println(user);
		if(user.getName().equals(a.getName())&&user.getPassword().equals(a.getPassword()))
	    return "success";
		else
	    return "failed";
	}
}
