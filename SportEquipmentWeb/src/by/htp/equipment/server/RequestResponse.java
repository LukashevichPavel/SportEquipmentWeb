package by.htp.equipment.server;

public class RequestResponse {
private String request;
private String response;

	public RequestResponse(){
		super();
	}
	public RequestResponse (String result){
		this.request=result;
	}
public RequestResponse(String request, String response){
	this.setRequest(request);
	this.setResponse(response);
}

public String parseRequestToCommand(String req){
	String command ="";
	if (req!=null){
	command=req;
	System.out.println("Запрос: "+command);
	
	}
	return command;
} 

	public String getRequest() {
		return request;
	}

	public void setRequest(String request) {
		this.request = request;
	}
	public String getResponse() {
		return response;
	}
	public void setResponse(String response) {
		this.response = response;
	}

	
}
