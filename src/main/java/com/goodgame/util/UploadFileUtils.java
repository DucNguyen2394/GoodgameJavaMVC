package com.goodgame.util;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import org.apache.commons.lang.StringUtils;
import org.springframework.stereotype.Component;

@Component
public class UploadFileUtils {
	
	private final String root = "C:\\usr\\var\\";
	
	public void writeOrUpdate(byte[] bytes, String path) {
		
		File file = new File(StringUtils.substringBeforeLast(root + path, "/"));
		if(!file.exists()) {
			file.mkdir();
		}

		FileOutputStream fos = null;
		try{
			fos = new FileOutputStream(new File(root + path));
			fos.write(bytes);
		} catch (IOException e) {		
			e.printStackTrace();
		} finally {
			try {
				fos.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		
	}
}
