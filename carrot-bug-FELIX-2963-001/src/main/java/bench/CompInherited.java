package bench;

import java.util.Map;

import org.apache.felix.scr.annotations.Component;

@Component
public class CompInherited extends CompBase {

	protected final void activateINHERITED(final Map<String, String> config) {
		activateBASE(config);
	}

	protected final void deactivateINHERITED(final Map<String, String> config) {
		deactivateBASE(config);
	}

	protected final void modifiedINHERITED(final Map<String, String> config) {
		modifiedBASE(config);
	}

}
