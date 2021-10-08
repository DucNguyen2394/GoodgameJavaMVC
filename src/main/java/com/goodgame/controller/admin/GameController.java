package com.goodgame.controller.admin;

import java.util.Map;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import com.goodgame.dto.GameDTO;
import com.goodgame.service.CategoryService;
import com.goodgame.service.GameService;
import com.goodgame.service.PlatformService;
import com.goodgame.util.MessageUtils;

@Controller(value = "gameControllerOfAdmin")
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
   public ModelAndView showList(
		   @RequestParam("page") int page,
		   @RequestParam("limit") int limit,
		   HttpServletRequest request,
		   GameDTO model) 
   {
      ModelAndView mav = new ModelAndView("/admin/game/list");
            
      model.setPage(page);
      model.setLimit(limit);
      
      Pageable pageable = new PageRequest(page - 1, limit);
      
      model.setListResult(gameService.findAll(pageable));
      model.setTotalItem(gameService.getTotalItem());
      model.setTotalPage((int) Math.ceil((double) model.getTotalItem() /model.getLimit()));  
      
      HttpSession session = request.getSession();
      if(request.getParameter("message") != null) {
    	  Map<String, String> message = messageUtil.getMessage(request.getParameter("message"));
    	  session.setAttribute("message", message.get("message"));
    	  session.setAttribute("alert", message.get("alert"));
      }
    	     
      mav.addObject("model", model);
      return mav;
   }
   
   @RequestMapping(value = "admin/game/edit", method = RequestMethod.GET)
   public ModelAndView editGame(
		   @RequestParam(value = "id", required = false) Long id, 
		   HttpServletRequest request,
		   GameDTO model) {
      ModelAndView mav = new ModelAndView("/admin/game/edit");
      if(id != null) {
    	  model = gameService.findById(id);
      }
      if(request.getParameter("message") != null) {

    	  Map<String, String> message = messageUtil.getMessage(request.getParameter("message"));
    	  mav.addObject("message", message.get("message"));
    	  mav.addObject("alert", message.get("alert"));
      }
      mav.addObject("categories", categoryService.find());
      mav.addObject("platforms", platformService.findAll());
      mav.addObject("model", model);
      return mav;
   }
   
   
}