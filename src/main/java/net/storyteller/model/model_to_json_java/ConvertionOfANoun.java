package net.storyteller.model.model_to_json_java;

import java.lang.reflect.Method;
import java.util.jar.JarEntry;

import net.storyteller.model.Noun;
import net.storyteller.model.NounImpl;

public class ConvertionOfANoun {

	public ConvertionOfANoun(JarEntry entry,ClassLoader classLoader) throws ClassNotFoundException {
		if(!valid(entry))
			return ;
		
		Class classl = classLoader.loadClass(entry.getName().replaceAll("\\.class","").replaceAll("/","."));
		Noun noun = new NounImpl();
		for (Method method : classl.getMethods()) {
			new AttrConversion(method);
		}
	}

	private boolean valid(JarEntry entry) {
		return true;
	}

}
