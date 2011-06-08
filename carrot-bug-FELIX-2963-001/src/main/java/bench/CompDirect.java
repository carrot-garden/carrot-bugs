package bench;

import java.util.Map;

import org.apache.felix.scr.annotations.Activate;
import org.apache.felix.scr.annotations.Component;
import org.apache.felix.scr.annotations.Deactivate;
import org.apache.felix.scr.annotations.Modified;

@Component
public class CompDirect {

	@Activate
	protected final void activate(final Map<String, String> config) {
	}

	@Deactivate
	protected final void deactivate(final Map<String, String> config) {
	}

	@Modified
	protected final void modified(final Map<String, String> config) {
	}

}
