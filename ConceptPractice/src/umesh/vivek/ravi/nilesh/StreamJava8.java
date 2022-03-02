package umesh.vivek.ravi.nilesh;

import java.util.*;
import java.util.function.BinaryOperator;
import java.util.stream.Collectors;

public class StreamJava8 {
	
	public static void main(String args []) {
		List<Employee> employeeList = new ArrayList<>();
		
		createEmployeeList(employeeList);
		
		//program to print max/min employee salary from the given collection
		
		double maxSalary = employeeList
				.stream()
				.map(Employee::getSalary)
				.max((s1, s2)-> {
					if( s1 < s2 ) return -1;
					else if (s1 > s2 ) return 1;
					else return 0;
				}).get();
		
		System.out.println("==================== max salary =========================");
		System.out.println(maxSalary);
		
		System.out.println("================== Employee with max Salary ====================");
		//or print employee object 
		Employee emp = employeeList
				.stream()
				.max(
						Comparator.comparingDouble(Employee::getSalary)
				).get();
		
		System.out.println(emp);
		
		System.out.println("==================== min salary =========================");
		double minSalary = employeeList
				.stream()
				.map(Employee::getSalary)
				.min(
						Comparator.comparingDouble(i -> i)
					).get();
		System.out.println(minSalary);
		
		System.out.println("================== Employee with mix Salary ====================");
		//or print employee object 
		Employee minSalEmp = employeeList.stream().min(Comparator.comparingDouble(Employee::getSalary)).get();
		System.out.println(minSalEmp);
		
		
		
		/// max salary from each department
		//steps: 1. grouping by department, 2. then use collector to take max salary for each group
		Map<String, Optional<Employee>> grpByDep = employeeList.stream()
				.collect(
						Collectors
						.groupingBy(
								Employee::getDepartment,
								Collectors.maxBy(Comparator.comparingDouble(Employee::getSalary))));
		grpByDep.forEach((k,v)->{
			System.out.println(k+" -> "+v.get());
		});
		
		//print active and inactive employee
		
		Map<String, List<Employee>> activeInactiveEmp = employeeList
				.stream()
				.collect(Collectors.groupingBy(Employee::getActive));
		
		activeInactiveEmp.forEach((k,v) -> {
			System.out.println(k+":");
			v.forEach(System.out::println);
			System.out.println("-----------");
		});
		
	//print count of active and inactive employee
		/*
		 * Map<String, Long> countActiveInactiveEmp = employeeList .stream() .collect(
		 * Collectors .groupingBy(Employee::getActive, Employee::getSalary, ));
		 * 
		 * countActiveInactiveEmp.forEach((k,v) -> { System.out.println(k+":" +v); });
		 */
	}
	
	private static void createEmployeeList(List<Employee> list) {
		list.add(new Employee(1, "Vivek", 28, "Yes", "Engineering", 2017, 58000));
		list.add(new Employee(2, "Ajit", 28, "Yes", "Engineering", 2017, 138000));
		list.add(new Employee(3, "Umesh", 33, "No", "Govrn.", 2024, 88000));
		list.add(new Employee(4, "Ravi", 27, "Yes", "Govrn.", 2017, 38000));
		list.add(new Employee(5, "Nikul", 28, "No", "Engineering", 2017, 68000));
		list.add(new Employee(6, "Sumedh", 28, "Yes", "Engineering", 2016, 68000));
		list.add(new Employee(7, "Tinku", 24, "No", "Private", 2024, 18000));
		list.add(new Employee(8, "Lalu", 17, "Yes", "Private", 2028, 10000d));
		list.add(new Employee(9, "Gaurav", 32, "No", "Management", 2012, 98000));
		list.add(new Employee(10, "Vijeta", 26, "Yes", "Singing", 2017, 78000));
		list.add(new Employee(11, "Tinny", 28, "Yes", "Private", 2025, 48000));
		list.add(new Employee(12, "Bablu", 38, "Yes", "Private", 2018, 15000));
		list.add(new Employee(13, "Talukdar", 62, "No", "Private", 1966, 10000));
		list.add(new Employee(14, "Manoj", 34, "Yes", "Self", 2008, 65000));
	}
}



class Employee {
	int id;
	String name;
	int age;
	String active;
	String department;
	int yearOfJoining;
	double salary;
	
	public Employee(int id, String name, int age, String active, String department, int yearOfJoining, double salary) {
		super();
		this.id = id;
		this.name = name;
		this.age = age;
		this.active = active;
		this.department = department;
		this.yearOfJoining = yearOfJoining;
		this.salary = salary;
	}
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	public String getActive() {
		return active;
	}
	public void setActive(String active) {
		this.active = active;
	}
	public String getDepartment() {
		return department;
	}
	public void setDepartment(String department) {
		this.department = department;
	}
	public int getYearOfJoining() {
		return yearOfJoining;
	}
	public void setYearOfJoining(int yearOfJoining) {
		this.yearOfJoining = yearOfJoining;
	}
	public double getSalary() {
		return salary;
	}
	public void setSalary(double salary) {
		this.salary = salary;
	}

	@Override
	public String toString() {
		return "Employee [name=" + name + ", age=" + age + ", active=" + active + ", department=" + department
				+ ", yearOfJoining=" + yearOfJoining + ", salary=" + salary + "]";
	}
	
	
}
