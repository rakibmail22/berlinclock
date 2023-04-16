package com.bashir.berlinclock.output;

import com.bashir.berlinclock.core.BerlinClockConverter;

import java.util.List;
import java.util.Objects;

public record BerlinClockDisplay(String display) {

	public static class BerlinClockDisplayBuilder {

		private Integer second;

		private Integer hour;

		private Integer minute;

		public BerlinClockDisplayBuilder hour(Integer hour) {
			this.hour = hour;
			return this;
		}

		public BerlinClockDisplayBuilder minute(Integer minute) {
			this.minute = minute;
			return this;
		}

		public BerlinClockDisplayBuilder secod(Integer second) {
			this.second = second;
			return this;
		}

		public BerlinClockDisplay build() {
			Objects.requireNonNull(this.hour);
			Objects.requireNonNull(this.minute);
			Objects.requireNonNull(this.second);

			String seconds = BerlinClockConverter.convertSecond(second);
			List<String> hours = BerlinClockConverter.convertHour(hour);
			List<String> minutes = BerlinClockConverter.convertMinute(minute);

			String displayStr = """
					%s
					%s
					%s
					%s
					%s""".formatted(seconds,
			                        hours.get(0),
			                        hours.get(1),
			                        minutes.get(0),
			                        minutes.get(1));

			return new BerlinClockDisplay(displayStr);
		}
	}
}
