package com.bashir.berlinclock.output;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class BerlinClockDisplayTest {

	@Test
	public void berlinClockBuilder_build_WithValidParams_ReturnDisplayRowInExpectedOrder() {
		BerlinClockDisplay berlinClockDisplay = new BerlinClockDisplay.BerlinClockDisplayBuilder()
				.hour(13)
				.minute(19)
				.secod(54)
				.build();

		String[] displayRows = berlinClockDisplay.display().split("\n");
		Assertions.assertEquals(5, displayRows.length);
		Assertions.assertEquals("Y", displayRows[0]);
		Assertions.assertEquals("RROO", displayRows[1]);
		Assertions.assertEquals("RRRO", displayRows[2]);
		Assertions.assertEquals("YYROOOOOOOO", displayRows[3]);
		Assertions.assertEquals("YYYY", displayRows[4]);
	}

	@Test
	public void berlinClockBuilder_build_WithoutSecondParam_ThrowsException() {
		Assertions.assertThrows(NullPointerException.class,
		                        () -> new BerlinClockDisplay.BerlinClockDisplayBuilder()
				                        .hour(10)
				                        .minute(19)
				                        .build()
		);
	}

	@Test
	public void berlinClockBuilder_build_WithoutMinuteParam_ThrowsException() {
		Assertions.assertThrows(NullPointerException.class,
		                        () -> new BerlinClockDisplay.BerlinClockDisplayBuilder()
				                        .hour(10)
				                        .secod(19)
				                        .build()
		);
	}

	@Test
	public void berlinClockBuilder_build_WithoutHourParam_ThrowsException() {
		Assertions.assertThrows(NullPointerException.class,
		                        () -> new BerlinClockDisplay.BerlinClockDisplayBuilder()
				                        .minute(10)
				                        .secod(19)
				                        .build()
		);
	}
}
