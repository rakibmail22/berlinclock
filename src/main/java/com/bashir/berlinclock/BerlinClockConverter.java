package com.bashir.berlinclock;

import java.util.List;

import static com.bashir.berlinclock.BerlinClockDisplayState.*;
import static com.bashir.berlinclock.BerlinClockDisplayState.OFF;
import static com.bashir.berlinclock.BerlinClockDisplayState.RED;

public class BerlinClockConverter {

	public static List<String> convertHour(int hour) {
		int firstRow = hour / 5;
		int secondRow = hour % 5;

		var firstRowSb = new StringBuilder();
		for (int i = 0; i < 4; ++i) {
			if (firstRow > 0) {
				firstRowSb.append(RED);
				firstRow--;
			} else {
				firstRowSb.append(OFF);
			}
		}

		var secondRowSb = new StringBuilder();
		for (int i = 0; i < 4; ++i) {
			if (secondRow > 0) {
				secondRowSb.append(RED);
				secondRow--;
			} else {
				secondRowSb.append(OFF);
			}
		}

		return List.of(firstRowSb.toString(), secondRowSb.toString());
	}

	public static List<String> convertMinute(int minute) {
		int firstRow = minute / 5;
		int secondRow = minute % 5;

		var firstRowSb = new StringBuilder();
		for (int i = 0; i < 11; ++i) {
			if (firstRow > 0) {
				firstRowSb.append(isIndexDenotesQuarterOfHour(i) ? RED : YELLOW);
				firstRow--;
			} else {
				firstRowSb.append(OFF);
			}
		}

		var secondRowSb = new StringBuilder();
		for (int i = 0; i < 4; ++i) {
			if (secondRow > 0) {
				secondRowSb.append(YELLOW);
				secondRow--;
			} else {
				secondRowSb.append(OFF);
			}
		}

		return List.of(firstRowSb.toString(), secondRowSb.toString());
	}

	public static String convertSecond(int second) {
		return second % 2 == 0 ? YELLOW : OFF;
	}

	private static boolean isIndexDenotesQuarterOfHour(int minuteFirstRowIndex) {
		return (minuteFirstRowIndex + 1) % 3 == 0;
	}
}
