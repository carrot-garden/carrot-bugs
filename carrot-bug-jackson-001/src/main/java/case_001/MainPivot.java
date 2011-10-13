package case_001;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class MainPivot {

	private static final Logger log = LoggerFactory.getLogger(MainPivot.class);

	static {
		log.info("load");
	}

	private static WindowExtra window;

	public static void main(final String... args) {

		log.debug("init");

		window = new WindowExtra();

		final String json = "{}";

		Json.update(window, json);

		log.debug("done");

	}

}
