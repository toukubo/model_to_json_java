package net.storyteller.model.model_to_json_java;

import java.util.HashMap;
import java.util.Map;

public class ModelNameMap {
	private Map<String, String> map = new HashMap<String, String>();
	public ModelNameMap(){
		map.put("java.lang.String", "String");
		map.put("java.util.Date", "String");
		map.put("boolean", "boolean");
		map.put("java.lang.Boolean", "Boolean");
		map.put("int", "int");
		map.put("java.lang.Integer", "Integer");
		map.put("float", "float");
		map.put("java.lang.Float", "Float");
		map.put("double", "double");
		map.put("java.lang.Double", "Double");
		map.put("java.util.Collection", "Collection");
	}
	public String get(String parameterTypeName){
		return in(parameterTypeName)?this.map.get(parameterTypeName):"noun";
	}
	public boolean in(Object parameterTypeName) {
		return map.get(parameterTypeName)!=null;
	}
}
