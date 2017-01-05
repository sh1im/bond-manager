package model;
import controller.*;
import view.*;
import java.util.*;
import java.io.*;
import java.math.*;
public class Portfolio{
	Map<String,Bond> bMap = new HashMap<String,Bond>();
	
	public void addBond(Bond b){
		if(bMap.containsKey(b.getCode())){
			BigDecimal a = bMap.get(b.getCode()).getAmount();//元にあったやつの数量
			BigDecimal bv = bMap.get(b.getCode()).getBookValue();
			BigDecimal sum1 = bv.multiply(a);
			BigDecimal sum2 = b.getBookValue().multiply(b.getAmount());
			a = a.add(b.getAmount());
			System.out.println(sum1);
			System.out.println(sum1);
			System.out.println(a);

			bv = sum1.add(sum2).divide(a);
			b.setAmount(a);
			b.setBookValue(bv);
			//amount+bookValueの計算
		}
		bMap.put(b.getCode(),b);
		
	}
	public boolean containsBond(String c){
		if(bMap.containsKey(c)){
			return true;
			}
		else{
			return false;
		}
	}
	
	public void removeBond(String c){
		bMap.remove(c);
	}
	
	public void fileUpdate()throws IOException{
		try{
			
			PrintWriter pw =
			new PrintWriter(new BufferedWriter(new FileWriter("hold.txt")));
			
			for(String key:bMap.keySet()){
				Bond b = bMap.get(key);
				pw.println(b.getCode() +"," + b.getAmount() + "," 
					+ b.getBookValue() + "," + b.getMarketValue());//ここで全要素出すようにする
			}
			pw.close();
		}
		catch(IOException e){
			System.out.println("入出力エラーです");
		
		}
	}
	
	public Map getMap(){
		return bMap;
	}
}
	/*
	public void marketValueUpdate()throws IOException{
		
		
		try{
			for(String key:txt.bMap.keySet()){
				Bond b = bMap.get(key);
				pw.println(b.getCode() +"," + b.getAmount() + "," 
					+ b.getBookValue() + "," + b.getMarketValue());
			}
		}
	}
	
	
	public Position findBond(bond){
		if(pMap.containsKey(issue)){
			return pMap.get(issue);
			}
		else{
			return null;
		}
	
	public Set<Position> getPositions(IssueType issueType){
		Set<Position> SameType = new HashSet<Position>();
		for(int i=0;i<positions.size();i++){
			if(positions.get(i).getIssue().getIssueType().equals(issueType)){
				SameType.add(positions.get(i));
			}
		}
		return SameType;
	}
	
	public void removePosition(Issue issue){
		for(int i=0;i<positions.size();i++){
			if(positions.get(i).getIssue().equals(issue)){
				positions.remove(i);
			}
		}
	}
	
	public List<Position> getAllPositions(){
		PositionSorter.sortByCode(positions);
		return positions;
	}
	
	public List<Position> getPositions(){
		return positions;
	}
	
	public List<Position> getAllNamePositions(){
		PositionSorter.sortByName(positions);
		return positions;
	}
	
	public List<Position> getNamePositions(){
		return positions;
	}
	
*/	

				