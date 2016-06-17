package home.control;

import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.session.Session;
import org.apache.shiro.subject.Subject;
import org.dom4j.Document;
import org.dom4j.DocumentHelper;
import org.dom4j.Element;
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
import home.util.Const;



@Controller
public class LoginCtrl {
	
	@Autowired
	private UserService userService;
	@Autowired  
	private  HttpServletRequest request;
	@Autowired
	private  HttpServletResponse response;
	
	@RequestMapping("/login.do")
    public String  login(HttpServletRequest request, HttpServletResponse response) {
		String s = request.getSession().getId();
		System.out.println(s);
//		request.getSession().setAttribute("user", s);
		String u = (String)request.getSession().getAttribute("user");
		System.err.println("user"+u);
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
		String loginInfo = "";
		String ret = "";
		if(u != null && u.getPassword().equals(user.getPassword())){
			
			Subject subject = SecurityUtils.getSubject();  
			Session session = subject.getSession();
			session.setTimeout(1800000);
			UsernamePasswordToken token = new UsernamePasswordToken(u.getName(), u.getPassword()); 
			subject.login(token); 
			
			try { 
		        subject.login(token); 
		        session.setAttribute(Const.SESSION_USER, user);
		    } catch (AuthenticationException e) { 
		    	loginInfo = "身份验证失败！";
		    }
			attr.addAttribute("param", u.getName());
			ret = "index";
		}else{
			loginInfo = "usererror";
			ret = "login";
		}
		
		return ret;
		
	}
}