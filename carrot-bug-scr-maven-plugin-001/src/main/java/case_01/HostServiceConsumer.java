package case_01;

import java.util.Map;

import org.apache.felix.scr.annotations.Activate;
import org.apache.felix.scr.annotations.Component;
import org.apache.felix.scr.annotations.Deactivate;
import org.apache.felix.scr.annotations.Modified;
import org.apache.felix.scr.annotations.Reference;
import org.osgi.service.event.EventAdmin;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@Component
public class HostServiceConsumer {

	private static Logger log = LoggerFactory
			.getLogger(HostServiceConsumer.class);

	static {
		//
		log.info("load");
		//
	}

	@Reference
	private EventAdmin eventAdmin;

	@Activate
	protected void activate(Map<String, String> config) {
		log.info("ACTIVATE");
		log.info("eventAdmin : {}", eventAdmin);
	}

	@Deactivate
	protected void deactivate(Map<String, String> config) {
		log.info("DEACTIVATE");
	}

	@Modified
	protected void modified(Map<String, String> config) {
		log.info("MODIFIED: {}", config);
	}

}
