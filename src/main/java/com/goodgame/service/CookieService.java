package com.goodgame.service;

import javax.servlet.http.Cookie;

public interface CookieService {
	
	Cookie create(String name,String value,int days);
	
	Cookie read(String name);
	
	void delete(String name);
}
