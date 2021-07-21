package com.goodgame.controller.admin;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import com.goodgame.dto.GameDTO;
import com.goodgame.service.CategoryService;
import com.goodgame.service.GameService;
import com.goodgame.service.PlatformService;
import com.goodgame.util.MessageUtils;

@Controller
public class GameController {
	
	@Autowired
	private GameService gameService;
	
	@Autowired
	private CategoryService categoryService;
	
	@Autowired
	private PlatformService platformService;
	
	@Autowired
	private MessageUtils messageUtil;

   @RequestMapping(value = "admin/game/list", method = RequestMethod.GET)
   public ModelAndView showList(@ModelAttribute("model") GameDTO gameModel,HttpServletRequest request) {
      ModelAndView mav = new ModelAndView("/admin/game/list");
      
      gameModel.setListResult(gameService.findAll());
      if(request.getParameter("message") != null) {
//    	  if(request.getParameter("message").equals("update_success")) {
//    		  mav.addObject("message", "update_success");
//    		  mav.addObject("alert", "success");
//    	  }else if(request.getParameter("message").equals("create_success")) {
//    		  mav.addObject("message", "create_success");
//    		  mav.addObject("alert", "success");
//    	  }
//    	  else if(request.getParameter("message").equals("error_system")) {
//    		  mav.addObject("message", "error_system");
//    		  mav.addObject("alert", "danger");
//    	  }
    	  Map<String, String> message = messageUtil.getMessage(request.getParameter("message"));
    	  mav.addObject("message", message.get("message"));
    	  mav.addObject("alert", message.get("alert"));
      }
      mav.addObject("model", gameModel);
      
      return mav;
   }
   
   @RequestMapping(value = "admin/game/edit", method = RequestMethod.GET)
   public ModelAndView editGame(@RequestParam(value = "id", required = false) Long id, HttpServletRequest request) {
      ModelAndView mav = new ModelAndView("/admin/game/edit");
      GameDTO model = new GameDTO();
      if(id != null) {
    	  model = gameService.findById(id);
      }
      if(request.getParameter("message") != null) {
//    	  if(request.getParameter("message").equals("update_success")) {
//    		  mav.addObject("message", "update_success");
//    		  mav.addObject("alert", "success");
//    	  }else if(request.getParameter("message").equals("create_success")) {
//    		  mav.addObject("message", "create_success");
//    		  mav.addObject("alert", "success");
//    	  }
//    	  else if(request.getParameter("message").equals("error_system")) {
//    		  mav.addObject("message", "error_system");
//    		  mav.addObject("alert", "danger");
//    	  }
    	  Map<String, String> message = messageUtil.getMessage(request.getParameter("message"));
    	  mav.addObject("message", message.get("message"));
    	  mav.addObject("alert", message.get("alert"));
      }
      mav.addObject("categories", categoryService.findAl());
      mav.addObject("platforms", platformService.findAll());
      mav.addObject("model", model);
      return mav;
   }
   
   
}