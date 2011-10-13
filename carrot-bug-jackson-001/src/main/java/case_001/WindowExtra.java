package case_001;

import org.apache.pivot.wtk.Window;
import org.codehaus.jackson.annotate.JsonProperty;

public class WindowExtra extends Window {

	@JsonProperty("comment")
	String comment;

}
