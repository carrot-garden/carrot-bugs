package com.carrotgarden.bug.case_2_leak;

import java.util.LinkedList;
import java.util.List;

import org.apache.pivot.beans.BXMLSerializer;
import org.apache.pivot.wtk.Application;
import org.apache.pivot.wtk.DesktopApplicationContext;
import org.apache.pivot.wtk.Display;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class MainPivot implements Application {

	private static final Logger log = LoggerFactory.getLogger(MainPivot.class);

	static {
		log.info("load");
	}

	private final List<WindowExtra> windowList = new LinkedList<WindowExtra>();

	private Display display;

	private final Runnable task = new Runnable() {
		@Override
		public void run() {
			while (true) {
				try {
					log.debug("task init");
					int count = WindowExtra.COUNTER.get();
					log.debug("instance count : {}", count);
					Thread.sleep(1000);
				} catch (InterruptedException e) {
					return;
				}
			}
		}
	};

	@Override
	public void startup(Display display,
			org.apache.pivot.collections.Map<String, String> properties)
			throws Exception {

		new Thread(task).start();

		this.display = display;

		log.info("### pivot startup");

		makeWindow(10);

		closeAll();

		System.gc();

	}

	void closeAll() throws Exception {
		for (WindowExtra window : windowList) {
			window.close();
			Thread.sleep(250);
		}
		windowList.clear();
	}

	void makeWindow() throws Exception {

		BXMLSerializer bxml = new BXMLSerializer();

		WindowExtra window = (WindowExtra) bxml.readObject(MainPivot.class,
				"WindowExtra.bxml");

		windowList.add(window);

		window.open(display);

	}

	void makeWindow(int count) throws Exception {

		for (int k = 0; k < count; k++) {
			makeWindow();
		}

	}

	@Override
	public boolean shutdown(boolean isOptional) throws Exception {

		log.info("### pivot shutdown; optional : {}", isOptional);

		return false;

	}

	@Override
	public void suspend() throws Exception {
	}

	@Override
	public void resume() throws Exception {
	}

	public static void main(String... args) {

		DesktopApplicationContext.main(MainPivot.class, args);

	}

}
