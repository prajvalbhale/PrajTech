package org.prajval.ControllerLayer;

import java.io.IOException;
import java.util.Base64;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.tomcat.util.http.fileupload.impl.FileSizeLimitExceededException;
import org.prajval.EntityLayer.ProjectEntity;
import org.prajval.ServiceLayer.ProjectService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class ProjectController {

	@Autowired
	private ProjectService projectService;
	
	@ResponseBody
	@RequestMapping("/insert-project")
	public ModelAndView InsertProject(
			HttpServletRequest req, 
			HttpServletResponse res,
			@RequestParam("name") String name,
            @RequestParam("technology") String technology,
            @RequestParam("description") String description,
            @RequestParam("zipFileData") MultipartFile zipFileData,
            @RequestParam("jarFileData") MultipartFile jarFileData,
            @RequestParam("docFileData") MultipartFile docFileData,
            @RequestParam("videoFileData") MultipartFile videoFileData) throws IOException, FileSizeLimitExceededException {
		
		ModelAndView mv = new ModelAndView();
		
		ProjectEntity pe = new ProjectEntity();
		pe.setName(name);
		pe.setTechnology(technology);
		pe.setDescription(description);
		pe.setZipFileData(zipFileData.getBytes());
		pe.setJarFileData(jarFileData.getBytes());
		pe.setDocFileData(docFileData.getBytes());
		pe.setVideoFileData(videoFileData.getBytes());
		
		ProjectEntity uu = projectService.insertProject(pe);
				
		if (uu != null) {
			mv.setViewName("SuccessProjectInserted.jsp");
		} else {
			mv.setViewName("FailedProjectInserted.jsp");
		}
		return mv;
	}
	
	@ResponseBody
	@RequestMapping("/push-full-project")
	public ModelAndView ShowPushPage(Model m) {
		ModelAndView mv = new ModelAndView();
		mv.setViewName("Pushproject.jsp");
		return mv;
	}
	
	@ResponseBody
	@RequestMapping("/enable-disable")
	public ModelAndView ShowEnableDisablePage(Model m) {
		ModelAndView mv = new ModelAndView();
		mv.setViewName("EnbDis.jsp");
		return mv;
	}
	
	@ResponseBody
	@RequestMapping("/show-project-details-to-admin")
	public ModelAndView UnvalidData(Model m) {
		ModelAndView mv = new ModelAndView();
		List<ProjectEntity> projectlist = projectService.getAll();
		mv.addObject("projectlist", projectlist);
		mv.setViewName("EnbDis.jsp");
		return mv;
	}
	@ResponseBody
	@RequestMapping("/downoad-project/{id}")
	public ModelAndView download(HttpServletRequest req, HttpServletResponse res) {
		ModelAndView mv = new ModelAndView();
		
		return mv;
	}
	
	@GetMapping("/display-project/{id}")
	public ModelAndView displayProject(@PathVariable("id") long id) {
	   ProjectEntity project = projectService.getProjectById(id);
	   
	   if (project != null) {
	      // Convert binary data to Base64-encoded string
	      String zipFileData = Base64.getEncoder().encodeToString(project.getZipFileData());
	      String jarFileData = Base64.getEncoder().encodeToString(project.getJarFileData());
	      String docFileData = Base64.getEncoder().encodeToString(project.getDocFileData());
	      String videoFileData = Base64.getEncoder().encodeToString(project.getVideoFileData());
	      
	      ModelAndView mv = new ModelAndView();
	      mv.addObject("project", project);
	      mv.addObject("zipFileData", zipFileData);
	      mv.addObject("jarFileData", jarFileData);
	      mv.addObject("docFileData", docFileData);
	      mv.addObject("videoFileData", videoFileData);
	      mv.setViewName("display-project.jsp");
	      return mv;
	   } else {
	      // Handle case where project is not found
	      ModelAndView mv = new ModelAndView("error.jsp");
	      mv.addObject("errorMessage", "Project not found");
	      return mv;
	   }
	}
}
