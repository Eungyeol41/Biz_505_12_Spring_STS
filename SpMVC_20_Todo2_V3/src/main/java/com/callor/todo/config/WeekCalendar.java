package com.callor.todo.config;

import java.time.DayOfWeek;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.time.temporal.TemporalAdjusters;
import java.util.Locale;

public class WeekCalendar {
	
	public static void main(String[] args) {
		
		// 현재 날짜 기준 이번주 일요일
	      LocalDateTime preSunDay = LocalDateTime.now().with(TemporalAdjusters.previous(DayOfWeek.SUNDAY));
	      System.out.println("이번주 일요일 :"+ preSunDay.toString());

	      // 현재 날짜 기준 다음주 일요일
	      LocalDateTime nextSunDay = LocalDateTime.now().with(TemporalAdjusters.next(DayOfWeek.SUNDAY));
	      System.out.println("다음주 일요일 : " + nextSunDay.toString());

	      System.out.println("=".repeat(50));
	      System.out.println("이번주 월요일 부터");
	      System.out.println("-".repeat(50));
	      
	      // 현재 날짜
	      LocalDateTime getNowDate = LocalDateTime.now();
	      
	      // 2021-12-26 일요일 오후 17시 08분
	      DateTimeFormatter dateFormat = DateTimeFormatter
	            .ofPattern("yyyy-MM-dd E요일 a HH시 mm분")
	            .withLocale(Locale.forLanguageTag("ko"));

	      // 오늘부터 20일간 날짜 보이기
	      for (int i = 0; i < 20; i++) {
	         System.out.println(getNowDate.plusDays(i).format(dateFormat));
	      }
	      System.out.println("=".repeat(50));

	      /**
	       * formatter 를 사용하여 문자열형 날짜로 변환하고
	       * 같은 formatter 를 사용하여 문자열을 LocalDateTime 형식으로 변환한다
	       */
	      String curDate = getNowDate.format(dateFormat);
	      System.out.println(LocalDateTime.parse(curDate,dateFormat));
		
		
	}

}
