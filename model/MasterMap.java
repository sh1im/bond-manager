package model;
import controller.*;
import view.*;
import java.util.*;
import java.io.*;
import java.math.*;
public class MasterMap{
	Map<String,Master> mMap = new HashMap<String,Master>();
	
	public void addMaster(Master m){
		mMap.put(m.getCode(),m);
	}
	
	public boolean containsCode(String c){
		return mMap.containsKey(c);
	}
	public Master getMaster(String c){
		return mMap.get(c);
	}
	public Map getMap(){
		return mMap;
	}
			
}
