package com.bashir.berlinclock.input;

import org.springframework.stereotype.Service;

import java.io.InputStream;
import java.time.DateTimeException;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.Optional;
import java.util.Scanner;

@Service
public class TimeInputScannerImpl implements TimeInputScanner {

	@Override
	public String takeInput(InputStream inputStream) {
		System.out.println("Please input the time string: ");
		Scanner sc = new Scanner(inputStream);
		String input = "";
		if (sc.hasNextLine()) {
			input = sc.nextLine();
		}

		return input.trim();
	}

	@Override
	public Optional<LocalTime> parseTime(String timeStr) {
		try {
			return Optional.of(LocalTime.parse(timeStr, DateTimeFormatter.ISO_LOCAL_TIME));
		} catch (DateTimeException ex) {
			return Optional.empty();
		}
	}
}
