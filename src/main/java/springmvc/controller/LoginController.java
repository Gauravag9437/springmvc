package springmvc.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import springmvc.model.User;
import springmvc.service.UserService;

@Controller
public class LoginController {

	@Autowired
	private UserService userService;

	@RequestMapping("/")
	public String index() {
		return "index";
	}

	@RequestMapping(path = "/login", method = RequestMethod.POST)
	public ModelAndView login(@ModelAttribute User user,HttpServletRequest request) {

		boolean isValidNow = this.userService.isExist(user);

		ModelAndView modelAndView = new ModelAndView();

		if (isValidNow == true) {
			modelAndView.setViewName("home");
			HttpSession session = request.getSession();
			session.setAttribute("currentAdmin", user);
		}

		else {
			String error = "User not exist!!";
			modelAndView.addObject("error", error);
			modelAndView.setViewName("index");
		}

		return modelAndView;
	}

	@RequestMapping("/home")
	public String home() {
		return "home";
	}

	@RequestMapping(path = "/reset", method = RequestMethod.POST)
	public ModelAndView resetPassword(@RequestParam("username") String username) {
		ModelAndView modelAndView = new ModelAndView();

		String password = this.userService.getPassword(username);

		if (password == null) {
			modelAndView.addObject("password", "user not exist");
			modelAndView.setViewName("index");
		} else {
			modelAndView.addObject("password", password);
			modelAndView.setViewName("index");
		}

		return modelAndView;
	}

}
