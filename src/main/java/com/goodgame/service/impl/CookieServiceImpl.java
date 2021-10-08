package com.goodgame.service.impl;

import java.util.Base64;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.goodgame.service.CookieService;

@Service
public class CookieServiceImpl implements CookieService{

	@Autowired
	HttpServletRequest request;
	
	@Autowired
	HttpServletResponse response;
	
	@Override
	public Cookie create(String name, String value, int days) {
		String encodeValue = Base64.getEncoder().encodeToString(value.getBytes());		
		Cookie cookie = new Cookie(name, encodeValue);
		cookie.setMaxAge(days*24*60*60);
		cookie.setPath("/");
		response.addCookie(cookie);
		return cookie;
	}

	@Override
	public Cookie read(String name) {
		Cookie[] cookies = request.getCookies();
		if(cookies != null) {
			for(Cookie cookie : cookies) {
				if(cookie.getName().equalsIgnoreCase(name)) {
					String decodeValue = new String(Base64.getDecoder().decode(cookie.getValue()));
					cookie.setValue(decodeValue);
					return cookie;
				}
			}
		}
		return null;
	}

	@Override
	public void delete(String name) {
		this.create(name, "", 0);
	}

}
