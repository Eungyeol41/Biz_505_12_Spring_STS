package com.callor.finals;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.callor.finals.model.LoginUser;

@Controller
@RequestMapping(value = "/user")
public class UserController {
	
	/**
	 * RequestBody�� fetch�� ����Ͽ� JSON �����͸� ������ ��
	 * VO(DTO) ��ü�� �ڵ����� ��ȯ�Ͽ� ����ִ� �����̴�
	 * ��, RequestBody�� �Ű������� ���� �������� �� ���� ����� �� �ִ�.
	 */
	@ResponseBody
	@RequestMapping(value = "/login", method = RequestMethod.POST)
	public String login(HttpSession session, @RequestBody LoginUser loginUser, String aaa) {
		
		/**
		 * Server���� loginUser ��ü �����͸� �����ϰ�
		 * Ŭ���̾�Ʈ�� ���¸� �����ϱ� ���Ͽ� �غ��϶�!
		 */
		session.setAttribute("USER", loginUser);
		
		return loginUser.getUsername();
	}
	
	@ResponseBody
	@RequestMapping(value = "/loginOK", method = RequestMethod.POST)
	public String loginOk(HttpSession session) {
		/**
		 * session�� ������ ���¿����� Ŭ���̾�Ʈ�� ������ URL ��û�� �ϸ�
		 * �������� �ڵ����� session ID�� Http �������� body�� ��Ƽ� ������ �����Ѵ�.
		 * 
		 * ���������� ���޹��� session ID�� ��ȿ�� ���� ���ο��� �Ǵ��� �� 
		 * 	��ȿ�� ID�̸� HttpSession���κ��� ����� Attribute�� getter �� �� �ֵ��� ����Ѵ�.
		 */
		LoginUser loginUser = (LoginUser) session.getAttribute("USER");
		return loginUser.getUsername();
	}

}
