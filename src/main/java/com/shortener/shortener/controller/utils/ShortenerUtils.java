package com.shortener.shortener.controller.utils;

import java.math.BigInteger;
public class ShortenerUtils
{

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
	


		public static  Long  decodeBase62(String encodedUrl){
	    
	    Long decoded = 0L;
	    int l = encodedUrl.length();
	    
	    	
		for(int i=0; i < l; i++){

			char encoded =encodedUrl.charAt(i);
		    
		    if( encoded >= 48 && encoded <= 57 ){
	            decoded+= Character.getNumericValue(encoded) * (int) Math.pow(62, l-i-1);
	            	
	        }else{
	            	decoded+= (int) encoded > 96 ?( (int) encoded - 61 ) * (int) Math.pow(62, l-i-1) :( (int) encoded - 55 ) * (int) Math.pow(62, l-i-1);
	            	
	        
	        }   
	        
		    
			
			
				
		}
	    
		return decoded;
	}


}
