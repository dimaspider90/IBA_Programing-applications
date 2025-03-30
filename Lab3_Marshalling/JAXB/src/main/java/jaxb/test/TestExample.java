package jaxb.test;

import jaxb.model.Company;
import jaxb.model.Department;
import jaxb.model.Employee;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;
import java.io.File;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.List;

public class TestExample {
    //private static final String XML_FILE = "dept-info.xml";
    private static final String XML_FILE = "comp-dept-info.xml";

    public static void main(String[] args) {

        Employee emp1 = new Employee("E01", "Tom", null);
        Employee emp2 = new Employee("E02", "Mary", "E01");
        Employee emp3 = new Employee("E03", "John", null);

        List<Employee> list = new ArrayList<Employee>();
        list.add(emp1);
        list.add(emp2);
        list.add(emp3);

        Department dept1 = new Department("D01", "ACCOUNTING", "NEW YORK");
        Department dept2 = new Department("D02", "TESTING", "NEW YORK");
        Department dept3 = new Department("D03", "DEVELOPING", "NEW YORK");

        List<Department> list1 = new ArrayList<Department>();
        list1.add(dept1);
        list1.add(dept2);
        list1.add(dept3);
        dept1.setEmployees(list);
        dept2.setEmployees(list);
        dept3.setEmployees(list);

        Company comp = new Company("C01", "Apple");
        List<Company> list2 = new ArrayList<Company>();
        list2.add(comp);
        comp.setDepartments(list1);


        try {
            // create JAXB context and instantiate marshaller
            JAXBContext context = JAXBContext.newInstance(Company.class);

            // (1) Marshaller : Java Object to XML content.
            Marshaller m = context.createMarshaller();
            m.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, Boolean.TRUE);
            
            m.marshal(comp, System.out);

            // Write to File
            File outFile = new File(XML_FILE);
            m.marshal(comp, outFile);

            System.err.println("Write to file: " + outFile.getAbsolutePath());
// (2) Unmarshaller : Read XML content to Java Object.
            Unmarshaller um = context.createUnmarshaller();

            // XML file create before.


            //Department deptFromFile1 = (Department) um.unmarshal(new FileReader(XML_FILE));
            Company compFromFile = (Company) um.unmarshal(new FileReader(XML_FILE));
            List<Department> departments = compFromFile.getDepartments();
            for (Department department : departments) {
                System.out.println("Department: " + department.getDeptName());
                List<Employee> emps = department.getEmployees();
                for (Employee emp : emps) {
                    System.out.println("Employee: " + emp.getEmpName());
                }
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
