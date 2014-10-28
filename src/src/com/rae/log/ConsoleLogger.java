package com.rae.log;

import android.util.Log;

/**
 * 控制台输出Log
 * 
 * @author ChenRui
 * 
 */
class ConsoleLogger implements Logger {
	private LogConfig mConfig;
	private String mClassName = "ConsoleLogger";

	public ConsoleLogger(LogConfig config, String className) {
		mConfig = config;
		setTag(className);
	}

	public void v(String tag, String msg) {
		print(Log.VERBOSE, tag, msg);
	}

	public void d(String tag, String msg) {
		print(Log.DEBUG, tag, msg);
	}

	public void i(String tag, String msg) {
		print(Log.INFO, tag, msg);
	}

	public void w(String tag, String msg) {
		print(Log.WARN, tag, msg);
	}

	public void e(String tag, String msg) {
		print(Log.ERROR, tag, msg);
	}

	public void v(String msg) {
		v(mClassName, msg);
	}

	public void d(String msg) {
		d(mClassName, msg);
	}

	public void i(String msg) {
		i(mClassName, msg);
	}

	public void w(String msg) {
		w(mClassName, msg);
	}

	public void e(String msg) {
		e(mClassName, msg);
	}

	public LogConfig getConfig() {
		return mConfig;
	}

	protected boolean isEnable(int level) {
		if (!mConfig.isEnableLog()) {
			return false; // 不允许记录Log
		}

		if (!mConfig.isEnableDebug() && level <= Log.DEBUG) {
			return false; // 不允许调试
		}

		if (!mConfig.enableLevel(level)) {
			return false; // 当前基本不允许记录
		}

		return true;
	}

	protected void print(int level, String tag, String msg) {
		msg = getFunctionName() + msg;
		if (isEnable(level)) {
			switch (level) {
			case Log.VERBOSE:
				Log.v(tag, msg);
				break;
			case Log.DEBUG:
				Log.d(tag, msg);
				break;
			case Log.INFO:
				Log.i(tag, msg);
				break;
			case Log.WARN:
				Log.w(tag, msg);
				break;
			case Log.ERROR:
				Log.e(tag, msg);
				break;
			default:
				Log.v(tag, msg);
				break;
			}
		}
	}

	protected String getFunctionName() {
		Thread thread = Thread.currentThread();		
		for (StackTraceElement element : thread.getStackTrace()) {
			String className = element.getClassName();
			if (!mClassName.equals(element.getClass().getSimpleName())) {
				continue;
			}

			String fileName = element.getFileName();
			String methodName = element.getMethodName();
			int lineNumber = element.getLineNumber();
			return "[" + className + fileName + ":" + lineNumber + " "
					+ methodName + "]";
		}
		return "";
	}

	public void setTag(String tag) {
		if (tag == null || tag.length() <= 0) {
			return;
		}
		this.mClassName = tag;
	}
}
