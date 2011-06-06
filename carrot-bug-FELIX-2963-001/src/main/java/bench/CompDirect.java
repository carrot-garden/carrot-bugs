package bench;

import java.util.Map;

import org.apache.felix.scr.annotations.Activate;
import org.apache.felix.scr.annotations.Component;
import org.apache.felix.scr.annotations.Deactivate;
import org.apache.felix.scr.annotations.Modified;

@Component
public class CompDirect {

	@Activate
	protected final void activateDIRECT(final Map<String, String> config) {
	}

	@Deactivate
	protected final void deactivateDIRECT(final Map<String, String> config) {

	}

	@Modified
	protected final void modifiedDIRECT(final Map<String, String> config) {

	}

}
