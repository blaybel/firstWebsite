package postgresql;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import entity.Employee;

public class dbOperation {

	private Connection connection;
	
	public dbOperation(){
		connection = new dbConnection().getConnection("Project_Database","postgres","123456");
	}
	
	public void createTable(String tableName,String values){
		Statement stmt = null;
		
		try{
		stmt = connection.createStatement();
        String sql = "CREATE TABLE "+ tableName+ " "+ values;
        stmt.executeUpdate(sql);
        stmt.close();
        connection.close();
      } catch ( Exception e ) {
        System.err.println( e.getClass().getName()+": "+ e.getMessage() );
      }
	}
	
	public void insert(List<String> records){
			
		 Statement stmt = null;
	      try {
	         stmt = connection.createStatement();
	         for(String record : records){ 
		         stmt.executeUpdate(record);
	         }
	         stmt.close();
	         connection.close();
	      } catch (Exception e) {
	         System.err.println( e.getClass().getName()+": "+ e.getMessage() );
	         System.exit(0);
	      }
	}
	
	
	public List<Employee> getEmployees(){
		
		Statement stmt = null;
        List<Employee> employees = new ArrayList<Employee>();
		
		try{
		 stmt = connection.createStatement();
         ResultSet rs = stmt.executeQuery( "SELECT * FROM employee;" );
                 
         while ( rs.next() ) {
        	 
        	Employee employee = new Employee(rs.getInt("id"), rs.getString("name"),
        			 rs.getInt("age"), rs.getString("address"), rs.getFloat("salary"));        	 
     		System.out.println("id: "+employee.getId());
     		System.out.println("Name: "+employee.getName());
     		System.out.println("Age: "+employee.getAge());
     		System.out.println("Address: "+employee.getAddress());
     		System.out.println("Salary: "+employee.getSalary());
     		
     		employees.add(employee);

         }
         rs.close();
         stmt.close();
         connection.close();
       } catch ( Exception e ) {
         System.err.println( e.getClass().getName()+": "+ e.getMessage() );
       }		
		return employees;
	}
	
	
	public Employee getEmployeesById(Integer id){
		
		Statement stmt = null;
		Employee employee = null;
		
		try{
		 stmt = connection.createStatement();
         ResultSet rs = stmt.executeQuery( "SELECT * FROM employee where id = " + id);
                 
         while ( rs.next() ) {
        	 
        	employee = new Employee(rs.getInt("id"), rs.getString("name"),
        			 rs.getInt("age"), rs.getString("address"), rs.getFloat("salary"));
        	 
     		System.out.println("id: "+employee.getId());
     		System.out.println("Name: "+employee.getName());
     		System.out.println("Age: "+employee.getAge());
     		System.out.println("Address: "+employee.getAddress());
     		System.out.println("Salary: "+employee.getSalary());
         }
         rs.close();
         stmt.close();
         connection.close();
       } catch ( Exception e ) {
         System.err.println( e.getClass().getName()+": "+ e.getMessage() );
       }		
		return employee;
	}
	
	
	
	public void updateEmployeeSalary(Integer id, float salary){
		
		Statement stmt = null;
 		
		try{
		 connection.setAutoCommit(false);
		 stmt = connection.createStatement();
		 
		 String sql = "UPDATE employee set SALARY = "+salary+" where ID =" + id;
         stmt.executeUpdate(sql);
         connection.commit();
         stmt.close();
         connection.close();
       } catch ( Exception e ) {
         System.err.println( e.getClass().getName()+": "+ e.getMessage() );
       }		
	}
	
	public void deleteEmployee(Integer id){
		
		Statement stmt = null;
	       try {
	         stmt = connection.createStatement();
	         String sql = "DELETE from employee where ID= "+ id;
	         stmt.executeUpdate(sql);
	         stmt.close();
	         connection.close();
	         
	       } catch ( Exception e ) {
	         System.err.println( e.getClass().getName()+": "+ e.getMessage() );
	       }
	}

}
