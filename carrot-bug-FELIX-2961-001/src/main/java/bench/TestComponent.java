package bench;

import org.apache.felix.scr.annotations.Component;
import org.apache.felix.scr.annotations.Property;

/*
 * the following @Component(name = Name.PID) produces:
 *
 * Description	Resource	Path	Location	Type
 The value for annotation attribute Component.name must be a constant expression	TestComponent.java	/carrot-bug-FELIX-2961-001/src/main/java/bench	line 5	Java Problem
 */
// @Component(name = Name.PID)

@Component(name = "this-is-really-a-compile-time-constant")
public class TestComponent {

	/*
	 * but the following @Property... magically produces valid entry in
	 * serviceComponents.xml despite being a non-compile time constant
	 */
	@Property(name = "service.pid")
	protected static final String PID = Name.PID;

}