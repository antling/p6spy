package com.p6spy.engine.spy.appender;

import org.apache.logging.log4j.ThreadContext;

public class CustomP6SpyLogger extends FileLogger {
	public void logText(String text) {
		String userName = ThreadContext.get("ROSE.UserName");
		String line1 = ThreadContext.pop();
		System.out.println("antling userName = " + userName + " text = " + text + " ID = " + line1);
		String line = ThreadContext.pop();
		if (userName == null) {
			line = "^" + text;
		} else {
			line = userName + "^" + text;
		}
		if (line1 == null) {
			line = "^" + line;
		} else {
			line = line1 + "^" + line;
		}
		getStream().println(line);
	}

}
