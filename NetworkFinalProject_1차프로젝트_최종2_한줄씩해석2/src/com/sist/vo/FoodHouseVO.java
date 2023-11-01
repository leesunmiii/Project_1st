package com.sist.vo;

import java.io.Serializable;

/*
 *  1|1|가양칼국수버섯매운탕|4.3|
 *  서울특별시 영등포구 국제금융로 78 홍우빌딩 B1 지번 서울시 영등포구 여의도동 43-3 홍우빌딩 B1|
 *  02-784-0409|
 *  국수 / 면 요리|
 *  만원-2만원|
 *  유료주차 가능|
 *  11:30 - 21:30|
 *  가양칼국수버섯매운탕 12,000원 샤브 소고기 (200g) 12,000원|
 *  https://mp-seoul-image-production-s3.mangoplate.com/52481_1621066187997112.jpg?fit=around|512:512&crop=512:512;*,*&output-format=jpg&output-quality=80^https://mp-seoul-image-production-s3.mangoplate.com/673960_1689725902210805.jpg?fit=around|512:512&crop=512:512;*,*&output-format=jpg&output-quality=80^https://mp-seoul-image-production-s3.mangoplate.com/673960_1689725904425496.jpg?fit=around|512:512&crop=512:512;*,*&output-format=jpg&output-quality=80^https://mp-seoul-image-production-s3.mangoplate.com/24979_1686491189261172.jpg?fit=around|512:512&crop=512:512;*,*&output-format=jpg&output-quality=80^https://mp-seoul-image-production-s3.mangoplate.com/24979_1686491193055171.jpg?fit=around|512:512&crop=512:512;*,*&output-format=jpg&output-quality=80
 */
 
public class FoodHouseVO implements Serializable{
	private int fno;
	private int cno; // category 참조 번호
	// => 오라클: foreign key
	private String name;
	private String price;
	private String summary;
	private String content;
	private String poster;
	private String no;
	public int getFno() {
		return fno;
	}
	public void setFno(int fno) {
		this.fno = fno;
	}
	public int getCno() {
		return cno;
	}
	public void setCno(int cno) {
		this.cno = cno;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getPrice() {
		return price;
	}
	public void setPrice(String price) {
		this.price = price;
	}
	public String getSummary() {
		return summary;
	}
	public void setSummary(String summary) {
		this.summary = summary;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public String getPoster() {
		return poster;
	}
	public void setPoster(String poster) {
		this.poster = poster;
	}
	public String getNo() {
		return no;
	}
	public void setNo(String no) {
		this.no = no;
	}
	
}