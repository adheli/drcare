package ie.ait.bteam.drcare.rest.model;

public class ResponseDTO<T> {

	private T objectResponse;
	private String message;

	public ResponseDTO(T objectResponse, String message) {
		this.objectResponse = objectResponse;
		this.message = message;
	}

	public T getObjectResponse() {
		return objectResponse;
	}

	public String getMessage() {
		return message;
	}
}
