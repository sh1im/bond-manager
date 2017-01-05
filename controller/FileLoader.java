package controller;
import model.*;
import view.*;
import java.util.*;
import java.io.*;
import java.math.*;
public class FileLoader{
	public Portfolio load(String fileName)throws IOException{
		
		Portfolio loadFile = new Portfolio();
		try{
			BufferedReader br =
			 new BufferedReader(new FileReader(fileName));
			String str;
			while((str = br.readLine()) != null){
			
				String[] element = str.split(",",4);
				if(element[3].equals("null")){
					String code = element[0];
					BigDecimal amount = new BigDecimal(element[1]);
					BigDecimal bookValue = new BigDecimal(element[2]);
					Bond bond = new Bond(element[0],amount,bookValue);
					loadFile.addBond(bond);
				}
				else{
					String code = element[0];
					BigDecimal amount = new BigDecimal(element[1]);
					BigDecimal bookValue = new BigDecimal(element[2]);
					BigDecimal marketValue = new BigDecimal(element[3]);
					Bond bond = new Bond(element[0],amount,bookValue,marketValue);
					loadFile.addBond(bond);
				}
 			}
			br.close();
		}
		catch(IOException e){
			System.out.println("入出力エラーです" + e.getMessage());
		}
		return loadFile;
		}
		
	public MasterMap masterLoad(String fileName)throws IOException{
		
		MasterMap loadFile = new MasterMap();
		try{
			BufferedReader br =
			 new BufferedReader(new FileReader(fileName));
			String str;
			while((str = br.readLine()) != null){
				Master m = new Master(str);
				loadFile.addMaster(m);
			}
			br.close();
		}
		catch(IOException e){
			System.out.println("入出力エラーです" + e.getMessage());
		}
		return loadFile;
	}		
}