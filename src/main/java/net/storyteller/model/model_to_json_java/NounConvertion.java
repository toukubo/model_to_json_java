package net.storyteller.model.model_to_json_java;

import java.lang.reflect.Method;
import java.util.jar.JarEntry;

import com.google.gson.Gson;
import com.google.gson.JsonElement;

public class NounConvertion {

	private JsonElement jsonString;
	private Noun noun;

	public NounConvertion(JarEntry entry,ClassLoader classLoader,String jarFileName) throws ClassNotFoundException {
		
		if(!valid(entry))
			return ;
		String classname = entry.getName().replaceAll("jarFileName", "")
				.replaceAll("\\.class","").replaceAll("/",".").replaceAll(jarFileName+"\\.", "");
		System.err.println(classname);
		Class classl = classLoader.loadClass(classname);
		noun = new Noun();
		for (Method method : classl.getMethods()) {
			AttrConversion attrConversion =  new AttrConversion(method);
			if(attrConversion.valid(method))
				noun.getAttrs().add(attrConversion.getAttr());
		}
		String simplename = classl.getName().split("\\.")[classl.getName().split("\\.").length-1];
		noun.setName(simplename);
		System.out.println(getJsonString());
	
	}

	private boolean valid(JarEntry entry) {
		if(!entry.getName().endsWith("class"))
			return false;
		return true;
	}

	public JsonElement getJsonString() {
		Gson gson = new Gson();
		this.jsonString = gson.toJsonTree(this.noun);
		return jsonString;
	}

	public void setJsonString(JsonElement jsonString) {
		this.jsonString = jsonString;
	}
	
	

}
