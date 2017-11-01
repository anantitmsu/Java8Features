package com.lamda;

import java.time.Instant;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.Month;
import java.time.Period;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
import java.time.temporal.TemporalAdjusters;
import java.util.Date;

public class TimeApi {

	public static void main(String[] args) {

		System.out.println("Instant.now() == " + Instant.now());
		System.out.println("LocalDate.now() == " + LocalDate.now());

		System.out.println("LocalDate.of(2017, Month.NOVEMBER, 1) == "
				+ LocalDate.of(2017, Month.NOVEMBER, 1));
		System.out.println("Asia Kolkata now == "
				+ LocalDate.now(ZoneId.of("Asia/Kolkata")));

		System.out.println("365th day from base date = "
				+ LocalDate.ofEpochDay(0));
		System.out.println(LocalDate.ofYearDay(2017, 14));

		System.out.println("LocalTime.now() == " + LocalTime.now());
		System.out.println("local time zone id == "
				+ LocalTime.now(ZoneId.of("Asia/Kolkata")));

		System.out.println("LocalDateTime.now() == "
				+ LocalDateTime.now(ZoneId.of("Asia/Kolkata")));

		System.out.println("Instant now = " + Instant.now());

		/**
		 * Utility API
		 */

		LocalDate today = LocalDate.now();

		System.out.println("leap year check : " + today.isLeapYear());

		System.out.println("is before = "
				+ today.isBefore(LocalDate.of(2016, 01, 14)));

		System.out.println("is before = "
				+ LocalDate.of(2016, 01, 14).isBefore(LocalDate.now()));

		System.out.println("Date to time now" + today.atTime(LocalTime.now()));

		System.out.println("Plus 10 days " + today.plusDays(30));
		System.out.println("Minus 10 days " + today.minusDays(10));

		System.out.println("Minus 10 weeks " + today.minusWeeks(10));

		System.out.println("First day of month = "
				+ today.with(TemporalAdjusters.firstDayOfMonth()));

		LocalDate lastDayOfYear = today.with(TemporalAdjusters.lastDayOfYear());

		System.out.println("lastDayOfYear = " + lastDayOfYear);

		Period period = today.until(lastDayOfYear);
		System.out.println("Period format : " + period);

		System.out.println("Months remaining in this period-Year = "
				+ period.getMonths());

		/**
		 * Date Parser Format examples
		 */

		LocalDateTime now = LocalDateTime.now();

		System.out.println("Default = " + today);

		System.out.println("d::MMM:uuuu = "
				+ today.format(DateTimeFormatter.ofPattern("d::MMM:uuuu")));

		System.out.println("BASIC_ISO_DATE = "
				+ today.format(DateTimeFormatter.BASIC_ISO_DATE));

		System.out
				.println("d-MMM-uuuu HH:mm:ss = "
						+ now.format(DateTimeFormatter
								.ofPattern("d-MMM-uuuu HH:mm:ss")));

		/**
		 * Java 8 Legacy Date Time Support
		 */

		Date dt = Date.from(Instant.now());

		System.out.println("dt == " + dt);

	}
}
