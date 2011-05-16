package com.carrotgarden.test;

import org.apache.pivot.beans.BXMLSerializer;
import org.apache.pivot.wtk.Application;
import org.apache.pivot.wtk.Display;
import org.apache.pivot.wtk.Window;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class MainPivot implements Application {

	private static final Logger log = LoggerFactory.getLogger(MainPivot.class);

	static {
		log.info("load");
	}

	private Window window;

	@Override
	public void startup(Display display,
			org.apache.pivot.collections.Map<String, String> properties)
			throws Exception {

		System.gc();

		log.info("### pivot startup");

		BXMLSerializer bxml = new BXMLSerializer();

		window = (Window) bxml.readObject(MainPivot.class, "MainPivot.bxml");

		window.open(display);

	}

	@Override
	public boolean shutdown(boolean isOptional) throws Exception {

		if (window != null) {
			window.close();
			window = null;
		}

		log.info("### pivot shutdown; optional : {}", isOptional);

		System.gc();

		return false;

	}

	@Override
	public void suspend() throws Exception {
		// not used
	}

	@Override
	public void resume() throws Exception {
		// not used
	}

}
