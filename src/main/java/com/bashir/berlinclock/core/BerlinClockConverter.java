package com.bashir.berlinclock.core;

import java.util.List;

import static com.bashir.berlinclock.core.BerlinClockDisplayState.OFF;
import static com.bashir.berlinclock.core.BerlinClockDisplayState.RED;
import static com.bashir.berlinclock.core.BerlinClockDisplayState.YELLOW;

public class BerlinClockConverter {

	/**
	 * @param hour valid hour integer
	 * @return {@code List<String>} containing two row of converted String representation for hour sequentially
	 */
	public static List<String> convertHour(int hour) {
		validateRange(hour, 0, 23, "Hour");

		int firstRowTurnedOnLight = hour / 5;
		int secondRowTurnedOnLight = hour % 5;

		return List.of(
				getRowString(firstRowTurnedOnLight, RowType.HOUR, 4),
				getRowString(secondRowTurnedOnLight, RowType.HOUR, 4)
		);
	}

	/**
	 * @param minute valid minute integer
	 * @return {@code List<String>} containing two row of converted String representation for minute sequentially
	 */
	public static List<String> convertMinute(int minute) {
		validateRange(minute, 0, 59, "Minute");

		int firstRowTurnedOnLight = minute / 5;
		int secondRowTurnedOnLight = minute % 5;

		return List.of(
				getRowString(firstRowTurnedOnLight, RowType.MINUTE_1ST_ROW, 11),
				getRowString(secondRowTurnedOnLight, RowType.MINUTE_2ND_ROW, 4)
		);
	}

	/**
	 * @param second valid second integer
	 * @return {@code String} converted String representation for second
	 */
	public static String convertSecond(int second) {
		validateRange(second, 0, 59, "Second");
		return second % 2 == 0 ? YELLOW : OFF;
	}

	private static void validateRange(int input, int min, int max, String paramType) {
		if (input < min || input > max) {
			throw new IllegalArgumentException("Invalid %s: %s".formatted(paramType, input));
		}
	}

	private static String getRowString(int numberOfTurnedOnLight, RowType rowType, int numberOfColumns) {
		var sb = new StringBuilder();

		for (int i = 0; i < numberOfColumns; ++i) {
			if (numberOfTurnedOnLight > 0) {
				sb.append(resolveTurnedOnLightColor(rowType, i + 1));
				numberOfTurnedOnLight--;
			} else {
				sb.append(OFF);
			}
		}

		return sb.toString();
	}

	private static String resolveTurnedOnLightColor(RowType rowType, int lightPosition) {
		switch (rowType) {
			case HOUR -> {
				return RED;
			}
			case MINUTE_1ST_ROW -> {
				return lightPosition % 3 == 0 ? RED : YELLOW;
			}
			case MINUTE_2ND_ROW -> {
				return YELLOW;
			}
			default -> throw new IllegalArgumentException("Unsupported row type");
		}
	}

	private enum RowType {
		HOUR,
		MINUTE_1ST_ROW,
		MINUTE_2ND_ROW;
	}
}
