package com.goodgame.controller.admin;

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

@Controller
public class GameController {
	
	@Autowired
	private GameService gameService;
	
	@Autowired
	private CategoryService categoryService;

   @RequestMapping(value = "admin/game/list", method = RequestMethod.GET)
   public ModelAndView showList(@ModelAttribute("model") GameDTO gameModel) {
      ModelAndView mav = new ModelAndView("/admin/game/list");
      
      gameModel.setListResult(gameService.findAll());
      
      mav.addObject("model", gameModel);
      
      return mav;
   }
   
   @RequestMapping(value = "admin/game/edit", method = RequestMethod.GET)
   public ModelAndView editGame(@RequestParam(value = "id", required = false) Long id) {
      ModelAndView mav = new ModelAndView("/admin/game/edit");
      GameDTO model = new GameDTO();
      if(id != null) {
    	  model = gameService.findById(id);
      }
      mav.addObject("categories", categoryService.findAll());
      mav.addObject("model", model);
      return mav;
   }
   
   
}