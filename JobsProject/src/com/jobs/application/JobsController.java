
package com.jobs.application;

import com.jobs.domain.AbsStaffMember;
import com.jobs.domain.Employee;
import com.jobs.domain.Volunteer;
import com.jobs.persistence.EmployeeRepository;

import java.util.ArrayList;
import java.util.List;

public class JobsController {

	private EmployeeRepository repository = new EmployeeRepository();
	
	public JobsController(){
		
	}
	
	public void createBossEmployee(String name, String address, String phone, double salaryPerMonth) throws Exception{		
		Employee boss = new Employee(name, address, phone,  salaryPerMonth, PaymentFactory.createPaymentRateBoss());
		repository.addMember(boss);
	}
	
	public void createEmployee(String name, String address, String phone, double salaryPerMonth) throws Exception{
        Employee employee = new Employee(name, address, phone,  salaryPerMonth, PaymentFactory.createPaymentRateEmployee());
		repository.addMember(employee);
	}

	public void createManagerEmployee(String name, String address, String phone, double salaryPerMonth) throws Exception{
	    Employee manager = new Employee(name, address, phone,  salaryPerMonth, PaymentFactory.createPaymentRateManager());
		repository.addMember(manager);
	}

	public void payAllEmployeers() {
        List<Employee> list = repository.getAllEmployees();
        for (Employee employee : list) {
            employee.pay();
        }
	}

	public void removeRegistry(String name) throws Exception {
	    boolean remove = repository.removeMember2(name);
	    if (!remove){throw new Exception("Remove unsuccessful");}
    }

	public List<MemberDTO> getAllMembers() throws Exception{
		List<AbsStaffMember> members = repository.getAllMembers();
		List<MemberDTO> outList = new ArrayList<>();
		for (AbsStaffMember member: members){
			outList.add(new MemberDTO(member));
		}
		return outList;
	}

	public List<MemberDTO> getAllEmployees() throws Exception{
		List<Employee> employees = repository.getAllEmployees();
		List<MemberDTO> outList = new ArrayList<>();
		for (AbsStaffMember member: employees){
			outList.add(new MemberDTO(member));
		}
		return outList;
	}

	public void createVolunteer(String name, String address, String phone, String description) throws Exception {
		Volunteer volunteer = new Volunteer(name, address, phone, description);
		repository.addMember(volunteer);
	}

}