package com.rae.log;

public final class LoggerManager {
	private LoggerManager() {
	}

	public static Logger getLogger(LogConfig config, String tag) {

		Logger consoleLogger = new ConsoleLogger(config, tag);
		Logger decorator = new FileLogger(consoleLogger);
		return decorator;
	}

	public static Logger getLogger(LogConfig config) {
		return getLogger(config, null);
	}

}
