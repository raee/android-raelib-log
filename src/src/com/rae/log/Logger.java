package com.rae.log;

/**
 * 日记记录接口
 * 
 * @author ChenRui
 * 
 */
public interface Logger {

	public void v(String tag, String msg);

	public void d(String tag, String msg);

	public void i(String tag, String msg);

	public void w(String tag, String msg);

	public void e(String tag, String msg);

	public void v(String msg);

	public void d(String msg);

	public void i(String msg);

	public void w(String msg);

	public void e(String msg);

	public LogConfig getConfig();

}
