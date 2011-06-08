package bench_core;

import org.apache.felix.scr.annotations.Component;
import org.apache.felix.scr.annotations.Property;

import bench_api.Name;

@Component(name = "this-is-really-a-compile-time-constant")
public class TestComponent {

	@Property(name = "service.pid")
	protected static final String PID = Name.PID;

	@Property(name = "component.name")
	protected static final String NAME = Name.PID;

}
