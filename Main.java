import java.util.ArrayList;
import java.util.Scanner;

abstract class Employee{
    private String name;
    private int id;

    Employee(String name,int id){
        this.id=id;
        this.name=name;
    }

    abstract double calculateSalary();

    public String getName(){
        return name;
    }

    public int getId(){
        return id;
    }

    public String toString(){
       return "Employee [id : "+id+" Name : " +name+ "  Salary : "+calculateSalary()+"]";
    }
}

class fullTimeEmployee extends Employee{
    private double MonthlySalary;
    fullTimeEmployee(String name,int id,double MonthlySalary){
        super(name,id);
        this.MonthlySalary=MonthlySalary;
    }

    public double calculateSalary(){
        return MonthlySalary;
    }
}

class partTimeEmployee extends Employee{
    private double Salary;
    private double ratePerHour;
    partTimeEmployee(String name,int id,double Salary,int ratePerHour){
        super(name,id);
        this.Salary=Salary;
        this.ratePerHour=ratePerHour;
    }
    public double calculateSalary(){
        return ratePerHour*Salary;
    }
}

class Payroll{
    ArrayList<Employee> employeeList = new ArrayList<>();

    public void addEmployee(Employee emp){
        employeeList.add(emp);
    }

    public void removeEmployee(int id){
        Employee removermp=null;
        for (Employee employee : employeeList) {
            if(employee.getId()==id){
                removermp=employee;
                break;
            }
        }
        if(removermp!=null){
            employeeList.remove(removermp);
        }
    }

    public void display(){
        for (Employee employee : employeeList) {
            System.out.println(employee);
        }
    }
}

class Main{
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        Payroll payroll=new Payroll();
        System.out.println("How many employee do u want to add");
        int n=sc.nextInt();
        for(int i=0;i<n;i++){
            System.out.println("For employee"+(i+1));

            System.out.print("ID : ");
            int id=sc.nextInt();

            System.out.print("Name : ");
            String name=sc.next();

            System.out.println("the employee are 1. FullTime and 2.PartTime");
            int sw=sc.nextInt();
            switch (sw) {
                case 1:
                        System.out.println("Enter Monthly Salary : ");
                        double salary=sc.nextInt();
                        payroll.addEmployee(new fullTimeEmployee(name, id, salary));
                        break;
                case 2:{
                         System.out.print("Enter hours worked: ");
                        int hours = sc.nextInt();
                        System.out.print("Enter rate per hour: ");
                        double rate = sc.nextDouble();

                        payroll.addEmployee(new partTimeEmployee(name,id,rate,hours));
                    }
                default:System.out.println("Enter proper number");
            }   
        }

        System.out.println("Employee details : ");
        payroll.display();
        System.err.println();

        System.out.println("Do you want to remove any Employee");
        System.out.println("1.Yes 2.No");

        int num=sc.nextInt();
        switch (num) {
            case 1: System.out.println("Enter Emplopyee Id u want to delete");
                    payroll.display();
                    int id=sc.nextInt();
                    payroll.removeEmployee(id);
                    System.out.println("After removing Employee :");
                    payroll.display();
                    break;
            case 2:System.out.println("Employee details : ");
                    payroll.display();
                    break;
            default:System.out.println("Please enter proper number");
                break;
        }

    }
}
