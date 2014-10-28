package com.rae.log;

import android.util.Log;
import android.util.SparseBooleanArray;

/**
 * Log配置文件
 * 
 * @author ChenRui
 * 
 */
public class LogConfig {
	private static SparseBooleanArray LevelLogableMap;

	static {
		LevelLogableMap = new SparseBooleanArray();
		LevelLogableMap.put(Log.VERBOSE, true);
		LevelLogableMap.put(Log.DEBUG, true);
		LevelLogableMap.put(Log.INFO, true);
		LevelLogableMap.put(Log.WARN, true);
		LevelLogableMap.put(Log.ERROR, true);
	}

	private boolean enableDebug = true; // 是否允许调试，设置为false时，低于调试级别的将不会输出。
	private boolean enableLog = true; // 是否允许日志
	private boolean enableSdcard = false; // 是否允许写入到SdCard中。
	private String path; // 文件路径
	private String format = "%s"; // 日志输出格式

	public boolean isEnableDebug() {
		return enableDebug;
	}

	public void enableDebug(boolean enableDebug) {
		this.enableDebug = enableDebug;
	}

	public boolean isEnableLog() {
		return enableLog;
	}

	public boolean isEnableSdcard() {
		return enableSdcard;
	}

	public void enableLog(boolean enableLog) {
		this.enableLog = enableLog;
	}

	public void enableFile(boolean val) {
		this.enableSdcard = val;
	}

	public void setLevelEnable(int level, boolean enable) {
		LevelLogableMap.put(level, enable);
	}

	/**
	 * 获取日志级别是否允许输出。
	 * 
	 * @param level
	 * @return
	 */
	public boolean enableLevel(int level) {
		return LevelLogableMap.get(level, false);
	}
}
