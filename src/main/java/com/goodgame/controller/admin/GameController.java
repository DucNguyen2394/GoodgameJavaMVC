package com.goodgame.controller.admin;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.goodgame.model.GameModel;
import com.goodgame.service.IGameService;

@Controller(value = "gameControllerOfAdmin")
public class GameController {
	
	@Autowired
	private IGameService gameService;

   @RequestMapping(value = "admin/game/list", method = RequestMethod.GET)
   public ModelAndView showList(@ModelAttribute("model") GameModel gameModel) {
      ModelAndView mav = new ModelAndView("/admin/game/list");
      
      gameModel.setListResult(gameService.findAll());
      
      mav.addObject("model", gameModel);
      
      return mav;
   }
   
   @RequestMapping(value = "admin/game/edit", method = RequestMethod.GET)
   public ModelAndView editGame() {
      ModelAndView mav = new ModelAndView("/admin/game/edit");
      return mav;
   }
}