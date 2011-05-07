package com.carrotgarden.test;

import java.util.HashMap;
import java.util.Map;
import java.util.ServiceLoader;

import org.osgi.framework.Bundle;
import org.osgi.framework.BundleContext;
import org.osgi.framework.Constants;
import org.osgi.framework.launch.Framework;
import org.osgi.framework.launch.FrameworkFactory;

public class Main {

	public static void main(String[] args) {

		try {

			ServiceLoader<FrameworkFactory> loader = ServiceLoader
					.load(FrameworkFactory.class);

			FrameworkFactory factory = loader.iterator().next();

			Map<String, Object> config = new HashMap<String, Object>();

			config.put(Constants.FRAMEWORK_STORAGE, "./target/storage");

			Framework framework = factory.newFramework(config);

			framework.start();

			BundleContext context = framework.getBundleContext();

			Bundle bundle = context
					.installBundle("http://www.eclipsezone.com/files/jsig/bundles/HelloWorld.jar");

			bundle.start();

			framework.waitForStop(0);

		} catch (Exception e) {
			e.printStackTrace();
		}

	}

}
