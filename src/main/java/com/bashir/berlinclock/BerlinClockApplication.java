package com.bashir.berlinclock;

import lombok.RequiredArgsConstructor;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@RequiredArgsConstructor
@SpringBootApplication
public class BerlinClockApplication implements CommandLineRunner {

	private final TimeInputScanner timeInputScanner;

	public static void main(String[] args) {
		SpringApplication.run(BerlinClockApplication.class, args);
	}

	@Override
	public void run(String... args) {
		String inputString = timeInputScanner.takeInput(System.in);
		String outputString = timeInputScanner.parseTime(inputString)
		                                      .map(time -> new BerlinClockDisplay.BerlinClockDisplayBuilder()
				                                      .hour(time.getHour())
				                                      .minute(time.getMinute())
				                                      .secod(time.getSecond())
				                                      .build())
		                                      .map(BerlinClockDisplay::display)
		                                      .orElseGet(() -> "Invalid Input");

		System.out.println(outputString);
	}
}
