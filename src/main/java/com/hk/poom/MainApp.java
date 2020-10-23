//package com.hk.poom;
//
//import java.io.IOException;
//
//import org.jsoup.Jsoup;
//import org.jsoup.nodes.Document;
//import org.jsoup.nodes.Element;
//import org.jsoup.select.Elements;
//
//public class MainApp {
//
//	private static String URL = "http://www.jobkorea.co.kr/Search/?=";	
//	
//	public static void main(String[] args) throws IOException {
//		String key_word = "Jquery";
//		
//		System.out.println("URL :: ---------------- " + URL +getParameter(key_word, 2));
//		//1. Document 가져온다
//		Document doc = Jsoup.connect(URL + getParameter(key_word, 2)).get();
//		//2. 목록을 가져온다.
//		//System.out.println(""+doc.toString());
//		Elements elements = doc.select(".detailList li");
//		
//		//3. 배열에서 정보를 가져온다.
//		for(Element element : elements) {
//			int idx = 0;
//			System.out.println(++idx+" : "+element.toString());
//			System.out.println("=====================================/n/n");
//		}
//		
//	}
//	
//	
//	/**
//	 * URL 완성
//	 * @param key_word
//	 * @param page
//	 * @return
//	 */
//	public static String getParameter(String key_word, int page ) {
//			String params = "stext" + key_word + ""
//							+"&IsCoInfoSC=false"
//							+"&IsRecuruit=false"
//							+"&ord=1"
//							+"&Order=1"
//							+"&page=" + page + ""
//							+"&pageSize=10"
//							+"&pageType=HRP";
//							
//							
//					        
//		
//		return params;
//	}
//
//}
