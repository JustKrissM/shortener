package com.shortener.shortener.controller.utils;

import java.math.BigInteger;
public class ShortenerUtils
{
	public static void main(String[] args) {
	    
	   System.out.println(encodeBase62( new BigInteger("1234567890")));
	}
	
	

	
	
	public static String encodeBase62Reverse(BigInteger num){
	    
	    String encoded="";
	    BigInteger remainder = BigInteger.ONE;
	    BigInteger values [];
	    	
	    do {
	        
	        
	         values =num.divideAndRemainder(new BigInteger("62"));
	         remainder =values[1];
	         
	         //Debug values
	         System.out.println("div: "+values[0].intValue());
	         System.out.println("remainder: "+remainder.intValue());
	        
	        if(remainder.intValue() <10){
	            encoded+= remainder.intValue();
	        }else{
	            encoded+= remainder.intValue() > 35?((char) (remainder.intValue() + 61)) : ((char) (remainder.intValue() + 55));
	        }   
	        
	        num = values[0];
	    }while(values[0].intValue() != 0);
	    
		return encoded;
	}
	
	public static String encodeBase62(BigInteger num){
	    
	    
	    String encoded = encodeBase62Reverse(num);
	    
	    String reversed = "";
	    
	    for(int i = encoded.length() - 1; i > 0; i--){
	        
	        reversed += encoded.charAt(i);
	    }
		return reversed;
	}
	
}
