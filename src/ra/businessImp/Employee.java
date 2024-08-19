package ra.businessImp;

import ra.business.IEmployee;
import java.util.Scanner;

public class Employee implements IEmployee {
    // Các thuộc tính
    private String id;
    private String name;
    private int year;
    private float rate;
    private float commission;
    private float salary;
    private boolean status;

    // Constructors
    public Employee() {
    }

    public Employee(String id, String name, int year, float rate, float commission, boolean status) {
        this.id = id;
        this.name = name;
        this.year = year;
        this.rate = rate;
        this.commission = commission;
        this.status = status;
    }

    // Getter và Setter
    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public float getRate() {
        return rate;
    }

    public void setRate(float rate) {
        this.rate = rate;
    }

    public float getCommission() {
        return commission;
    }

    public void setCommission(float commission) {
        this.commission = commission;
    }

    public float getSalary() {
        return salary;
    }

    public boolean isStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }

    // Triển khai các phương thức từ IEmployee
    @Override
    public void inputData(Scanner scanner) {
        System.out.print("Enter employee ID: ");
        this.id = scanner.nextLine();
        System.out.print("Enter employee name: ");
        this.name = scanner.nextLine();
        System.out.print("Enter employee birth year: ");
        this.year = Integer.parseInt(scanner.nextLine());
        System.out.print("Enter employee rate: ");
        this.rate = Float.parseFloat(scanner.nextLine());
        System.out.print("Enter employee commission: ");
        this.commission = Float.parseFloat(scanner.nextLine());
        System.out.print("Is the employee currently working? (true/false): ");
        this.status = Boolean.parseBoolean(scanner.nextLine());
    }

    @Override
    public void displayData() {
        System.out.println("Employee ID: " + this.id);
        System.out.println("Employee Name: " + this.name);
        System.out.println("Employee Birth Year: " + this.year);
        System.out.println("Employee Rate: " + this.rate);
        System.out.println("Employee Commission: " + this.commission);
        System.out.println("Employee Salary: " + this.salary);
        System.out.println("Employee Status: " + (this.status ? "Working" : "Not Working"));
    }

    // Phương thức tính lương
    public void calSalary() {
        this.salary = this.rate * BASIC_SALARY + this.commission;
    }
}
