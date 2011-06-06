package bench;

import java.util.Map;

import org.apache.felix.scr.annotations.Component;

@Component
public class CompInherited extends CompBase {

	@Override
	protected void activate(Map<String, String> config) {
	}

	@Override
	protected void deactivate(Map<String, String> config) {
	}

	@Override
	protected void modified(Map<String, String> config) {
	}

}
