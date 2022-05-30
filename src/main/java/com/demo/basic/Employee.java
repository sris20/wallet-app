package com.demo.basic;

import java.util.ArrayList;
import java.util.List;

public final class Employee {
	
	private final String name;
	private final int age;
	private final List<Address> addresses;
	
		
	public Employee(String name, int age, List<Address> addresses) {
		super();
		this.name = name;
		this.age = age;
		
		List<Address> tempList= new ArrayList<>();
		addresses.forEach(add -> tempList.add(add));
		this.addresses = tempList;
	}
	public String getName() {
		return name;
	}
	public int getAge() {
		return age;
	}
	public List<Address> getAddresses() {
		List<Address> tempList= new ArrayList<>();
		this.addresses.forEach(add -> tempList.add(add));
		return tempList;
	}
	
	@Override
	public String toString() {
		return "Employee [name=" + name + ", age=" + age + ", addresses=" + addresses + "]";
	}
	
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Employee other = (Employee) obj;
		if (addresses == null) {
			if (other.addresses != null)
				return false;
		} else if (!addresses.equals(other.addresses))
			return false;
		if (age != other.age)
			return false;
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		return true;
	}
	
	

}
