package bench;

public interface Name {

	String PID = Name.class.getName() + ".this-is-a-non-compile-time-constant";

}
