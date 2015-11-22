package com.collegebox.webservice.model.elasticsearch;

import java.util.List;
import java.util.Map;

import net.sf.json.JSONObject;

public class College {
	
	private JSONObject source;
	
	private Map<String, List<String>> highlight;
	
	public JSONObject getSource() {
		return source;
	}

	public void setSource(JSONObject source) {
		this.source = source;
	}

	public Map<String, List<String>> getHighlight() {
		return highlight;
	}

	public void setHighlight(Map<String, List<String>> highlight) {
		this.highlight = highlight;
	}
	
}
