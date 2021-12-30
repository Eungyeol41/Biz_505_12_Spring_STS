package com.callor.todo.config;

import java.time.DayOfWeek;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.time.temporal.TemporalAdjusters;
import java.util.Locale;

public class WeekCalendar {
	
	public static void main(String[] args) {
		
		// ���� ��¥ ���� �̹��� �Ͽ���
	      LocalDateTime preSunDay = LocalDateTime.now().with(TemporalAdjusters.previous(DayOfWeek.SUNDAY));
	      System.out.println("�̹��� �Ͽ��� :"+ preSunDay.toString());

	      // ���� ��¥ ���� ������ �Ͽ���
	      LocalDateTime nextSunDay = LocalDateTime.now().with(TemporalAdjusters.next(DayOfWeek.SUNDAY));
	      System.out.println("������ �Ͽ��� : " + nextSunDay.toString());

	      System.out.println("=".repeat(50));
	      System.out.println("�̹��� ������ ����");
	      System.out.println("-".repeat(50));
	      
	      // ���� ��¥
	      LocalDateTime getNowDate = LocalDateTime.now();
	      
	      // 2021-12-26 �Ͽ��� ���� 17�� 08��
	      DateTimeFormatter dateFormat = DateTimeFormatter
	            .ofPattern("yyyy-MM-dd E���� a HH�� mm��")
	            .withLocale(Locale.forLanguageTag("ko"));

	      // ���ú��� 20�ϰ� ��¥ ���̱�
	      for (int i = 0; i < 20; i++) {
	         System.out.println(getNowDate.plusDays(i).format(dateFormat));
	      }
	      System.out.println("=".repeat(50));

	      /**
	       * formatter �� ����Ͽ� ���ڿ��� ��¥�� ��ȯ�ϰ�
	       * ���� formatter �� ����Ͽ� ���ڿ��� LocalDateTime �������� ��ȯ�Ѵ�
	       */
	      String curDate = getNowDate.format(dateFormat);
	      System.out.println(LocalDateTime.parse(curDate,dateFormat));
		
		
	}

}
