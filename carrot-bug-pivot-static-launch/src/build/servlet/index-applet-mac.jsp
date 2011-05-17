
<html>

<head>

<title>Stipes Applet</title>

<!-- external -->
<script src="http://www.java.com/js/deployJava.js"
	type="text/javascript"></script>

<!-- internal -->
<script src="browser-detect.js" type="text/javascript"></script>
<script src="artifact-descriptor.js" type="text/javascript"></script>
<script src="applet-descriptor.js" type="text/javascript"></script>
<script src="pivot-descriptor.js" type="text/javascript"></script>

</head>

<body>

	<script type="text/javascript">

			var attributes = {
					code:"org.apache.pivot.wtk.BrowserApplicationContext$HostApplet",
					width:"100%", height:"100%"
            };

            var libraries = [];
            libraries.push("./pivot-core-2.0.jar");
            libraries.push("./pivot-wtk-2.0.jar");
            libraries.push("./pivot-wtk-terra-2.0.jar");
            libraries.push("./carrot-bug-pivot-static-launch-1.0.0-SNAPSHOT.jar");
            libraries.push("./carrot-bug-pivot-static-core-1.0.0-SNAPSHOT.jar");
            libraries.push("./slf4j-api-1.6.1.jar");

            attributes.archive = libraries.join(",");

            var parameters = {
            		separate_jvm:true,
            		codebase_lookup:false,
            		application_class_name:'com.carrotgarden.test.MainPivot'
            };

            var javaArguments = ["-Dsun.awt.noerasebackground=true","-Dsun.awt.erasebackgroundonresize=true"];

            parameters.java_arguments = javaArguments.join(" ");

            deployJava.runApplet(attributes, parameters, "1.6");

	</script>

</body>

</html>
