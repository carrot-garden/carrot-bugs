package com.carrotgarden.test;

import java.net.URL;
import java.util.concurrent.atomic.AtomicInteger;

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

	private static final AtomicInteger COUNTER = new AtomicInteger(0);

	@Override
	public void initialize(Map<String, Object> namespace, URL location,
			Resources resources) {

		Label counterLabel = (Label) namespace.get("counter");

		counterLabel.setText("" + COUNTER.getAndIncrement());

	}

}
