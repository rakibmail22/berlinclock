package com.bashir.berlinclock.input;

import com.bashir.berlinclock.input.TimeInputScanner;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.io.ByteArrayInputStream;
import java.time.LocalTime;
import java.util.Optional;

@SpringBootTest
public class TimeInputScannerTest {

	private final TimeInputScanner timeInputScanner;

	@Autowired
	public TimeInputScannerTest(TimeInputScanner timeInputScanner) {
		this.timeInputScanner = timeInputScanner;
	}

	@Test
	public void takeInput_TakesStringAsInput_ReturnsTrimmedString() {
		var inputStrWithSpaces = "   Test Input String     ";
		var inputStream = new ByteArrayInputStream(inputStrWithSpaces.getBytes());

		var result = timeInputScanner.takeInput(inputStream);

		Assertions.assertEquals(inputStrWithSpaces.trim(), result);

	}

	@Test
	public void takeInput_TakesAnythingAsInput_ReturnsItAsString() {
		var inputStr = "This is a test input String";
		var inputStream = new ByteArrayInputStream(inputStr.getBytes());

		var result = timeInputScanner.takeInput(inputStream);

		Assertions.assertEquals(inputStr, result);
	}

	@Test
	public void takeInput_WithEmptyString_ReturnEmptyString(){
		var emptyInputStr = "";
		var inputStream = new ByteArrayInputStream(emptyInputStr.getBytes());

		var result = timeInputScanner.takeInput(inputStream);

		Assertions.assertEquals(emptyInputStr, result);
	}

	@Test
	public void parseTime_WithValidTimeFormat_ReturnsCorrectLocalTime(){
		int hourInt = 12, minuteInt = 45, secondInt = 59;
		var inputTimeStr = "%s:%s:%s".formatted(hourInt, minuteInt, secondInt);

		Optional<LocalTime> resultOptional = timeInputScanner.parseTime(inputTimeStr);

		Assertions.assertTrue(resultOptional.isPresent());
		LocalTime result = resultOptional.get();

		Assertions.assertEquals(hourInt, result.getHour());
		Assertions.assertEquals(minuteInt, result.getMinute());
		Assertions.assertEquals(secondInt, result.getSecond());
	}

	@Test
	public void parseTime_WithInvalidTimeFormat_ReturnEmpty() {
		var inputTimeStr = "59:12:13";

		Optional<LocalTime> resultOptional = timeInputScanner.parseTime(inputTimeStr);

		Assertions.assertTrue(resultOptional.isEmpty());
	}

	@Test
	public void parseTime_WithInValidInputStr_ReturnEmpty(){
		var invalidInputStr = "Invalid String";

		Optional<LocalTime> resultOptional = timeInputScanner.parseTime(invalidInputStr);

		Assertions.assertTrue(resultOptional.isEmpty());
	}
}
