package home.control;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

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
	
	@RequestMapping("/userList.do")
    public String  userList(@RequestParam(value="name", required=false, defaultValue="World") String name, Model model) {
		
        System.out.println("hello Word----1222-2222------------------------");
        
        List<User> list = new ArrayList<User>();
        for(int i = 0; i < 10; i++){
        	User user = new User();
        	user.setId(i);
        	user.setName(i+"name");
        	list.add(user);
        }
        model.addAttribute("userList",list);
        return "system/userlist";
    }
	
	
}