package home.control;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import home.dao.UserDao;
import home.domain.User;
import home.service.UserService;



@Controller
public class LoginCtrl {
	
	@Autowired
	private UserService userService;
	
	@RequestMapping("/login.do")
    public String  login(@RequestParam(value="name", required=false, defaultValue="World") String name, Model model) {
		
		userService.getUser();
        System.out.println("hello Word----1222-2222------------------------");
        return "/login";
    }
	
	@RequestMapping(value="/loginIn.do", method=RequestMethod.POST)
    public String loginIn(@ModelAttribute  User user) {
        System.out.println(user.getName() + user.getPassword() );
		return "/index";
    }
}