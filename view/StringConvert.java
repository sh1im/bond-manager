package view;
import controller.*;
import model.*;
import java.math.*;
import java.util.*;
import java.io.*;
public class StringConvert{	

	public void printn(String s,int y) {

		int l = 0;
		int len = y;


		// 1 文字ずつ出力
		for(int i=0;i<s.length(); i++) {

			char c = s.charAt(i);

			//  ( 英数字      )    ( \ 記号      )    ( ~ 記号      )    ( 半角カナ                     )
			if ((c <= '\u007e') || (c == '\u00a5') || (c == '\u203e') || (c >= '\uff61' && c <= '\uff9f')) {
				l++;
				if (l > len) {
					l--;
					break;
				}
			} else { // その他 (全角)
				l += 2;
				if (l > len) {
					l -= 2;
					break;
				}
			}

			System.out.print(c);

		}
		// 長さが足りなかった場合は半角スペースで埋める
		if(l<len) {
			for(int i=0;i<len-l;i++){
				System.out.print(" ");
			}
		}
		System.out.print("|");
		
	}
	
	public void printn(BigDecimal x,int y) {

		String x2;
		if(x == null){
			x2 = ("NA");
		}
		else{
			BigDecimal b = x.setScale(3,BigDecimal.ROUND_DOWN);
			x2 = b.toString();
		}
		int l = 0;
		int len = y;

		// 1 文字ずつ出力
		for(int i=0;i<x2.length(); i++) {

			char c = x2.charAt(i);

			//  ( 英数字      )    ( \ 記号      )    ( ~ 記号      )    ( 半角カナ                     )
			if ((c <= '\u007e') || (c == '\u00a5') || (c == '\u203e') || (c >= '\uff61' && c <= '\uff9f')) {
				l++;
				if (l > len) {
					l--;
					break;
				}
			} else { // その他 (全角)
				l += 2;
				if (l > len) {
					l -= 2;
					break;
				}
			}
		}
		// 長さが足りなかった場合は半角スペースで埋める
		if(l<len) {
			for(int i=0;i<len-l;i++){
				System.out.print(" ");
			}
			System.out.print(x2 + "|");
		}
		if(l>=len){
			System.out.print("表示できません");
		}
	}
	public void printn(int x,int y) {

		String x1 = String.valueOf(x);
		int l = 0;
		int len = y;

		// 1 文字ずつ出力
		for(int i=0;i<x1.length(); i++) {
		char c = x1.charAt(i);

			//  ( 英数字      )    ( \ 記号      )    ( ~ 記号      )    ( 半角カナ                     )
			if ((c <= '\u007e') || (c == '\u00a5') || (c == '\u203e') || (c >= '\uff61' && c <= '\uff9f')) {
				l++;
				if (l > len) {
					l--;
					break;
				}
			} else { // その他 (全角)
				l += 2;
				if (l > len) {
					l -= 2;
					break;
				}
			}
		}
		// 長さが足りなかった場合は半角スペースで埋める
		if(l<len) {
			for(int i1=0;i1<len-l;i1++){
				System.out.print(" ");
			}
		}
		System.out.print(x1 + "|");
		
	}
}