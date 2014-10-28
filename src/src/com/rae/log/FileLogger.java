package com.rae.log;

import android.util.Log;

class FileLogger extends LoggerDecorator {

	public FileLogger(Logger logger) {
		super(logger);
	}

	@Override
	public void d(String tag, String msg) {
		// super.d(tag, msg+"--文件附加--");
		Log.d(tag, "小妹妹");
	}

	@Override
	public void d(String msg) {
		super.d(msg + "--小妹妹！--");
	}

}
