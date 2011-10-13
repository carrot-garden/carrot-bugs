package com.carrotgarden.test;

import java.net.URL;
import java.util.concurrent.atomic.AtomicInteger;

import org.apache.pivot.beans.BXML;
import org.apache.pivot.beans.Bindable;
import org.apache.pivot.collections.Map;
import org.apache.pivot.util.Resources;
import org.apache.pivot.wtk.Alert;
import org.apache.pivot.wtk.Button;
import org.apache.pivot.wtk.ButtonPressListener;
import org.apache.pivot.wtk.Label;
import org.apache.pivot.wtk.MessageType;
import org.apache.pivot.wtk.PushButton;
import org.apache.pivot.wtk.Window;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class WindowExtra extends Window implements Bindable {

	protected static final Logger log = LoggerFactory
			.getLogger(WindowExtra.class);

	private static final AtomicInteger COUNTER = new AtomicInteger(0);

	@BXML
	private Label counter;

	@BXML
	private PushButton print;

	@Override
	public void initialize(final Map<String, Object> namespace,
			final URL location, final Resources resources) {

		counter.setText("hello pivot print; counter="
				+ COUNTER.getAndIncrement());

		print.getButtonPressListeners().add(new ButtonPressListener() {
			@Override
			public void buttonPressed(Button button) {

				Alert.alert(MessageType.INFO, "Print!", WindowExtra.this);

				doPrint();

			}
		});

	}

	void doPrint() {

		java.awt.Window window = this.getDisplay().getHostWindow();

		PrintService.printComponent(window);

	}

}
