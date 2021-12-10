package co.com.enel.test;

import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import co.com.enel.test.constants.Constants;



public class BinaryNumber {
	
	private String number;
	private int numberDecimal;
	private int amountOperation;
	
	public int getNumberDecimal() {
		return numberDecimal;
	}

	public void setNumberDecimal(int numberDecimal) {
		this.numberDecimal = numberDecimal;
	}

	public String getNumber() {
		return number;
	}

	public void setNumber(String number) {
		this.number = number;
	}
	
	public int getAmountOperation() {
		return  amountOperation; 
	}

	public void setAmountOperation(int amountOperation) {
		this.amountOperation = amountOperation;
	}

	public void readString() {
		
		Scanner sc = new Scanner(System.in);
		System.out.println(Constants.INPUT.getDato());
		this.number = sc.nextLine();
		
	}
	
	public boolean isBinary() {
		
		Pattern pat = Pattern.compile("[01]+");
		
		Matcher mat = pat.matcher(number);
		
		if (mat.matches()) {
			return true;
		}else {
			return false;
		}
	}
	
	public boolean validateNumber() {
		if (isBinary()) {
			return true;
		}else {
			System.out.println(Constants.BINARY_NUMBER_NO_VALID.getDato());
			return false;
		}
	}
	
	public boolean isValidLength() {
		
		return (number.length()<1000000);
		
	}
	
	public boolean validateLength() {
		if (isValidLength()) {
			return true;			
		}else {
			System.out.println(Constants.LENGTH_NO_VALID.getDato());
			return false;
		}
	}
	
	public void transformBinaryToDecimal() {
		
		String[] digits = number.split("");
		double valor =0;
		
		for (int i=digits.length-1;i>=0;i--) {
			valor = valor + (Double.valueOf(digits[i]) * Math.pow(2, i));
		}
		
		this.numberDecimal = (int) valor;
	}
	
	public boolean isOdd () {
		
		return (this.numberDecimal%2==0); 
		
	}
	
	public void reduce() {
		
		if (isOdd()) {
			divided();
			
		}else {
			substract();			
		}
		
		if (this.numberDecimal != 0) {
			reduce();
		}
	}
	
	public void divided() {
		this.numberDecimal = this.numberDecimal/2;
		this.amountOperation++;
	}
	
	public void substract() {
		this.numberDecimal = this.numberDecimal-1;
		this.amountOperation++;
	}
	
	public void solution () {
		readString();
		if (validateNumber() && validateLength()) {
			transformBinaryToDecimal();
			reduce();
			System.out.println(Constants.AMOUNT_OPERATIONS.getDato() + amountOperation); 
		}
	}
	

}
