package controller;
import model.*;
import view.*;
import java.math.*;
import java.util.*;
import java.io.*;
public class Nearai{
	public void valueUpdate()throws IOException{
	try{	
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		System.out.println("値洗いを行います。");
		
		
		//在庫データとマスターファイルの読み込み
		FileLoader fl = new FileLoader();
		Portfolio txt = fl.load("hold.txt");
		MasterMap master = fl.masterLoad("master.txt");
		Map<String,Bond> bMap = txt.getMap();
		Map<String,Master> mMap = master.getMap();

		//一行ごと呼び出し
		for(String key:bMap.keySet()){
			Bond b = bMap.get(key);
			System.out.print("コード=[" + b.getCode() + "]名称[" + master.getMaster(key).getName() + "] :");
			Master m = mMap.get(key);
			//データの記入
			BigDecimal marketValue = new BigDecimal(br.readLine());
			b.setMarketValue(marketValue);
			txt.fileUpdate();
		}
		}
		catch (NumberFormatException e) {
			System.out.println("データが不正です");
    	}
		finally{
			System.out.println("終了します");
			
		}
	}
}
		
			
			
		
			