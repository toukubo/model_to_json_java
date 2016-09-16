package net.storyteller.model.model_to_json_java;

import java.util.ArrayList;
import java.util.List;

public class Noun {
	public String name = "";
	public List<Attr> attrs = new ArrayList<Attr>();
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public List<Attr> getAttrs() {
		return attrs;
	}
	public void setAttrs(List<Attr> attrs) {
		this.attrs = attrs;
	}
	
}
