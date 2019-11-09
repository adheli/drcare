package ie.ait.bteam.drcare.rest.dto;

public enum UserType {

	GP("General Practitioner"),
	PHARMACIST("Pharmacist"),
	NURSE("Nurse"),
	PATIENT("Patient"),
	OTHER("Other medical staff");

	private String typeDesc;

	UserType(String typeDesc) {
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
