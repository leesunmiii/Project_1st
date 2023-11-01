package com.sist.friendship;
import java.io.*;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

public class Crolling01 {
/*
 * data-url="https://cdn.bonif.co.kr/cmdt/BF101_thum_BN100347.jpg"
 * https://cdn.bonif.co.kr/cmdt/BF101_pic_10000277.jpg
 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		try
		{
			
			Document doc=Jsoup.connect("https://www.bonif.co.kr/menu/list?brdCd=BF102").get();
			Elements link=doc.select("a.goods-detail-view");
			for(int i=0;i<link.size();i++)
			{	
				//System.out.println(link.get(i).text());
				
				String subLink="https://www.bonif.co.kr/menu/"+link.get(i).attr("href");
				System.out.println(subLink);
				
				Document doc2=Jsoup.connect(subLink).get();
				Elements title=doc.select("div.goods-name p.nm");
				Elements money=doc.select("div.goods-name p.price");
				Elements poster=doc.select("div.goods-thumb img");
				Elements dd1=doc2.select("p.goods-txt");
				Elements dd2=doc2.select("div.goods-summary");
								

				try {
					
					System.out.println(title.get(i).text());
					System.out.println(money.get(i).text());
					System.out.println(poster.get(i).attr("src"));
					System.out.println(dd1.get(0).text());
					System.out.println(dd2.get(0).text());

					} 
				catch(Exception ex) 
				{
					ex.printStackTrace();
				}
				
				String msg=title.get(i).text()+"|"
				           +money.get(i).text()+"|"
						+subLink+"|"
				        +poster.get(i).attr("src")+"|"
						+dd1.text()+"|"
						+dd2.text()+"\r\n";
				FileWriter fw=new FileWriter("c:\\java_data\\project1.txt",true);
				fw.write(msg);
				fw.close();
			}
	
	}

		catch(Exception ex) 
		{
			ex.printStackTrace();
		}
		
}
	
}