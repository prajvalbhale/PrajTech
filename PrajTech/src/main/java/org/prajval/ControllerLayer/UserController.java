package org.prajval.ControllerLayer;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.prajval.EntityLayer.UserEntity;
import org.prajval.ServiceLayer.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class UserController {

	@Autowired
	private UserService userService;	
	
	/* Secured pages start */
	@ResponseBody
	@RequestMapping("/before-login-home-page")
	public ModelAndView ShowBeforeLoginPage(Model m) {
		ModelAndView mv = new ModelAndView();
		mv.setViewName("before_login_home_page.jsp");
		return mv;
	}

	@ResponseBody
	@RequestMapping("/demo-page")
	public ModelAndView ShowDemoPage(Model m) {
		ModelAndView mv = new ModelAndView();
		mv.setViewName("demo.jsp");
		return mv;
	}

	@ResponseBody
	@RequestMapping("/sign-up")
	public ModelAndView ShowSignupPage(Model m) {
		ModelAndView mv = new ModelAndView();
		mv.setViewName("usersignup.jsp");
		return mv;
	}

	@ResponseBody
	@RequestMapping("/show-login-page-after-signup")
	public ModelAndView ShowLoginPage(Model m) {
		ModelAndView mv = new ModelAndView();
		mv.setViewName("userlogin.jsp");
		return mv;
	}
	
	/* Secured pages end */

	/**/
	@ResponseBody
	@RequestMapping("/user-insert-for-sign-up")
	public ModelAndView UserInser(HttpServletRequest req, HttpServletResponse res) {
		ModelAndView mv = new ModelAndView();
		UserEntity u = new UserEntity();
		u.setUserFirstName(req.getParameter("UserFirstName"));
		u.setUserLastName(req.getParameter("UserLastName"));
		u.setUserMobileNo(req.getParameter("UserPhone"));
		u.setUserMailID(req.getParameter("UserMail"));
		u.setCollegeName(req.getParameter("CollegeName"));
		u.setCollegePin(req.getParameter("CollegePIN"));
		u.setRegisterNo(req.getParameter("RegisterNo"));
		u.setCollegeIDCard(req.getParameter("CollegeIDCardPic"));
		u.setConfirmPassword(req.getParameter("ConfirmPassword"));
		u.setEnabled(true);
		u.setUserRole("USER");
		UserEntity uu = userService.InsertUser(u);
		if (uu != null) {
			mv.setViewName("SuccessUserSignUp.jsp");
		} else {
			mv.setViewName("FailedUserSignUp.jsp");
		}
		return mv;
	}

	@ResponseBody
	@RequestMapping("/login-page")
	public ModelAndView usergologin(
			HttpServletRequest req, 
			HttpServletResponse res,
			@RequestParam("UserMailID") String UserMailID, 
			@RequestParam("ConfirmPassword") String ConfirmPassword) {
		ModelAndView mv = new ModelAndView();
		UserEntity user = userService.findByUsernameAndPassword(UserMailID, ConfirmPassword);

		if (user != null) {			
			HttpSession session = req.getSession();
			session.setAttribute("user", user);
			mv.setViewName("AfterUserLoginHomePage.jsp");
		} else {
			mv.setViewName("FailedUserSignUp.jsp");
		}
		return mv;
	}

	@ResponseBody
	@RequestMapping("/AfterUserLoginHomePage")
	public ModelAndView afterlogin(Model m) {
		ModelAndView mv = new ModelAndView();
		mv.setViewName("AfterUserLoginHomePage.jsp");
		return mv;
	}

	@ResponseBody
	@RequestMapping(value = "/my-profile", method = RequestMethod.GET)
	public ModelAndView Showprofile(HttpServletRequest req) {
		ModelAndView mv = new ModelAndView();
		HttpSession session = req.getSession();
		UserEntity user = (UserEntity) session.getAttribute("user");
		mv.addObject("user", user);
		mv.setViewName("Profile.jsp");
		return mv;
	}

	@ResponseBody
	@RequestMapping("/my-profiles")
	public ModelAndView profiletest(Model m) {
		ModelAndView mv = new ModelAndView();
		mv.setViewName("Profile.jsp");
		return mv;
	}
	
/*	private byte[] compressData(byte[] data) {
	    try {
	      ByteArrayOutputStream bos = new ByteArrayOutputStream();
	      GZIPOutputStream gzip = new GZIPOutputStream(bos);
	      gzip.write(data);
	      gzip.close();
	      return bos.toByteArray();
	    } catch (IOException e) {
	      // Handle exceptions
	    }
	  }
	byte[] compresszip = compressData(zipFileData.getBytes());
	byte[] compressjar = compressData(jarFileData.getBytes());
	byte[] compressdoc = compressData(docFileData.getBytes());
	byte[] compressvideo = compressData(videoFileData.getBytes());
	
	ProjectEntity pe = new ProjectEntity();
	pe.setName(name);
	pe.setTechnology(technology);
	pe.setDescription(description);
	pe.setZipFileData(compresszip);
	pe.setJarFileData(compressjar);
	pe.setDocFileData(compressdoc);
	pe.setVideoFileData(compressvideo);
*/
	
}