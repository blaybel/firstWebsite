package controller;


import java.util.ArrayList;
import java.util.List;
import entity.Employee;
import postgresql.dbOperation;

public class dbMain {
	
	public static void main(String[] args){
	
// Create Table		
	/*	String tableName = "employee";
		String values =
				"(ID INT PRIMARY KEY     NOT NULL," +
	                     " NAME   TEXT    NOT NULL, " +
	                     " AGE            INT     NOT NULL, " +
	                     " ADDRESS        CHAR(50), " +
	                     " SALARY         REAL)";
		
		new dbOperation().createTable(tableName, values);
	*/
		
// Insert records		
	/*	
        List<String> records = new ArrayList<String>();
        
        records.add("INSERT INTO EMPLOYEE (ID,NAME,AGE,ADDRESS,SALARY) VALUES (1, 'Paul', 32, 'California', 20000.00 );");
        records.add("INSERT INTO EMPLOYEE (ID,NAME,AGE,ADDRESS,SALARY) VALUES (2, 'Allen', 25, 'Texas', 15000.00 );");
        records.add("INSERT INTO EMPLOYEE (ID,NAME,AGE,ADDRESS,SALARY) VALUES (3, 'Teddy', 23, 'Norway', 20000.00 );");
        
        new dbOperation().insert(records);
    */
		
		
// Select operation 		
	//	List<Employee> employees = new dbOperation().getEmployees();
	
		
// Select operation by condition	
	//	Employee employee = new dbOperation().getEmployeesById(1);

// update employee Salary 		
	//	new dbOperation().updateEmployeeSalary(1,new Float(20000.0));
	//	new dbOperation().getEmployeesById(1);
		
// delete employee
		new dbOperation().deleteEmployee(2);
		new dbOperation().getEmployees();
		
	}	
}
