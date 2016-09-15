package net.storyteller.model.model_to_json_java;

import java.lang.reflect.Method;

import com.google.gson.Gson;

import net.storyteller.model.Attr;
import net.storyteller.model.AttrImpl;

@Data
public class AttrConversion {

	private Attr attr;
	private String jsonString;

	public AttrConversion(Method method) {


		if(!valid(method))	return;

		String parameterTypeName = method.getParameterTypes()[0].getName();

		String simplename = getSimplename(method);

		attr = new AttrImpl();
		attr.setName(simplename);
		ModelNameMap modelNameMap = new ModelNameMap();
		attr.setClasstype(modelNameMap.get(parameterTypeName));
		attr.setJapanese("");
		Gson gson = new Gson();
		this.jsonString = gson.toJson(attr);
			
	
	}

	private boolean valid(Method method) {
		if(method.getParameterTypes().length != 1)
			return false;
		if(!method.getName().startsWith("set"))
			return false;

		String parameterTypeName = method.getParameterTypes()[0].getName();
		ModelNameMap modelNameMap = new ModelNameMap();
		if(!modelNameMap.in(parameterTypeName))
			return false;
		return false;
	}

	private String getSimplename(Method method) {
		String simplename = method.getName().substring(3);
		simplename = simplename.substring(0,1).toLowerCase() + simplename.substring(1);
		simplename = simplename.substring(0,1).toLowerCase() + simplename.substring(1);
		return simplename;

	}

}
