package com.bashir.berlinclock;

import java.io.InputStream;
import java.time.LocalTime;
import java.util.Optional;

public interface TimeInputScanner {

	String takeInput(InputStream inputStream);

	Optional<LocalTime> parseTime(String timeStr);
}
