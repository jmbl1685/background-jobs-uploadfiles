package springboot.entities;

public class CustomResponse {

	private Object Message;
	private int Status;
	
	public CustomResponse(Object Message, int Status) {
		this.Message = Message;
		this.Status = Status;
	}
	
	public Object getMessage() {
		return Message;
	}
	public void setMessage(Object message) {
		Message = message;
	}
	public int getStatus() {
		return Status;
	}
	public void setStatus(int status) {
		Status = status;
	}
		
}
