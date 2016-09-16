package net.storyteller.model.model_to_json_java;

import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.net.URLClassLoader;
import java.util.Enumeration;
import java.util.jar.JarEntry;
import java.util.jar.JarFile;

import org.w3c.dom.Attr;

public class Conversion {
	public Conversion(File file) throws ClassNotFoundException, IOException{
		JarFile jarFile = new JarFile(file);
		String jarFileName = jarFile.getName().replaceAll("\\.jar", "");
		jarFileName = jarFileName.split("/")[jarFileName.split("/").length-1];//basename
		
		Enumeration<JarEntry> enumeration = jarFile.entries();
		ClassLoader parent = ClassLoader.getSystemClassLoader();

		ClassLoader classLoader  = new URLClassLoader(new URL[]{file.toURI().toURL()}, getClass().getClassLoader());
		
		enumeration = jarFile.entries();
		while (enumeration.hasMoreElements()) {
			JarEntry entry = (JarEntry) enumeration.nextElement();

			NounConvertion nounConvertion =  new NounConvertion(entry,classLoader,jarFileName);
		}
	}

	private boolean isValid(JarEntry entry) {
		return true;
	}


}
