package com.sist.manager;
import java.util.*;

import com.sist.vo.FoodCategoryVO;
import com.sist.vo.FoodHouseVO;

import java.io.*;
public class FoodManager {
   private static ArrayList<FoodCategoryVO>
        cList=new ArrayList<FoodCategoryVO>();
   private static ArrayList<FoodHouseVO>
        fList=new ArrayList<FoodHouseVO>();
   /*
    *         Throwable 
    *         ---------
    *            |
    *     -------------------------------
    *     |                             |
    *    Error                     Exception 
    *                                  |
    *                ---------------------------------
    *                |                               |
    *              CheckedException       UnCheckedException
    *              ----------------      -------------------
    *              컴파일시에 예외처리 확인      예외처리 확인(X)
    *              ------------------    -------------------
    *               java.io                  java.lang
    *               java.net                 java.util
    *               java.sql
    *      목적 : 에러를 사전에 방지 
    *            에러시 정상 수행을 할 수 있게 만든다 
    */
   // 초기화 블록 => static 변수가 있는 경우에 주로 사용 
   // 자동 수행이 된다 , 상속은 안된다 
   static
   {
	   FileReader fr=null;
	   ObjectOutputStream ois=null;
	   FileOutputStream fis=null;
	   try
	   {
		   // 정상 수행 문장 
		   fr=new FileReader("c:\\java_data\\bonjuk.txt");
		   String data="";
		   int i=0;
		   while((i=fr.read())!=-1)//-1 (EOF)
		   {
			   data+=(char)i;
		   }
		   fr.close();
		   
		   String[] cates=data.split("\n");
		   for(String s:cates)
		   {
			   StringTokenizer st=new StringTokenizer(s,"|");
			   
			   FoodCategoryVO vo=new FoodCategoryVO();
			   vo.setCno(Integer.parseInt(st.nextToken().replace("\ufeff", "")));
			   vo.setTitle(st.nextToken());
			   vo.setSubject(st.nextToken());
			   vo.setPoster(st.nextToken());
			   cList.add(vo);
		   }
		   
		  /* fis=new FileOutputStream("c:\\java_data\\bj.txt");
		   ois=new ObjectOutputStream(fis);
		   ois.writeObject(cList);*/
		   
	   }catch(Exception ex)
	   {
		   // 에러 확인후 복구
		   ex.printStackTrace();
	   }
	   finally
	   {
		   // 무조건 수행하는 문장 => 파일 닫기 , 서버 닫기
		   try
		   {
			   fis.close();
			   ois.close();
		   }catch(Exception ex) {}
	   }
	   
	   //FileReader fr=null;
	   //BufferedReader br=null;
	   //FileInputStream fis=null;
	   //ObjectInputStream ois=null;
	   //StringBuffer sb=new StringBuffer();
	   String data="";
	   try
	   {
		   
		   fr=new FileReader("c:\\java_data\\bonjuk.txt");
		   int i=0;
		   while((i=fr.read())!=-1)//-1 (EOF)
		   {
			   data+=(char)i;
		   }
		   fr.close();
		   String[] cates=data.split("\n");
		   for(String s:cates)
		   {
			  try
			  {
			   //s=s.substring(0,s.indexOf("?"));
			   StringTokenizer st=
					   new StringTokenizer(s,"|");
			   System.out.println(s);
			   FoodHouseVO vo=new FoodHouseVO();
			   vo.setCno(Integer.parseInt(st.nextToken().replace("\ufeff", "")));
			   vo.setName(st.nextToken());
			   vo.setSummary(st.nextToken());
			   vo.setPoster(st.nextToken());
			   vo.setPrice(st.nextToken());
			  
			   vo.setNo(st.nextToken());
			   vo.setContent(st.nextToken());
			   
			   fList.add(vo);
			  }catch(Exception ex) {ex.printStackTrace();}
		   }
		   //System.out.println(sb.toString());
		  /* FileOutputStream fos=
				   new FileOutputStream("c:\\java_data\\bj2.txt");
		   ObjectOutputStream oos=new ObjectOutputStream(fos);
		   oos.writeObject(fList);
		   fos.close();
		   oos.close();
		   System.out.println("저장완료!!");*/
		  
   			
       }catch(Exception ex)
	   {
		   ex.printStackTrace();//  에러 확인 / 복구 
	   }
	   finally
	   {
		  try
		  {
			   fis.close();
			   fr.close();
		  }catch(Exception ex) {}
	   }
	   
	
	   
	  
	   /*FileInputStream fis=null;
	    ObjectInputStream ois=null;
	   try
	   {
		   fis=new FileInputStream("c:\\java_data\\bj.txt");
		   ois=new ObjectInputStream(fis);
		   cList=(ArrayList<FoodCategoryVO>)ois.readObject();
	   }catch(Exception ex)
	   {
		   ex.printStackTrace();
	   }
	   finally
	   {
		   try
		   {
			   fis.close();
			   ois.close();
		   }catch(Exception ex) {}
	   }
	   
	      // FileInputStream fis=null;
	  		//ObjectInputStream ois=null;
	  		
	   try
		{
			fis=new FileInputStream("c:\\java_data\\bj2.txt");
			ois=new ObjectInputStream(fis);
			fList=(ArrayList<FoodHouseVO>)ois.readObject();
		}catch(Exception ex)
		{
			ex.printStackTrace();
		}
		finally
		{
			try
			{
				fis.close();
				ois.close();
			}catch (Exception e) {}
		} */
	   

		   
   }
   public static void main(String[] args) {
	   FoodManager fm=new FoodManager();
	   //System.out.println("저장 완료!!");
	   for(FoodHouseVO vo:fList)
	   {
		  
		   System.out.println(vo.getCno());
		   System.out.println(vo.getName());
		   System.out.println(vo.getSummary());
		   System.out.println(vo.getPoster());
		   System.out.println(vo.getPrice());
		   System.out.println(vo.getContent());
		   System.out.println("==============================");
	   }
   }
   
   public ArrayList<FoodCategoryVO> foodCategoryData(int no)
   {
	   ArrayList<FoodCategoryVO> list=
			   new ArrayList<FoodCategoryVO>();
	   int start=0;
	   int end=0;
	   if(no==1)
	   {
		   start=0;
		   end=11;
	   }
	   else if(no==2)
	   {
		   start=12;
		   end=23;
	   }
	   else if(no==3)
	   {
		   start=24;
		   end=35;
	   }
	   else if(no==4)
	   {
		   start=36;
		   end=47;
	   }
	   else if(no==5)
	   {
		   start=48;
		   end=59;
	   }
	   else if(no==6)
	   {
		   start=60;
		   end=71;
	   }
	   else if(no==7)
	   {
		   start=72;
		   end=83;
	   }
	   else if(no==8)
	   {
		   start=84;
		   end=95;
	   }
	   for(int i=start;i<=end;i++)
	   {
		   list.add(cList.get(i));
	   }
	   return list;
   }
   public ArrayList<FoodHouseVO> foodHouseListData(int cno)
   {
	   ArrayList<FoodHouseVO> list=
			   new ArrayList<FoodHouseVO>();
	   for(FoodHouseVO fvo:fList)
	   {
		   if(fvo.getCno()==cno)
		   {
			   list.add(fvo);
		   }
	   }
	   return list;
   }
   public FoodHouseVO foodInfoData(String name)
   {
	   FoodHouseVO vo=new FoodHouseVO();
	   for(FoodHouseVO fvo:fList)
	   {
		   if(fvo.getName().equals(name))
		   {
			   vo=fvo;
			   break;
		   }
	   }
	   return vo;
   }
   public FoodHouseVO foodInfoData(int fno)
   {
	   FoodHouseVO vo=new FoodHouseVO();
	   for(FoodHouseVO fvo:fList)
	   {
		   if(fvo.getFno()==fno)
		   {
			   vo=fvo;
			   break;
		   }
	   }
	   return vo;
   }
   public ArrayList<FoodHouseVO> foodFindData(String title)
   {
	   ArrayList<FoodHouseVO> list=
			   new ArrayList<FoodHouseVO>();
	   for(FoodHouseVO fvo:fList)
	   {
		   if(fvo.getName().contains(title))
		   {
			   list.add(fvo);
		   }
	   }
	   return list;
   }
 
}