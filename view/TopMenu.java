package view;
import controller.*;
import model.*;
import java.util.*;
import java.io.*;
import java.math.*;
public class TopMenu{
	public String sendMenu()throws IOException{
		System.out.println("[トップメニュー]");
		System.out.println("1,データ入力\n2,値洗い\n3,データ表示\n4,終了");
		System.out.println("利用する機能の番号を半角数字で入力してください");
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		 
		return br.readLine();	
	}
}
