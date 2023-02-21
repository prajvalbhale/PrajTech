package org.prajval.ControllerLayer;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.prajval.EntityLayer.AdminEntity;
import org.prajval.ServiceLayer.AdminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class AdminController {

	@Autowired
	private AdminService adminService;

	@ResponseBody
	@RequestMapping("/show-admin-login-page")
	public ModelAndView ShowAdminLoginPage(Model m) {
		ModelAndView mv = new ModelAndView();
		mv.setViewName("adminlogin.jsp");
		return mv;
	}

	@ResponseBody
	@RequestMapping("/make-admin")
	public ModelAndView ShowSignupPage(Model m) {
		ModelAndView mv = new ModelAndView();
		mv.setViewName("makeadmin.jsp");
		return mv;
	}
	
	@ResponseBody
	@RequestMapping("/insert-admin-data")
	public ModelAndView MakeAdmin(HttpServletRequest req, HttpServletResponse res) {
		ModelAndView mv = new ModelAndView();
		AdminEntity a = new AdminEntity();
		a.setAdminMail(req.getParameter("AdminMail"));
		a.setPassword(req.getParameter("Password"));
		a.setEnabled(true);
		a.setRole("ADMIN");
		AdminEntity aa = adminService.makeAdmin(a);
		if (aa != null) {
			mv.setViewName("SuccessAdminMake.jsp");
		} else {
			mv.setViewName("FailedtoMakeAdmin.jsp");
		}
		return mv;
	}

	@ResponseBody
	@RequestMapping("/admin-login-page")
	public ModelAndView adminlogin(
			HttpServletRequest req, 
			HttpServletResponse res,
			@RequestParam("AdminMail") String AdminMail, 
			@RequestParam("Password") String Password) {
		ModelAndView mv = new ModelAndView();
		AdminEntity admin = adminService.findByUsernameAndPassword(AdminMail, Password);

		if (admin != null) {
			HttpSession session = req.getSession();
			session.setAttribute("admin", admin);
			mv.setViewName("AfterAdminLoginHomePage.jsp");
		} else {
			mv.setViewName("FailedAdminSignUp.jsp");
		}
		return mv;
	}
	
//	@ResponseBody
//	@RequestMapping("/get-project-list")
//	public ModelAndView listTheProject(HttpServletRequest req, HttpServletResponse res) {
//		ModelAndView mv = new ModelAndView();
//		List<ProjectEntity> projects = projectService.getAllProjects();
//		List<ProjectService> projectServices = new ArrayList<>();
//		
//		for (ProjectEntity project : projects) {
//			ProjectEntity pe = new ProjectEntity();
//			pe.setName(project.getName());
//			pe.setTechnology(project.getTechnology());
//			pe.setDescription(project.getDescription());
//			pe.setZipFileData(new String(project.getZipFileData(), StandardCharsets.UTF_8));
//			pe.setJarFileData(new String(project.getJarFileData(), StandardCharsets.UTF_8));
//			pe.setDocFileData(new String(project.getDocFileData(), StandardCharsets.UTF_8));
//			pe.setVideoFileData(new String(project.getVideoFileData(), StandardCharsets.UTF_8));
//			pe.add(pe);
//		}
//		mv.addObject("projects", projectDtos);
//		mv.setViewName("projects.jsp");
//		return mv;
//	}
//}
}