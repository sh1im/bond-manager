package controller;
import model.*;
import view.*;
import java.math.*;
import java.util.*;
import java.io.*;
public class ImputData{
	public void imput(){
		try{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		//在庫データとマスターデータの読み込み
		FileLoader fl = new FileLoader();
		Portfolio txt = fl.load("hold.txt");
		MasterMap master = fl.masterLoad("master.txt");
		//入力されたコードの読み込み
		System.out.println("銘柄コードを記入してください。");
		String code = br.readLine();
		//マスターファイルにあるか確認
		if(!master.containsCode(code)){
			System.out.println("該当のコードがありません。");
		}
		//保有数量の記入
		else{
			System.out.println("保有数量を記入してください。");
			System.out.println("※0を記入すると該当コードの在庫データを消去します");
			
			BigDecimal amount = new BigDecimal(br.readLine());
			//削除機能
			if(amount.compareTo(BigDecimal.ZERO)==0){
				txt.removeBond(code);
			}
			//簿価の記入
			else{
				System.out.println("簿価を記入してください。");
				BigDecimal bookValue = new BigDecimal(br.readLine());
				//新しい在庫データ（BOND）を作成
				Bond bond =new Bond(code,amount,bookValue);
				//元のファイルのデータに加える
				txt.addBond(bond);
			}
			//ファイルの書き出し
			txt.fileUpdate();
		}
		}
		catch(IOException e){
			System.out.println("入出力エラーです");
		}
		finally{
			System.out.println("終了します。");
		}
		
	}
}