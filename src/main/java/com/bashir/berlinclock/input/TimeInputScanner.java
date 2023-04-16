package com.bashir.berlinclock.input;

import java.io.InputStream;
import java.time.LocalTime;
import java.util.Optional;

public interface TimeInputScanner {

	/**
	 * @param inputStream to read user input
	 * @return user input as {@code String}
	 */
	String takeInput(InputStream inputStream);

	/**
	 * @param timeStr a {@code String} that represents a valid time of format {@code DateTimeFormatter#ISO_LOCAL_TIME}
	 * @return Optional of paseed {@code LocalDateTime} or ${@code Optional#empty} if parsing fails
	 */
	Optional<LocalTime> parseTime(String timeStr);
}
