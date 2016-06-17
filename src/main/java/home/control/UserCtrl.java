package home.control;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import home.domain.User;
import home.service.UserService;



@Controller
public class UserCtrl {
	
	@Autowired
	private UserService userService;
	@Autowired  
	private  HttpServletRequest request;
	@Autowired
	private  HttpServletResponse response;
	

	@ResponseBody
	@RequestMapping("/userList.do" )
    public List<User>  userList() {
		
        System.out.println("hello Word----1222-2222------------------------");
        
        User user = new User();
        
        user.setId(31);
        user.setName("me");
        user.setPassword("1");
        user.setRoleid(1);
        
		userService.addUser(user );
        
        List<User> list = new ArrayList<User>();
        for(int i = 0; i < 10; i++){
            user = new User();
        	user.setId(i);
        	user.setName(i+"name");
        	list.add(user);
        }
//        model.addAttribute("userList",list);
//        model.addAttribute("total",50);
        return list;
    }
	@RequestMapping("/userListView.do" )
	public String  userListView() {
		
		System.out.println("hello Word----1222-2222------------------------");
		
		User user = new User();
		
		user.setId(31);
		user.setName("me");
		user.setPassword("1");
		user.setRoleid(1);
		
		userService.addUser(user );
		
		List<User> list = new ArrayList<User>();
		for(int i = 0; i < 10; i++){
			user = new User();
			user.setId(i);
			user.setName(i+"name");
			list.add(user);
		}
//        model.addAttribute("userList",list);
//        model.addAttribute("total",50);
		return "system/userlist";
	}
	
	@ResponseBody
	@RequestMapping("/getJson.do" )
    public Map<String,String>  getJson( @RequestParam Map <String,String> map) {
		Map<String,String> ret = new HashMap<String,String>();
		ret.put("name", "name");
		ret.put("password", "password");
        System.out.println("hello Word----1222-2222------------------------");
        
//        model.addAttribute("userList",list);
//        model.addAttribute("total",50);
        return ret;
    }
	
//	@RequestMapping(value = "/user", method = RequestMethod.POST)
//    public @ResponseBody
//    Object addPerson() {
//        JSONObject jsonObject = new JSONObject();
//        jsonObject.put("msg", "注册人员信息成功");
//        return jsonObject;
//    }
	

	public @ResponseBody void testData() {
//	        response.setContentType("text/html;charset=UTF-8"); 
	        String jsonStr=null;
	 // can reuse, share globally
	        try{
	        } 
	        catch(Exception ex){
	              ex.printStackTrace();
	        }        
	        System.out.println("jsonStr:"+jsonStr);
	        PrintWriter pw = null;
	        try {
	            pw = response.getWriter();
	        } catch (IOException e) {
	        }
	        pw.print("{\"s\":\"ok\"}");
	        pw.flush();
	        pw.close();
	    } 
	
}