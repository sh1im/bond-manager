package controller;
import model.*;
import view.*;
import java.math.*;
import java.util.*;
import java.io.*;
public class Start{
	public static void main(String[] args)throws IOException{
		//マスターデータの読み込み
		//FileLoader fl = new FileLoader();
		//MasterMap master = fl.masterLoad("master.txt");
		
		//トップメニューの呼び出し
		TopMenu t = new TopMenu();
		String catchNumber = t.sendMenu();
		
		boolean isLoop = true;
		while(isLoop){
			
			if(catchNumber.equals("1")){
				//データ記入
				ImputData data = new ImputData();
				//記入用メソッドの呼び出し
				data.imput();
			}
		
			else if(catchNumber.equals("2")){
				//値洗い
				Nearai n = new Nearai();
				n.valueUpdate();
			}
			else if(catchNumber.equals("3")){
				//データ出力
				OutputData o = new OutputData();
				o.output();
			}
			else if(catchNumber.equals("4")){
				isLoop = false;
			}
			else{
				System.out.println("1〜4の数字を半角数字で入れてください");
			}
		}
		System.out.println("システムを終了します");
	}
}
		
			
			

		
	