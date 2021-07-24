package com.goodgame.api.admin;

import java.io.File;
import java.util.Base64;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import com.goodgame.dto.UploadFileDTO;
import com.goodgame.util.UploadFileUtils;

@RestController(value = "GameApiOfAdmin")
public class GameApi {
	
	@Autowired
	UploadFileUtils uploadFileUtils;
	
	@PostMapping("/api/upload")
	private ResponseEntity<Void> uploadFile(@RequestBody UploadFileDTO uploadFileDTO){
		byte[] decodeBase64 = Base64.getDecoder().decode(uploadFileDTO.getBase64().getBytes());
		
		uploadFileUtils.writeOrUpdate(decodeBase64,"/thumbnail" + File.separator + uploadFileDTO.getName());
		return ResponseEntity.noContent().build();
	}
}
