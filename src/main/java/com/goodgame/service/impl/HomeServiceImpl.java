package com.goodgame.service.impl;

import java.util.ArrayList;
import java.util.List;
import org.springframework.stereotype.Service;
import com.goodgame.service.HomeService;

@Service
public class HomeServiceImpl implements HomeService  {

	public List<String> loadMenu() {
		List<String> menus = new ArrayList<String>();
		menus.add("Blog java web");
		menus.add("Spring MVC");
		menus.add("Liên hệ");
		menus.add("Thanh toán");
		return menus;
	}

	

}
