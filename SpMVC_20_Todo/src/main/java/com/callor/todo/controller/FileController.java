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
	 * form���� ������ ������ ������ Controller Ex.. �۽�: ������, ����: �ޱ�
	 * 
	 * MultipartFile�� form���� ���� �̸��� �޴� �̸��� �ٸ� ��찡 �� �ִ�.
	 * @RequestParam�� ����Ͽ� �̸��� �˷���� �Ѵ�
	 */
	@RequestMapping(value = { "/", "" }, method = RequestMethod.POST)
	public String fileUp(String to_title, @RequestParam("to_image") MultipartFile rev_file) {
		
		log.debug("TODO: {}", to_title);
		log.debug("����: {}", rev_file.getOriginalFilename());
		
		return "redirect:/file";
	}

}
