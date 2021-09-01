package JDBC_Connectivity.PayrollService_JDBC;

import java.sql.SQLException;
import java.util.List;
import java.util.Scanner;

public class EmployeePayroll
{

    static final Scanner s = new Scanner(System.in);

    public static void main(String[] args) throws ClassNotFoundException, SQLException {

        System.out.println("Press 1 to Insert Data\nPress 2 to Reterive data"
                + "\nPress 3 to Update data\nPress 4 to Retrive Data ParticularDateRange"
                + "\nPress 5 to get Sum");
        int choice = s.nextInt();

        switch(choice) {
            case 1:
                insertData();
                break;
            case 2:
                reteriveData();
                break;
            case 3:
                UpdateData();
                break;
            case 4:
                ReteriveDataForParticularDateRange();
                break;
            case 5:
                ApplyDatabaseFunction();
                break;
        }
    }


    private static void reteriveData() throws SQLException {
        EmployeeRepo repo = new EmployeeRepo();
        List<Employee> details = repo.findAll();
        details.forEach(System.out::println);
    }

    private static void insertData() throws ClassNotFoundException, SQLException {
        System.out.println("Enter FirstName");
        Employee details = new Employee();
        details.setFirstName(s.next());

        System.out.println("Enter LastName");
        details.setLastName(s.next());

        EmployeeRepo repo = new EmployeeRepo();
        repo.insertRecord(details);
    }

    private static void UpdateData() throws SQLException {

        System.out.println("Enter Id");
        int id = s.nextInt();

        System.out.println("Enter BasicPay");
        float basicPay = s.nextFloat();

        EmployeeRepo repo = new EmployeeRepo();
        repo.updatedata(id, basicPay);
    }

    private static void ReteriveDataForParticularDateRange() throws SQLException {
        EmployeeRepo repo = new EmployeeRepo();
        List<Employee> details = repo.findAllForParticularDateRange();
        details.forEach(System.out::println);
    }

    private static void ApplyDatabaseFunction() throws SQLException {
        EmployeeRepo repo = new EmployeeRepo();
        repo.usedatabaseFunction();
    }
}