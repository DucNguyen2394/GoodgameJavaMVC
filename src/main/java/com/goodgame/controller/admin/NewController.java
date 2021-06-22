package com.goodgame.controller.admin;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class NewController {

   @RequestMapping(value = "admin/game/list", method = RequestMethod.GET)
   public ModelAndView showList() {
      ModelAndView mav = new ModelAndView("/admin/game/list");
      return mav;
   }
   
   @RequestMapping(value = "admin/game/edit", method = RequestMethod.GET)
   public ModelAndView editNew() {
      ModelAndView mav = new ModelAndView("/admin/game/edit");
      return mav;
   }
}
