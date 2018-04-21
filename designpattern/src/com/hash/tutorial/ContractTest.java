package com.hash.tutorial;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class ContractTest {
public static void main(String args[])
{Map<EmployeeKey,String>cache=loadEmpCache();
EmployeeKey e1=new EmployeeKey("1", "4/10/1994");
EmployeeKey e2=new EmployeeKey("1", "4/10/1994");
EmployeeKey e3=new EmployeeKey("1", "5/10/1994");

EmployeeKey e4=new EmployeeKey("2", "5/10/1994");
Set<EmployeeKey>set=new HashSet<>();
set.add(e1);
set.add(e2);
set.add(e3);
set.add(e4);
//String empName=cache.get(e1);
	System.out.println(set);
}
static Map<EmployeeKey,String> loadEmpCache()
{
	EmployeeKey  e1=new EmployeeKey("1", "4/10/1994");
	EmployeeKey  e2=new EmployeeKey("2", "5/10/1994");
	EmployeeKey  e3=new EmployeeKey("3", "6/10/1994");
	Map<EmployeeKey,String> cache=new HashMap<>();
	cache.put(e1,"Anandh" );
	cache.put(e2,"Bob");
	cache.put(e3,"Steve");
	return cache;
	
	
}
}
 class EmployeeKey
{
	private String empId;
	private String dob;
	
	EmployeeKey(String id,String dob)
	{
		this.empId=id;
		this.dob=dob;
		
	}

	

	



	@Override
	public String toString() {
		return "EmployeeKey [empId=" + empId + ", dob=" + dob + "]";
	}




	


	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((dob == null) ? 0 : dob.hashCode());
		result = prime * result + ((empId == null) ? 0 : empId.hashCode());
		return result;
	}







	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		EmployeeKey other = (EmployeeKey) obj;
		if (dob == null) {
			if (other.dob != null)
				return false;
		} else if (!dob.equals(other.dob))
			return false;
		if (empId == null) {
			if (other.empId != null)
				return false;
		} else if (!empId.equals(other.empId))
			return false;
		return true;
	}
}