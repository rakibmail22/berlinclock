package com.bashir.berlinclock.core;

import com.bashir.berlinclock.core.BerlinClockConverter;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.List;

import static com.bashir.berlinclock.core.BerlinClockDisplayState.OFF;
import static com.bashir.berlinclock.core.BerlinClockDisplayState.RED;
import static com.bashir.berlinclock.core.BerlinClockDisplayState.YELLOW;

public class BerlinClockConverterTest {

	@Test
	public void convertHour_WithZeoHourInput_ReturnsCorrectResult() {
		var inputZeroInt = 0;

		List<String> result = BerlinClockConverter.convertHour(inputZeroInt);

		Assertions.assertEquals(OFF.repeat(4), result.get(0));
		Assertions.assertEquals(OFF.repeat(4), result.get(1));
	}

	@Test
	public void convertHour_WithThreeHourInput_ReturnsCorrectResult() {
		var inputThreeHoursInt = 3;

		List<String> result = BerlinClockConverter.convertHour(inputThreeHoursInt);

		Assertions.assertEquals(OFF.repeat(4), result.get(0));
		Assertions.assertEquals("%s%s%s%s".formatted(RED, RED, RED, OFF), result.get(1));
	}

	@Test
	public void convertHour_WithFourHourInput_ReturnsCorrectResult() {
		var inputThreeHoursInt = 4;

		List<String> result = BerlinClockConverter.convertHour(inputThreeHoursInt);

		Assertions.assertEquals(OFF.repeat(4), result.get(0));
		Assertions.assertEquals("%s%s%s%s".formatted(RED, RED, RED, RED), result.get(1));
	}

	@Test
	public void convertHour_WithFiveHourInput_ReturnsCorrectResult() {
		var inputThreeHoursInt = 5;

		List<String> result = BerlinClockConverter.convertHour(inputThreeHoursInt);

		Assertions.assertEquals("%s%s%s%s".formatted(RED, OFF, OFF, OFF), result.get(0));
		Assertions.assertEquals(OFF.repeat(4), result.get(1));
	}

	@Test
	public void convertHour_WithSevenHourInput_ReturnsCorrectResult() {
		var inputThreeHoursInt = 7;

		List<String> result = BerlinClockConverter.convertHour(inputThreeHoursInt);

		Assertions.assertEquals("%s%s%s%s".formatted(RED, OFF, OFF, OFF), result.get(0));
		Assertions.assertEquals("%s%s%s%s".formatted(RED, RED, OFF, OFF), result.get(1));
	}

	@Test
	public void convertHour_WithSevenTeenHourInput_ReturnsCorrectResult() {
		var inputThreeHoursInt = 17;

		List<String> result = BerlinClockConverter.convertHour(inputThreeHoursInt);

		Assertions.assertEquals("%s%s%s%s".formatted(RED, RED, RED, OFF), result.get(0));
		Assertions.assertEquals("%s%s%s%s".formatted(RED, RED, OFF, OFF), result.get(1));
	}

	@Test
	public void convertHour_WithTwentyThreeHourInput_ReturnsCorrectResult() {
		var inputThreeHoursInt = 23;

		List<String> result = BerlinClockConverter.convertHour(inputThreeHoursInt);

		Assertions.assertEquals("%s%s%s%s".formatted(RED, RED, RED, RED), result.get(0));
		Assertions.assertEquals("%s%s%s%s".formatted(RED, RED, RED, OFF), result.get(1));
	}

	@Test
	public void convertMinute_WithZeroMinute_ReturnsCorrectResult() {
		var inputMinute = 0;

		List<String> result = BerlinClockConverter.convertMinute(inputMinute);

		Assertions.assertEquals(OFF.repeat(11), result.get(0));
		Assertions.assertEquals(OFF.repeat(4), result.get(1));
	}

	@Test
	public void convertMinute_WithLessThanFiftyFiveMinute_ReturnsCorrectResult() {
		var inputMinute = 47;

		List<String> result = BerlinClockConverter.convertMinute(inputMinute);

		Assertions.assertEquals(
				"%s%s%s%s%s%s%s%s%s%s%s".formatted(YELLOW,
				                                   YELLOW,
				                                   RED,
				                                   YELLOW,
				                                   YELLOW,
				                                   RED,
				                                   YELLOW,
				                                   YELLOW,
				                                   RED,
				                                   OFF,
				                                   OFF),
				result.get(0)
		);
		Assertions.assertEquals("%s%s%s%s".formatted(YELLOW, YELLOW, OFF, OFF), result.get(1));
	}

	@Test
	public void convertMinute_WithFiftyFiveMinute_ReturnsCorrectResult() {
		var inputMinute = 55;

		List<String> result = BerlinClockConverter.convertMinute(inputMinute);

		Assertions.assertEquals(
				"%s%s%s%s%s%s%s%s%s%s%s".formatted(YELLOW,
				                                   YELLOW,
				                                   RED,
				                                   YELLOW,
				                                   YELLOW,
				                                   RED,
				                                   YELLOW,
				                                   YELLOW,
				                                   RED,
				                                   YELLOW,
				                                   YELLOW),
				result.get(0)
		);
		Assertions.assertEquals("%s%s%s%s".formatted(OFF, OFF, OFF, OFF), result.get(1));
	}

	@Test
	public void convertMinute_WithSeventeenMinute_ReturnsCorrectResult() {
		var inputMinute = 17;

		List<String> result = BerlinClockConverter.convertMinute(inputMinute);

		Assertions.assertEquals(
				"%s%s%s%s%s%s%s%s%s%s%s".formatted(YELLOW,
				                                   YELLOW,
				                                   RED,
				                                   OFF,
				                                   OFF,
				                                   OFF,
				                                   OFF,
				                                   OFF,
				                                   OFF,
				                                   OFF,
				                                   OFF),
				result.get(0)
		);
		Assertions.assertEquals("%s%s%s%s".formatted(YELLOW, YELLOW, OFF, OFF), result.get(1));
	}

	@Test
	public void convertMinute_WithFourteenMinute_ReturnsCorrectResult() {
		var inputMinute = 14;

		List<String> result = BerlinClockConverter.convertMinute(inputMinute);

		Assertions.assertEquals(
				"%s%s%s%s%s%s%s%s%s%s%s".formatted(YELLOW,
				                                   YELLOW,
				                                   OFF,
				                                   OFF,
				                                   OFF,
				                                   OFF,
				                                   OFF,
				                                   OFF,
				                                   OFF,
				                                   OFF,
				                                   OFF),
				result.get(0)
		);
		Assertions.assertEquals("%s%s%s%s".formatted(YELLOW, YELLOW, YELLOW, YELLOW), result.get(1));
	}

	@Test
	public void convertSecond_WithEvenNumber_ReturnCorrectResult() {
		var inputSecond = 22;

		String result = BerlinClockConverter.convertSecond(inputSecond);

		Assertions.assertEquals(YELLOW, result);
	}

	@Test
	public void convertSecond_WithOddNumber_ReturnCorrectResult() {
		var inputSecond = 21;

		String result = BerlinClockConverter.convertSecond(inputSecond);

		Assertions.assertEquals(OFF, result);
	}

	@Test
	public void convertSecond_WithZero_ReturnCorrectResult() {
		var inputSecond = 0;

		String result = BerlinClockConverter.convertSecond(inputSecond);

		Assertions.assertEquals(YELLOW, result);
	}
}
