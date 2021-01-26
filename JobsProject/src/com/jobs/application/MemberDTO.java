import com.jobs.domain.Employee;

public class MemberDTO {

    private String name;
    private String address;
    private String phone;
    private double salaryPerMonth;
    private double totalPaid;

    protected MemberDTO(AbsStaffMember member) throws Exception{
        if (member == null) throw new Exception();
        this.name = member.getName();
        this.address = member.getAddress();
        this.phone = member.getPhone();
        this.totalPaid = member.getTotalPaid();

        if(member instanceof Employee) initEmployee((Employee)member);
    }

    protected void initEmployee(Employee employee) throws Exception{
        this.salaryPerMonth = employee.getSalaryPerMonth();
    }

    public String getName() {
        return name;
    }

    public String getAddress() {
        return address;
    }

    public String getPhone() {
        return phone;
    }

    public double getSalaryPerMonth() { return salaryPerMonth; }

    public double getTotalPaid() {
        return totalPaid;
    }
}