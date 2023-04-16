package com.bashir.berlinclock.core;

import java.util.List;

import static com.bashir.berlinclock.core.BerlinClockDisplayState.OFF;
import static com.bashir.berlinclock.core.BerlinClockDisplayState.RED;
import static com.bashir.berlinclock.core.BerlinClockDisplayState.YELLOW;

public class BerlinClockConverter {

	public static List<String> convertHour(int hour) {
		int firstRowTurnedOnLight = hour / 5;
		int secondRowTurnedOnLight = hour % 5;

		return List.of(
				getRowString(firstRowTurnedOnLight, RowType.HOUR, 4),
				getRowString(secondRowTurnedOnLight, RowType.HOUR, 4)
		);
	}

	public static List<String> convertMinute(int minute) {
		int firstRowTurnedOnLight = minute / 5;
		int secondRowTurnedOnLight = minute % 5;

		return List.of(
				getRowString(firstRowTurnedOnLight, RowType.MINUTE_1ST_ROW, 11),
				getRowString(secondRowTurnedOnLight, RowType.MINUTE_2ND_ROW, 4)
		);
	}

	public static String convertSecond(int second) {
		return second % 2 == 0 ? YELLOW : OFF;
	}

	private static boolean isIndexDenotesQuarterOfHour(int minuteFirstRowIndex) {
		return (minuteFirstRowIndex + 1) % 3 == 0;
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
