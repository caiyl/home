package home.control;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import home.domain.User;

@Controller
public class LoginCtrl {
	@RequestMapping("/login.do")
    public String  login(@RequestParam(value="name", required=false, defaultValue="World") String name, Model model) {
        model.addAttribute("name", name);
        System.out.println("hello Word----134----2222------------------------");
        return "/login";
    }
	
	@RequestMapping(value="/loginIn.do", method=RequestMethod.POST)
    public String loginIn(@ModelAttribute  User user) {
        System.out.println(user.getUsername() + user.getPassword() );
		return "/index";
    }
}
