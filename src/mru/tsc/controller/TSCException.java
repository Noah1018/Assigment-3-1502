package mru.tsc.controller;

public class TSCException extends Exception{
	
	private String error;
	
	/**
	 * constructor
	 * @param error
	 */
	public TSCException(String error) {
		
		 super(error);
	      this.error = error;
	    }
	
	/**
	 * toString method
	 */
	public String toString() {
		return "Invalid Social Security Number, " +error; 
	    }
	}


