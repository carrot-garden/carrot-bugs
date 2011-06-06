package bench;

import java.util.Map;

import org.apache.felix.scr.annotations.Component;

@Component
public class CompInherited extends CompBase {

	protected final void activateDIRECT(final Map<String, String> config) {
		activateBASE(config);
	}

	protected final void deactivateDIRECT(final Map<String, String> config) {
		deactivateBASE(config);
	}

	protected final void modifiedDIRECT(final Map<String, String> config) {
		modifiedBASE(config);
	}

}
