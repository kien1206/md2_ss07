package ra.presentation;

import ra.businessImp.Employee;
import java.util.Scanner;

public class EmployeeManagement {
    // Mảng nhân viên
    private Employee[] employees = new Employee[1000];
    private int employeeCount = 0;

    public void displayMenu() {
        Scanner scanner = new Scanner(System.in);
        int choice;

        do {
            System.out.println("********************MENU*********************");
            System.out.println("1. Nhập thông tin cho n nhân viên");
            System.out.println("2. Hiển thị thông tin nhân viên");
            System.out.println("3. Tính lương cho các nhân viên");
            System.out.println("4. Tìm kiếm nhân viên theo tên nhân viên");
            System.out.println("5. Cập nhật thông tin nhân viên");
            System.out.println("6. Xóa nhân viên theo mã nhân viên");
            System.out.println("7. Sắp xếp nhân viên theo lương tăng dần");
            System.out.println("8. Sắp xếp nhân viên theo tên nhân viên giảm dần");
            System.out.println("9. Thoát");
            System.out.print("Chọn một tùy chọn: ");
            choice = Integer.parseInt(scanner.nextLine());

            switch (choice) {
                case 1:
                    inputEmployees(scanner);
                    break;
                case 2:
                    displayEmployees();
                    break;
                case 3:
                    calculateSalaries();
                    break;
                case 4:
                    searchEmployeeByName(scanner);
                    break;
                case 5:
                    updateEmployeeInfo(scanner);
                    break;
                case 6:
                    deleteEmployeeById(scanner);
                    break;
                case 7:
                    sortEmployeesBySalary();
                    break;
                case 8:
                    sortEmployeesByName();
                    break;
                case 9:
                    System.out.println("Thoát chương trình!");
                    break;
                default:
                    System.out.println("Lựa chọn không hợp lệ! Vui lòng chọn lại.");
            }
        } while (choice != 9);

        scanner.close();
    }

    private void inputEmployees(Scanner scanner) {
        System.out.print("Nhập số lượng nhân viên: ");
        int n = Integer.parseInt(scanner.nextLine());

        for (int i = 0; i < n; i++) {
            Employee employee = new Employee();
            employee.inputData(scanner);
            employees[employeeCount++] = employee;
        }
    }

    private void displayEmployees() {
        for (int i = 0; i < employeeCount; i++) {
            employees[i].displayData();
            System.out.println("-------------------------");
        }
    }

    private void calculateSalaries() {
        for (int i = 0; i < employeeCount; i++) {
            employees[i].calSalary();
        }
        System.out.println("Đã tính lương cho tất cả các nhân viên.");
    }

    private void searchEmployeeByName(Scanner scanner) {
        System.out.print("Nhập tên nhân viên cần tìm: ");
        String name = scanner.nextLine();

        for (int i = 0; i < employeeCount; i++) {
            if (employees[i].getName().equalsIgnoreCase(name)) {
                employees[i].displayData();
            }
        }
    }

    private void updateEmployeeInfo(Scanner scanner) {
        System.out.print("Nhập mã nhân viên cần cập nhật: ");
        String id = scanner.nextLine();

        for (int i = 0; i < employeeCount; i++) {
            if (employees[i].getId().equals(id)) {
                employees[i].inputData(scanner);
                break;
            }
        }
    }

    private void deleteEmployeeById(Scanner scanner) {
        System.out.print("Nhập mã nhân viên cần xóa: ");
        String id = scanner.nextLine();

        for (int i = 0; i < employeeCount; i++) {
            if (employees[i].getId().equals(id)) {
                for (int j = i; j < employeeCount - 1; j++) {
                    employees[j] = employees[j + 1];
                }
                employees[--employeeCount] = null;
                System.out.println("Nhân viên đã được xóa.");
                break;
            }
        }
    }

    private void sortEmployeesBySalary() {
        for (int i = 0; i < employeeCount - 1; i++) {
            for (int j = i + 1; j < employeeCount; j++) {
                if (employees[i].getSalary() > employees[j].getSalary()) {
                    Employee temp = employees[i];
                    employees[i] = employees[j];
                    employees[j] = temp;
                }
            }
        }
        System.out.println("Đã sắp xếp nhân viên theo lương tăng dần.");
    }

    private void sortEmployeesByName() {
        for (int i = 0; i < employeeCount - 1; i++) {
            for (int j = i + 1; j < employeeCount; j++) {
                if (employees[i].getName().compareTo(employees[j].getName()) < 0) {
                    Employee temp = employees[i];
                    employees[i] = employees[j];
                    employees[j] = temp;
                }
            }
        }
        System.out.println("Đã sắp xếp nhân viên theo tên giảm dần.");
    }

    public static void main(String[] args) {
        EmployeeManagement management = new EmployeeManagement();
        management.displayMenu();
    }
}
