package bench;

import org.apache.felix.scr.annotations.Component;
import org.apache.felix.scr.annotations.Property;

/*
 * the following @Component(name = Name.PID) produces:
 *
 * Description	Resource	Path	Location	Type
 The value for annotation attribute Component.name must be a constant expression	TestComponent.java	/carrot-bug-FELIX-2961-001/src/main/java/bench	line 5	Java Problem
 *
 * fine, this is how java annotations are now
 */
// @Component(name = Name.PID)

// lets give java annotation processor what it wants
@Component(name = "this-is-really-a-compile-time-constant")
public class TestComponent {

	/*
	 * but the following @Property... magically produces valid entry in
	 * serviceComponents.xml despite being a non-compile time constant
	 */
	@Property(name = "service.pid")
	protected static final String PID = Name.PID;

	/*
	 * I would like the same magic on the following property; so, if present, it
	 * should be applied to the <scr:component ... > level, as if it was defined
	 * there, hence override whatever is provided by the component annotation
	 * above
	 */
	@Property(name = "component.name")
	protected static final String NAME = Name.PID;

}
