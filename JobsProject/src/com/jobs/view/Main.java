package com.jobs.view;

import com.jobs.application.JobsController;

public class Main {

	
	
	private static JobsController controller=new JobsController();
	
	public static void main(String[] args) throws Exception {
		
		controller.createBossEmployee("Pepe Boss", "Direcci贸n molona", "666666666", 100.0);
		controller.createEmployee("Pedro Employee", "Direcci贸n molona 2", "665266666", 40.0);
		controller.createEmployee("Laura Employee", "Direcci贸n molona 3", "625266666", 45.0);
		controller.createVolunteer("Juan Volunteer", "Direcci贸n molona 4", "614266666");
		controller.createManagerEmployee("Pedro Employee", "Direcci贸n molona 2", "665226666", 80.0);
		
		
		controller.payAllEmployeers();
		
		String allEmployees=controller.getAllEmployees();
		
		System.out.println("EMPLOYEES: " + allEmployees + " \n");
		
	}

}


package com.jobs.view;

import com.jobs.application.JobsController;
import com.jobs.application.MemberDTO;

import java.util.List;

public class Main {


	private static JobsController controller = new JobsController();

	public static void main(String[] args) throws Exception {

		controller.createBossEmployee("Pepe Boss", "Direcci髇 molona", "666666666", 100.0);
		controller.createEmployee("Pedro Employee", "Direcci髇 molona 2", "665266666", 40.0);
		controller.createEmployee("Laura Employee", "Direcci髇 molona 3", "625266666", 45.0);
		controller.createVolunteer("Juan Volunteer", "Direcci髇 molona 4", "614266666", "Descripci髇 molona");
		controller.createManagerEmployee("Pedro Employee", "Direcci髇 molona 2", "665226666", 80.0);
		controller.createManagerEmployee("Manolo Employee", "Direcci髇 molona 2", "665226666", 80.0);

        try {
            controller.removeRegistry("Manolo Employee");
        }catch (Exception e){
            System.out.println(e.getMessage() + "\n");
        }
		controller.payAllEmployeers();

        List<MemberDTO> members =controller.getAllMembers();
        StringBuilder displayMembers = new StringBuilder();
        for (MemberDTO member: members){
            displayMembers.append("Name: " + member.getName() + " ");
            displayMembers.append("Phone: " + member.getPhone() + " ");
            displayMembers.append("Address: " + member.getAddress() + " ");
            displayMembers.append("Salary per Month: " + member.getSalaryPerMonth());
            displayMembers.append("Income: " + member.getTotalPaid() + " ");
            displayMembers.append("\n");
        }

        List<MemberDTO> employees =controller.getAllEmployees();
        StringBuilder displayEmployees = new StringBuilder();
        for (MemberDTO employee: employees){
            displayEmployees.append("Name: " + employee.getName() + " ");
            displayEmployees.append("Phone: " + employee.getPhone() + " ");
            displayEmployees.append("Address: " + employee.getAddress() + " ");
            displayEmployees.append("Salary per Month: " + employee.getSalaryPerMonth());
            displayEmployees.append("Income: " + employee.getTotalPaid() + " ");
            displayEmployees.append("\n");
        }

        System.out.println("Staff: " + "\n" + displayMembers);
        System.out.println("Employees: " + "\n" + displayEmployees);

	}
}

