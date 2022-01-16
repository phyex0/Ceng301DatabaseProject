package Views;

import java.util.Map;

public class ViewData {
	public final String functionName;
	public final String operationName;
	public final Map<String, Object> viewParameters;

	public ViewData(String functionName, String operationName) {
		this.functionName = functionName;
		this.operationName = operationName;
		this.viewParameters = null;
	}
	
	ViewData(String functionName, String operationName, Map<String, Object> viewParameters) {
		this.functionName = functionName;
		this.operationName = operationName;
		this.viewParameters = viewParameters;
	}
	
	@Override
	public String toString() {
		return "Function name = " + functionName + " / " + operationName + " : " + viewParameters.toString();
	}
	
}
