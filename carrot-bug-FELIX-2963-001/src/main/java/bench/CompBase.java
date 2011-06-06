package bench;

import java.util.Map;

import org.apache.felix.scr.annotations.Activate;
import org.apache.felix.scr.annotations.Component;
import org.apache.felix.scr.annotations.Deactivate;
import org.apache.felix.scr.annotations.Modified;

@Component(componentAbstract = true)
public abstract class CompBase {

	protected abstract void activate(final Map<String, String> config);

	protected abstract void deactivate(final Map<String, String> config);

	protected abstract void modified(final Map<String, String> config);

	//

	@Activate
	protected final void activateBASE(final Map<String, String> config) {
		activate(config);
	}

	@Deactivate
	protected final void deactivateBASE(final Map<String, String> config) {
		deactivate(config);
	}

	@Modified
	protected final void modifiedBASE(final Map<String, String> config) {
		modified(config);
	}

}
