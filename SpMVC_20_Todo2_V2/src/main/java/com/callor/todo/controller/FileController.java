package com.callor.todo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Controller
@RequestMapping(value = "/file")
public class FileController {

	@RequestMapping(value = { "/", "" }, method = RequestMethod.GET)
	public String fileUp() {
		return "write";
	}

	/**
	 * form에서 전달한 파일을 수신할 Controller Ex.. 송신: 보내기, 수신: 받기
	 * 
	 * MultipartFile은 form에서 보낸 이름과 받는 이름이 다른 경우가 꽤 있다.
	 * @RequestParam을 사용하여 이름을 알려줘야 한다
	 */
	@RequestMapping(value = { "/", "" }, method = RequestMethod.POST)
	public String fileUp(String to_title, @RequestParam("to_image") MultipartFile rev_file) {
		
		log.debug("TODO: {}", to_title);
		log.debug("파일: {}", rev_file.getOriginalFilename());
		
		return "redirect:/file";
	}

}
