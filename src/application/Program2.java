package application;

import model.dao.DaoFactory;
import model.dao.DepartmentDao;
import model.entities.Department;

import java.util.Comparator;
import java.util.List;
import java.util.Scanner;

public class Program2 {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        DepartmentDao departmentDao = DaoFactory.createDepartmentDao();

        System.out.println("===== TEST 1: department findById =====");
        Department department = departmentDao.findById(3);
        System.out.println(department);

        System.out.println("\n===== TEST 2: department findAll =====");
        List<Department> list = departmentDao.findAll();
        list.sort(Comparator.comparingInt(Department::getId));

        for (Department d : list) {
            System.out.println(d);
        }

        System.out.println("\n===== TEST 3: department insert =====");
        Department newDepartment = new Department(7, "Clothes");
        departmentDao.insert(newDepartment);
        System.out.println("Inserted! New Department Id = " + newDepartment.getName());

        System.out.println("\n===== TEST 4: department update =====");
        department = departmentDao.findById(2);
        department.setName("Tools");
        departmentDao.update(department);
        System.out.println("Update completed");

        System.out.println("\n===== TEST 5: department deleteById =====");
        System.out.print("Enter id department for delete test: ");
        int id = sc.nextInt();
        departmentDao.deleteById(id);
        System.out.println("Delete completed");

        sc.close();

    }

}
