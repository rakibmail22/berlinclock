package com.bashir.berlinclock;

import java.util.List;

public record BerlinClockDisplay(String display) {

	public static class BerlinClockDisplayBuilder {

		private int second;

		private int hour;

		private int minute;

		public BerlinClockDisplayBuilder hour(int hour) {
			this.hour = hour;
			return this;
		}

		public BerlinClockDisplayBuilder minute(int minute) {
			this.minute = minute;
			return this;
		}

		public BerlinClockDisplayBuilder secod(int second) {
			this.second = second;
			return this;
		}

		public BerlinClockDisplay build() {
			String seconds = BerlinClockConverter.convertSecond(second);
			List<String> hours = BerlinClockConverter.convertHour(hour);
			List<String> minutes = BerlinClockConverter.convertMinute(minute);

			String displayStr = """
					%s
					%s
					%s
					%s
					%s
					 """.formatted(seconds,
			                       hours.get(0),
			                       hours.get(1),
			                       minutes.get(0),
			                       minutes.get(1));

			return new BerlinClockDisplay(displayStr);
		}
	}
}
