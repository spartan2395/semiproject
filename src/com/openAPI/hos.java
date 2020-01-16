package com.openAPI;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;




public class hos {
	public static void main(String[] args) {
		BufferedReader bf = null;
		try {
			String urlstr = "http://apis.data.go.kr/B551182/hospInfoService/getHospBasisList?sidoCd=110000&sgguCd=110019&"
					+ "emdongNm=신내동&yadmNm=서울의료원&zipCd=2010&clCd=11&xPos=127.09854004628151&yPos=37.6132113197367&"
					+ "radius=3000&ServiceKey=zvvCTTSgLLYTdWqrd9C7UmWwBuVexWsb6XpJRtcfXoBjBfZEfqGv%2FB7mgyUy41ccCftHRxLChIBaUKnd7RIpmw%3D%3D";
			URL url = new URL(urlstr);
			HttpURLConnection urlconnection = (HttpURLConnection) url.openConnection();
			urlconnection.setRequestMethod("GET");
			bf = new BufferedReader(new InputStreamReader(urlconnection.getInputStream(),"UTF-8"));
			String result = "";
			String line;
			while((line=bf.readLine())!= null) {
				result = result + line+"/n";
			}
			System.out.println(result);
		}catch(Exception e) {
			e.printStackTrace();
		}
	}
}
