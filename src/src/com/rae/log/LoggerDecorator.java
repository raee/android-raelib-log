package com.rae.log;

/**
 * 日志装饰者
 * 
 * @author ChenRui
 * 
 */
class LoggerDecorator implements Logger {
	private Logger mLog;

	public LoggerDecorator(Logger logger) {
		mLog = logger;
	}

	@Override
	public void v(String tag, String msg) {
		mLog.v(tag, msg);
	}

	@Override
	public void d(String tag, String msg) {
		mLog.d(tag, msg);
	}

	@Override
	public void i(String tag, String msg) {
		mLog.i(tag, msg);
	}

	@Override
	public void w(String tag, String msg) {
		mLog.w(tag, msg);
	}

	@Override
	public void e(String tag, String msg) {
		mLog.e(tag, msg);
	}

	@Override
	public void v(String msg) {
		mLog.v(msg);
	}

	@Override
	public void d(String msg) {
		mLog.d(msg);
	}

	@Override
	public void i(String msg) {
		mLog.i(msg);
	}

	@Override
	public void w(String msg) {
		mLog.w(msg);
	}

	@Override
	public void e(String msg) {
		mLog.e(msg);
	}

	@Override
	public LogConfig getConfig() {
		return mLog.getConfig();
	}

}
