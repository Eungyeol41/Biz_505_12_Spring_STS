package com.callor.todo.service.impl;

import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;

import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;

import com.callor.todo.config.QualifierConfig;
import com.callor.todo.service.FileServiceABS;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service(QualifierConfig.SERVICE.FILE_SERVICE_V1)
public class FileServiceImplV1 extends FileServiceABS {

	/**
	 * fileUp()
	 * 1���� ������ ������ Ư�� ����(fileUpPath)�� ���ε��ϱ�
	 * 
	 * 1. fileUpPath�� ���������� �ִ� �� �˻�
	 * 2. ������ ������ ���� �����ϱ�
	 * 3. �������� �̸��� ���ļ� ���ε� ���� �ʵ��� ���� ��å
	 * 		UUID + �����̸� �������� ���ϸ��� �����Ͽ� ����
	 * 4. ������ �Ϸ�Ǹ� ����� ���ϸ��� return
	 */
	@Override
	public Map<String, String> fileUp(MultipartFile file) {
		// TODO Auto-generated method stub
		
		log.debug("���Ͼ��ε� path: {}", this.fileUpPath);
		
		/*
		 *  ���������� null�̸� null�� return�ϴ� �ǵ�.. �ڲ� �̰� �ǳʶپ�����ٰ� ��..
		 *  if(file == null) {
		 *  	return null;
		 *  }
		 */
		// ���������� null�̸� �� �̻� �������� ����
		if(file.isEmpty()) {
			log.debug("���Ͼ��� path : {}", this.fileUpPath);
			return null;
		}
		
		// ���ε� ������ �˻��ϱ�
		File dir = new File(fileUpPath);
		// ���ε��� ������ ������
		if(!dir.exists()) {
			dir.mkdirs(); // ���� �����ϱ�
		}
		
		String strUUID = UUID.randomUUID().toString();
		// ���� �����̸� ����
		String originalFileName = file.getOriginalFilename();
		// UUID + "-" + �����̸�
		String saveFileName = String.format("%s-%s", strUUID, originalFileName);
		
		// ������ ������ �����̸��� �Ű������� �����Ͽ�
		// ������ �����ϱ� ���Ͽ� File ��ü �����ϱ�
		File uploadFile = new File(fileUpPath, saveFileName);
		try {
			file.transferTo(uploadFile);
		} catch (IllegalStateException | IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		Map<String, String> retFileName = new HashMap<String, String>();
		
		retFileName.put(QualifierConfig.FILE_SERVICE.ORIGINAL, originalFileName);
		retFileName.put(QualifierConfig.FILE_SERVICE.SAVENAME, saveFileName);
				
		return retFileName;
	}

	@Override
	public List<Map<String, String>> filesUp(MultipartHttpServletRequest files) {
		// TODO Auto-generated method stub
		return null;
	}

}
