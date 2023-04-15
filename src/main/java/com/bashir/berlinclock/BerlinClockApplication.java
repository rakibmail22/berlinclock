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
	public void run(String... args) throws Exception {
		String inputString = timeInputScanner.takeInput(System.in);
		timeInputScanner.parseTime(inputString)
		                .ifPresentOrElse(time -> System.out.printf("Hour: %s, Minute: %s, Second %s%n",
		                                                           time.getHour(),
		                                                           time.getMinute(),
		                                                           time.getSecond()),
		                                 () -> System.out.println("Invalid Input String"));


	}
}
