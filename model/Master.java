package model;
import controller.*;
import view.*;
import java.util.*;
import java.io.*;
import java.math.*;
public class Master{
	private String code;
	private String name;
	private int maturity;
	private BigDecimal couponRate;
	private int couponTimes;
	

	public Master(String line){
		String[] element2  = line.split(",",5);
		code = element2[0];
		name = element2[1];
		maturity = Integer.parseInt(element2[2]);
		couponRate = new BigDecimal(element2[3]);
		couponTimes = Integer.parseInt(element2[4]);
 	}
	
	public String getCode(){
		return code;
	}
	
	public String getName(){
		return name;
	}
	
	public int getMaturity(){
		return maturity;
	}
	
	public BigDecimal getCouponRate(){
		return couponRate;
	}
	
	public int getCouponTimes(){
		return couponTimes;
	}
	
}