package com.p6spy.engine.spy.appender;

import com.p6spy.engine.common.P6Util;

public class CustomSqlFormat implements MessageFormattingStrategy {
	@Override
	public String formatMessage(int connectionId, String now,
	                            long elapsed, String category, String prepared,
	                            String sql, String url) {

		return now + "^" + elapsed + "^" + category + "^connection " + connectionId + "^"
				+ P6Util.singleLine(sql);
	}

}
