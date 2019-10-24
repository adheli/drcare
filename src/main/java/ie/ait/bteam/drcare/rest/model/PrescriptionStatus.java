package ie.ait.bteam.drcare.rest.model;

public enum PrescriptionStatus {

	CREATE("Created"),
	IN_PROGRESS("In Progress"),
	DELIVERED("Delivered"),
	CANCELED("Canceled");

	private String typeDesc;

	PrescriptionStatus(String typeDesc) {
		this.typeDesc = typeDesc;
	}

	public String getTypeDesc() {
		return typeDesc;
	}

	@Override
	public String toString() {
		return this.name();
	}
}
