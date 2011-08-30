package com.carrotgarden.bug.case_1_no_leak;

import java.net.URL;
import java.util.concurrent.atomic.AtomicInteger;

import org.apache.pivot.beans.BXML;
import org.apache.pivot.beans.Bindable;
import org.apache.pivot.collections.Map;
import org.apache.pivot.util.Resources;
import org.apache.pivot.wtk.Label;
import org.apache.pivot.wtk.Window;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class WindowExtra extends Window implements Bindable {

	protected static final Logger log = LoggerFactory
			.getLogger(WindowExtra.class);

	static final AtomicInteger COUNTER = new AtomicInteger(0);

	@BXML
	Label counter;

	@Override
	public void initialize(Map<String, Object> namespace, URL location,
			Resources resources) {

		counter.setText("" + COUNTER.getAndIncrement());

	}

	@Override
	protected void finalize() {
		try {
			COUNTER.decrementAndGet();
			super.finalize();
		} catch (Throwable e) {
			e.printStackTrace();
		}
	}

}
