package ra.business;

import java.util.Scanner;

public interface IEmployee {
    // Hằng số
    float BASIC_SALARY = 1_300_000;

    // Phương thức
    void inputData(Scanner scanner);
    void displayData();
}
