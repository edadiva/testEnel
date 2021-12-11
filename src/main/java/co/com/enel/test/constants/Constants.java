package co.com.enel.test.constants;

public enum Constants {
	
	INPUT("Enter binary number"),
	BINARY_NUMBER_NO_VALID("Input number is not binary"),
	LENGTH_NO_VALID("The length is not valid"),
	AMOUNT_OPERATIONS("The operations amount were : ");
	
	private String dato;
	
	Constants(String string) {
		dato = string;
	}

	public String getDato() {
		return this.dato;
	}
	
	

}
