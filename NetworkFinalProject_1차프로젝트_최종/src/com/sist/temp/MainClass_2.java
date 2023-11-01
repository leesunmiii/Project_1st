package com.sist.temp;
import java.util.*;

class Student
{
	private String name;
	private int age;
	public Student(String name, int age) {
		super();
		this.name = name;
		this.age = age;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	
}
 
public class MainClass_2 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
        ArrayList<Student> list=
        		new ArrayList<Student>();
        list.add(new Student("aaa", 30));
        list.add(new Student("aaa", 30));
        list.add(new Student("bbb", 30));
        list.add(new Student("bbb", 30));
        list.add(new Student("ccc", 30));
        
        List<Student> arr=DeduplicationUtils.deduplication(list, Student::getName);
        for(Student s:arr)
        {
        	System.out.println(s.getName());
        }
	}

}