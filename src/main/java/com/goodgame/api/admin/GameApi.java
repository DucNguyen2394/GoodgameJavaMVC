package com.goodgame.api.admin;

import java.util.Base64;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import com.goodgame.dto.UploadFileDTO;
import com.goodgame.repository.GameRepository;
import com.goodgame.util.UploadFileUtils;

@RestController(value = "GameApiOfAdmin")
public class GameApi {
	
	@Autowired
	UploadFileUtils uploadFileUtils;
	
	@Autowired
	GameRepository gameRepository;
	
	@PostMapping("/api/upload")
	private ResponseEntity<Void> uploadFile(@RequestBody UploadFileDTO uploadFileDTO){
		byte[] decodeBase64 = Base64.getDecoder().decode(uploadFileDTO.getBase64().getBytes());
		
		System.out.println("link anh: " + decodeBase64);
		
		uploadFileUtils.writeOrUpdate(decodeBase64,"thumbnail/" + uploadFileDTO.getName());
		
//		gameRepository.save();
		return ResponseEntity.noContent().build();
	}
}
