package com.zfz.handler;

import java.util.Date;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CookieValue;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.zfz.entities.User;
@RequestMapping("/springmvc")
@Controller
public class SpringMVCTest {
    @RequestMapping("/testRequestMapping")
	public String testRequestMapping() {
		System.out.println("testrequestMapping");
		return "success";
	}
    @RequestMapping("/testPathVariable/{id}")
    public String testPathVariable(@PathVariable(value="id") Integer id){
        System.out.println("testPathVariable:" + id);
        return "success";
    }
    
    @RequestMapping("/testRequestParam")
    public String testRequestParam(@RequestParam(value="username")String username,@RequestParam(value="age",required=false,defaultValue="0")int age) {
    	 System.out.println("testRequestParam" + " username:" + username + " age:" +age);
    	    return "success";
    }
    @RequestMapping(value="/testRest/{id}", method=RequestMethod.PUT)
    public String testRestPut(@PathVariable(value="id") Integer id){
        System.out.println("test put:" + id);
        return "success";
    }
         
    @RequestMapping(value="/testRest/{id}", method=RequestMethod.DELETE)
    public String testRestDelete(@PathVariable(value="id") Integer id){
        System.out.println("test delete:" + id);
        return "success";
    }
         
    @RequestMapping(value="/testRest", method=RequestMethod.POST)
    public String testRest(){
        System.out.println("test post");
        return "success";
    }
         
    @RequestMapping(value="/testRest/{id}", method=RequestMethod.GET)
    public String testRest(@PathVariable(value="id") Integer id){
        System.out.println("test get:" + id);
        return "success";
    }
    @RequestMapping(value="/testCookieValue")
    public String testCookieValue(@CookieValue("JSESSIONID") String cookieValue){
        System.out.println("testCookieValue: " + cookieValue);
        return "success";
    }
    @RequestMapping(value="/testRequestHeader")
    public String testRequestHeader(@RequestHeader(value="Accept-Language") String language){
        System.out.println("testRequestHeader Accept-Languge:" + language);
        return "success";
    }
    @RequestMapping(value="/testPojo")
    public String testPojo(User user){
        System.out.println("testPojo: " + user);
        return "success";
    }
    @RequestMapping(value="/testModelAndView")
    public ModelAndView testModelAndView(){
        String viewname = "success";
        ModelAndView modelAndView = new ModelAndView(viewname);
        modelAndView.addObject("time", new Date());
        return modelAndView;
    }
    @RequestMapping("/testViewAndViewResolver")
    public String testViewAndViewResolver(){
        System.out.println("testViewAndViewResolver");
        return "success";
    }
}
