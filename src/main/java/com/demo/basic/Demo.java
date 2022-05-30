package com.demo.basic;

import java.util.ArrayList;
import java.util.List;

public class Demo {

	private static final String SS = "SS";

	
	public static int test() {
		
		try {
			return 1;
		}catch(Exception e) {
			return 2;
		}finally {
			return 3;
		}		
	}
	public static void main(String arg[]) {
		
		
		System.out.println(test());
		List<Address> addList=		new ArrayList<>();
		Address add1= new Address();
		add1.setAddressLine1("add line 1");
		add1.setAddressLine2("add line 2");
		add1.setPermanentAddress(Boolean.TRUE);
		add1.setZipCode(110010);
		addList.add(add1);
		
		Address add2= new Address();
		add2.setAddressLine1("add line 1");
		add2.setAddressLine2("add line 2");
		add2.setPermanentAddress(Boolean.TRUE);
		add2.setZipCode(110022);
		
		addList.add(add1);		
		addList.add(add2);


  Employee e = new Employee(SS, 28, addList);
//  System.out.println(e);
  Employee e1 = new Employee(SS, 29, addList);
  Employee e2 = new Employee(SS, 39, addList);
  Employee e3 = new Employee(SS, 28, addList);
  
  List<Employee> empList= new ArrayList<Employee>();
  empList.add(e);
  empList.add(e1);
  empList.add(e2);
  empList.add(e3);
  System.out.println(empList.contains(e));
  System.out.println(empList.contains( new Employee(SS, 28, addList)));
System.out.println(  Colors.BLUE.equals(Colors.PURPLE));
  

//e=e1;
	/*
	 * e.getAddresses().add(null); e.getAddresses().remove(0);
	 * 
	 * System.out.println(e);
	 */
  //System.out.println(e2);

	}
}
