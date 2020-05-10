package employeeServiceImplementation;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map.Entry;


public class EmployeeServiceImplementation {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}

class Employee {
	  String name;
	  double salary;
	  Integer id;
	  String designation;
	  String InsuranceScheme;

	  public Employee(String name, double salary, Integer id, String designation) {
	    //parameterized constructor
	  }

	  public String getInsuranceScheme(double salary) {
		  String schemeName = new String();
		  if(salary < 5000) {
			  schemeName = "no scheme";
		  } else if(salary >= 5000 && salary < 20000) {
			  schemeName = "scheme c";
		  } else if(salary >= 20000 && salary < 40000) {
			  schemeName = "scheme b";
		  } else if(salary >= 40000) {
			  schemeName = "scheme a";
		  } else {
			  ;//do nothing
		  }
		  return schemeName;
	  }
	}


	class EmployeeServiceImpl {
	  //Declare a Hashmap here where key is an Integer and the value is Employee object
		static HashMap<String, HashMap<Integer, HashMap<String, Object>>> employeeInsurenceHMap = new  HashMap<String,  HashMap<Integer, HashMap<String, Object>>>();
		static HashMap<Integer, HashMap<String, Object>> employeesHMap = new  HashMap<Integer,  HashMap<String, Object>>();
	  public static void addEmployee(Employee emp) {
		  HashMap<String, Object> employeeDetail = new HashMap<String, Object>();
		  employeeDetail.put("name", emp.name);
		  employeeDetail.put("salary", emp.salary);
		  employeeDetail.put("id", emp.id);
		  employeeDetail.put("designation", emp.designation);
		  employeeDetail.put("InsuranceScheme", emp.getInsuranceScheme(emp.salary));
		  employeesHMap.put(emp.id, employeeDetail);
		  if(employeeInsurenceHMap.containsKey(emp.InsuranceScheme)) {
			  HashMap<Integer, HashMap<String, Object>> employeesInsurenceHMap = employeeInsurenceHMap.get(emp.InsuranceScheme);
			  if(employeesInsurenceHMap.containsKey(emp.id))
				  employeesInsurenceHMap.put(emp.id, employeeDetail);
		  } else {
			  HashMap<Integer, HashMap<String, Object>> employeesInsurenceHMap = new HashMap<Integer, HashMap<String, Object>>();
			  employeesInsurenceHMap.put(emp.id, employeeDetail);
			  employeeInsurenceHMap.put(emp.InsuranceScheme, employeesInsurenceHMap);
		  }
			  
	  }

	  public static boolean deleteEmployee(int id){
		  if(employeesHMap.containsKey(id)) {	  
			  HashMap<String, Object> employeeDetail = employeesHMap.get(id);
			  String insuranceScheme = (String) employeeDetail.get("InsuranceScheme");
			  HashMap<Integer, HashMap<String, Object>> employeesInsurenceHMap = employeeInsurenceHMap.get(insuranceScheme);
			  employeesInsurenceHMap.remove(id);
			  employeesHMap.remove(id);
			  return true;
		  }
		  return false;
	  }

	public static String showEmpDetails(String InsuranceScheme) {
	    /*Write your code here to return a string i.e the employee details according to the insurance scheme
	    Format: Name: name Id: id Salary: salary Designation: Designation InsuranceScheme: InsuranceScheme
	    If multiple results they should be in a different line*/
		  String result = new String();
		  if(employeeInsurenceHMap.containsKey(InsuranceScheme)) {
			  HashMap<Integer, HashMap<String, Object>> employeesInsurenceHMap = employeeInsurenceHMap.get(InsuranceScheme);
			  //Iterator<Entry<Integer, HashMap<String, Object>>> employeeIdIterator = employeesInsurenceHMap.entrySet().iterator(); 
			  //HashSet<Integer> idSet  = (HashSet<Integer>) employeesInsurenceHMap.keySet();
			  Iterator<Entry<Integer, HashMap<String, Object>>> hmIterator = employeesInsurenceHMap.entrySet().iterator(); 
			  //while ( ((Iterator<Entry<Integer, HashMap<String, Object>>>) employeesInsurenceHMap).hasNext()) { 
			  while (hmIterator.hasNext()) { 
				//HashMap<String, Object> employeeDetail = employeesInsurenceHMap.get(employeesInsurenceHMap); 
				  HashMap<String, Object> employeeDetail = (HashMap<String, Object>)hmIterator.next();
				  result += "Name: " + employeeDetail.get("name")  + "Id: " + employeeDetail.get("id") + "Salary: " + employeeDetail.get("salary") + "Designation: " + employeeDetail.get("designation") + "InsuranceScheme: " + employeeDetail.get("InsuranceScheme")  + "\n";
			  }
		  }
		  
		  return result;
	  }
	}
	