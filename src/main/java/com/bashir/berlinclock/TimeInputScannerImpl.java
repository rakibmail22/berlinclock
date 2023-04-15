package com.bashir.berlinclock;

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
		return null;
	}

	@Override
	public Optional<LocalTime> parseTime(String timeStr) {
		return null;
	}
}
