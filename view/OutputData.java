package view;
import controller.*;
import model.*;
import java.io.*;
import java.util.*;
import java.math.*;
public class OutputData{
	public void output(){
		//文字変換クラスの呼び出し
		StringConvert sc = new StringConvert();
		sc.printn("コード",16);
		sc.printn("銘柄名",16);
		sc.printn("償還年月日",16);
		sc.printn("利率",16);
		sc.printn("回数",16);
		sc.printn("数量",16);
		sc.printn("簿価",16);
		sc.printn("時価",16);
		sc.printn("評価損益",16);
		System.out.println("");
		
		//在庫データとマスターの読み込み
		FileLoader fl = new FileLoader();
		Portfolio txt =fl.load("hold.txt");
		MasterMap master = fl.masterLoad("master.txt");
		
		//在庫データとマスターを一行ずつ読み込む
		for(String key:txt.bMap.keySet()){
			Bond b = txt.bMap.get(key);
			Master m = master.mMap.get(key);
			sc.printn(key,16);
			sc.printn(m.getName(),16);
			sc.printn(m.getMaturity(),16);
			sc.printn(m.getCouponRate(),16);
			sc.printn(m.getCouponTimes(),16);
			BigDecimal amount = b.getAmount().setScale(3,BigDecimal.ROUND_DOWN);
			sc.printn(amount,16);
			sc.printn(b.getBookValue(),16);
			sc.printn(b.getMarketValue(),16);
			BigDecimal pl;
			//nullのチェック
			if(b.plCalc() == null){
				pl = null;
			}
			else{	
				pl = b.plCalc().setScale(0,BigDecimal.ROUND_DOWN);
			}
			sc.printn(pl,16);
			System.out.println("");
		}
		System.out.println("終了します");
	}
}
				

				
			
		
