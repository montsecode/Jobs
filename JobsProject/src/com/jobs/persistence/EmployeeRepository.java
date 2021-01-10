package com.jobs.persistence;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;

import com.jobs.domain.AbsStaffMember;
import com.jobs.domain.Employee;

public class EmployeeRepository {

	private static List<AbsStaffMember> members = new ArrayList<>();
	
	public EmployeeRepository(){

	}
	
	public List<AbsStaffMember> getAllMembers(){ return members; }

	public List<Employee> getAllEmployees(){
		List<Employee> result=new ArrayList<>();

		for(AbsStaffMember member : members){
			if(member instanceof Employee){
				result.add((Employee)member);
			}
		}
		return result;

	}

	public void addMember(AbsStaffMember member) throws Exception{
		if(member==null) throw new Exception();
		members.add(member);
	}

	public boolean removeMember2(String name) {
		for(AbsStaffMember member : new ArrayList<>(members)){
			if(member.getName().equals(name)){
				members.remove(member);
				return true;
			}
		}
		return false;
	}
}