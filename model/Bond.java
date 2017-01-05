package model;
import controller.*;
import view.*;
import java.util.*;
import java.io.*;
import java.math.*;
public class Bond{
	private String code;
	private BigDecimal amount;
	private BigDecimal marketValue;
	private BigDecimal bookValue;
	
	public Bond(String c,BigDecimal a,BigDecimal bv,BigDecimal mv)throws IllegalArgumentException{
		code = c;
		amount = a;
		bookValue = bv;
		marketValue = mv;
		
		if((c == null) || (a == null) || (bv == null) || (mv == null) ){
			throw new IllegalArgumentException("エラー");
		}
	}
	
	public Bond(String c,BigDecimal a,BigDecimal bv)throws IllegalArgumentException{
		code = c;
		amount = a;
		bookValue = bv;
		marketValue = null;
		
		if((c == null) || (a == null) || (bv == null)){
			throw new IllegalArgumentException("エラー");
		}
	}
	
	public String getCode(){
		return code;
	}
	
	public BigDecimal getAmount(){
		return amount;
	}
	
	public void setAmount(BigDecimal a){
		amount = a;
	}
	
	public BigDecimal getBookValue(){
		return bookValue;
	}
	
	public void setBookValue(BigDecimal bv){
		bookValue = bv;
	}
	
	public BigDecimal getMarketValue(){
		return marketValue;
	}
	
	public void setMarketValue(BigDecimal m){
		marketValue = m;
	}
	public BigDecimal plCalc(){
		if(marketValue == null){
			return null;
		}
		else{
			return (marketValue.subtract(bookValue)).multiply(amount);
		}
	}
}