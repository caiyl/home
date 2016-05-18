package home.control;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.subject.Subject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import home.domain.User;
import home.service.UserService;



@Controller
public class LoginCtrl {
	
	@Autowired
	private UserService userService;
	@Autowired  
	private  HttpServletRequest request;
	@Autowired
	private  HttpServletResponse response;
	
	@RequestMapping("/login.do")
    public String  login(@RequestParam(value="name", required=false, defaultValue="World") String name, Model model) {
		
        System.out.println("hello Word----1222-2222------------------------");
        return "login";
    }
	
	
	/**
	 * 通过RedirectAttributes进行重定向
	 * @param user
	 * @param attr
	 * @return
	 * @throws ServletException
	 * @throws IOException
	 */
	@RequestMapping(value="/loginIn.do", method=RequestMethod.POST)
    public String loginIn(@ModelAttribute  User user,RedirectAttributes attr) throws ServletException, IOException {
		User u = userService.getUserByName(user.getName());
		
		Subject currentUser = SecurityUtils.getSubject();  
		
		
		if(u != null && u.getPassword().equals(user.getPassword())){
//			request.setAttribute("name", u.getName());
//			request.getRequestDispatcher("/index.jsp").forward(request, response);
			attr.addAttribute("param", u.getName());
            return "index";
		}else{
//			request.getRequestDispatcher("/login.do").forward(request, response);
//			attr.addAttribute("param", "你好");
			
			//redirect表示重定向
            return "redirect:/login.do";
		}
		
	}
}