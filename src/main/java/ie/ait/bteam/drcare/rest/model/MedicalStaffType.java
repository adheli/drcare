package ie.ait.bteam.drcare.rest.model;

public enum MedicalStaffType {

	GP("General Practitioner"),
	PHARMACIST("Pharmacist"),
	NURSE("Nurse"),
	OTHER("Other medical staff");

	private String typeDesc;

	MedicalStaffType(String typeDesc) {
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
