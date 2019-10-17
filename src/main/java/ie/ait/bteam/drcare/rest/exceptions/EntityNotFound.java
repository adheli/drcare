package ie.ait.bteam.drcare.rest.exceptions;

public class EntityNotFound extends RuntimeException {

	public EntityNotFound(String message) {
		super(message);
	}

	public EntityNotFound(Long entityId) {
		super(String.format("No entity was found with id: %d", entityId));
	}
}
