package umesh.vivek.ravi.nilesh;

import java.util.*;
import java.util.function.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

class TempStudent {
	public String name;
	public int age;
	public Address address;
	public List<MobileNumber> mobileNumbers;

	public TempStudent(String name, int age, Address address, List<MobileNumber> mobileNumbers) {
		this.name = name;
		this.age = age;
		this.address = address;
		this.mobileNumbers = mobileNumbers;
	}
}

class Student {
	private String name;
	private int age;
	private Address address;
	private List<MobileNumber> mobileNumbers;

	public Student(String name, int age, Address address, List<MobileNumber> mobileNumbers) {
		this.name = name;
		this.age = age;
		this.address = address;
		this.mobileNumbers = mobileNumbers;
	}

	public String getName() {
		return name;
	}

	public int getAge() {
		return age;
	}

	public Address getAddress() {
		return address;
	}

	public List<MobileNumber> getMobileNumbers() {
		return mobileNumbers;
	}

	public void setName(String name) {
		this.name = name;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public void setAddress(Address address) {
		this.address = address;
	}

	public void setMobileNumbers(List<MobileNumber> mobileNumbers) {
		this.mobileNumbers = mobileNumbers;
	}

	@Override
	public String toString() {
		return "Student{" + "name='" + name + '\'' + ", age=" + age + ", address=" + address + ", mobileNumbers="
				+ mobileNumbers + '}';
	}
}

class Address {
	private String zipcode;

	public Address(String zipcode) {
		this.zipcode = zipcode;
	}

	public String getZipcode() {
		return zipcode;
	}

	public void setZipcode(String zipcode) {
		this.zipcode = zipcode;
	}
}

class MobileNumber {
	private String number;

	public MobileNumber(String number) {
		this.number = number;
	}

	public String getNumber() {
		return number;
	}

	public void setNumber(String number) {
		this.number = number;
	}
}

public class StreamTest {
	public static void main(String[] args) {

		Student student1 = new Student("Jayesh", 20, new Address("1234"),
				Arrays.asList(new MobileNumber("1233"), new MobileNumber("1234")));

		Student student2 = new Student("Khyati", 20, new Address("1235"),
				Arrays.asList(new MobileNumber("1111"), new MobileNumber("3333"), new MobileNumber("1233")));

		Student student3 = new Student("Jason", 20, new Address("1236"),
				Arrays.asList(new MobileNumber("3333"), new MobileNumber("4444")));

		List<Student> students = Arrays.asList(student1, student2, student3);

		/*****************************************************
		 * Get student with exact match name "jayesh"
		 *****************************************************/

		String jayesh = students
				.stream()
				.filter(s -> s.getName().equals("Jayesh"))
				.map(Student::getName)
				.findFirst()
				.get();
		
		
		Optional<Student> jayOpt = students
				.stream()
				.filter(s -> s.getName().equals("Jayesh"))
				.findFirst();

		System.out.println("--------------------");
		System.out.println("is Jayesh there : ");
		System.out.println(jayOpt.isPresent() ? jayOpt.get().getName() : " Not Present");

		System.out.println("--------------------");

		Optional<Student> matAdd = students.stream().filter(s -> s.getAddress().getZipcode().equals("1235"))
				.findFirst();

		System.out.println("Student of address: 1235 ");
		System.out.println(matAdd.isPresent() ? matAdd.get().getName() : " Not Present");
		System.out.println("--------------------");

		System.out.println("Students with MN: 3333 ");

		List<Student> studs = students.stream()
				.filter(s -> s.getMobileNumbers().stream().anyMatch(x -> x.getNumber().equals("3333")))
				.collect(Collectors.toList());
		studs.forEach(s -> System.out.print(" " + s.getName()));
		System.out.println();
		System.out.println("--------------------");

		System.out.println("Get all student having mobile number 1233 and 1234");
		List<Student> sts = students.stream()
				.filter(s -> s.getMobileNumbers().stream()
						.anyMatch(x -> x.getNumber().equals("1233") || x.getNumber().equals("1234")))
				.collect(Collectors.toList());
		sts.forEach(s -> System.out.print(" " + s.getName()));
		System.out.println();
		System.out.println("--------------------");

		System.out.println("Get all student having mobile number 1233 and 1234 - 2");
		List<Student> st = students.stream()
				.filter(s -> s.getMobileNumbers().stream()
						.allMatch(x -> Objects.equals(x.getNumber(), "1233") || Objects.equals(x.getNumber(), "1234")))
				.collect(Collectors.toList());
		st.forEach(s -> System.out.print(" " + s.getName()));
		System.out.println();
		System.out.println("--------------------");

		System.out.println("Create a List<Student> from the List<TempStudent>");

		TempStudent tmpStud1 = new TempStudent("Jayesh1", 201, new Address("12341"),
				Arrays.asList(new MobileNumber("12331"), new MobileNumber("12341")));

		TempStudent tmpStud2 = new TempStudent("Khyati1", 202, new Address("12351"),
				Arrays.asList(new MobileNumber("11111"), new MobileNumber("33331"), new MobileNumber("12331")));

		List<TempStudent> tmpStudents = Arrays.asList(tmpStud1, tmpStud2);

		List<Student> st2 = tmpStudents.stream()
				.map(tmpStd -> new Student(tmpStd.name, tmpStd.age, tmpStd.address, tmpStd.mobileNumbers))
				.collect(Collectors.toList());

		st2.forEach(s -> System.out.print(" " + s.getName()));
		System.out.println();
		System.out.println("--------------------");

		/*****************************************************
		 * Convert List<Student> to List<String> of student name
		 *****************************************************/

		List<String> names = students.stream().map(Student::getName).collect(Collectors.toList());

		names.forEach(name -> System.out.print(" | " + name));

		/*****************************************************
		 * Convert List<students> to String
		 *****************************************************/
		System.out.println();

		String stringNames = students.stream().map(Student::getName).collect(Collectors.joining("|divider|", "[", "]"));

		System.out.println(stringNames);

		/*****************************************************
		 * Change the case of List<String>
		 *****************************************************/
		System.out.println();

		List<String> nameList = Arrays.asList("Jayesh", "Dany", "Khyati", "Hello", "Mango");

		nameList.stream().map(String::toUpperCase).forEach(System.out::println);

		/*****************************************************
		 * Sort List<String>
		 *****************************************************/

		System.out.println("------------------");

		nameList.stream().sorted().forEach(System.out::println);

		System.out.println("------------------");

		/*****************************************************
		 * Conditionally apply Filter condition, say if flag is enabled then
		 *****************************************************/

		System.out.println("*************************");

		boolean sortConditionFlag = true;

		Stream<Student> conditionalFilterResult = students.stream().filter(std -> std.getName().startsWith("J"));

		if (sortConditionFlag) {
			conditionalFilterResult = conditionalFilterResult.sorted(Comparator.comparing(Student::getName));
		}

		System.out.println("Before sorting :");
		students.forEach(s -> System.out.println(s.getName()));

		List<Student> list = conditionalFilterResult.collect(Collectors.toList());
		System.out.println("After filter and conditional sorting :");
		list.forEach(s -> System.out.println(s.getName()));

		System.out.println("**************************\n*******************");

		List<Integer> lists = new ArrayList<>();

		lists.add(1);
		lists.add(3);
		lists.add(10);
		lists.add(13);
		lists.add(12);
		lists.add(5);
		lists.add(19);

		System.out.println(lists.stream().mapToInt(i -> i).sum());

		System.out.println("Value: " + (1 << 30));

		Map<Boolean, List<Integer>> map = lists.stream().collect(Collectors.partitioningBy(i -> i % 2 == 0));

		map.forEach((key, value) -> {
			System.out.println("||||||||||||||||||||||||||||||||");
			value.forEach(v -> System.out.print(" " + v));
			System.out.println("||||||||||||||||||||||||||||||||");
		});

		// long count = lists.stream().collect(Collectors.counting());
		long count = lists.stream().count();
		System.out.println("Count : " + count);

		List<String> items = Arrays.asList("apple", "apple", "banana", "apple", "orange", "banana", "papaya");

		// count the no of string appearance:

		Map<String, Long> res = items.stream()
				.collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));
		res.forEach((s, n) -> System.out.println(s + " -> " + n));

		List<Trainee> trainees = Arrays.asList(new Trainee("Math", "John", "Smith", "Miami", 19),
				new Trainee("Programming", "Mike", "Miles", "New York", 21),
				new Trainee("Math", "Michael", "Peterson", "New York", 20),
				new Trainee("Math", "James", "Robertson", "Miami", 20),
				new Trainee("Programming", "Kyle", "Miller", "Miami", 20));

		// Groups Trainee by the subjects
		// write a Function<Trainee, String>, String is for subject: trainee ->
		// trainee.getSubject()
		Map<String, List<Trainee>> mapTraineesForSubject = trainees.stream()
				.collect(Collectors.groupingBy(trainee -> trainee.getSubject()));
		System.out.println("**********************");
		mapTraineesForSubject.forEach((sub, ts) -> {
			System.out.println(sub + ":");
			ts.forEach(s -> System.out.print(s.getName() + ", "));
			System.out.println("\n-------------------");
		});

		// group the trainees by the city they're from
		System.out.println("**********************");

		Map<String, List<String>> mapTraineesFromCity = trainees.stream()
				.collect(Collectors.groupingBy(Trainee::getCity, 
						Collectors.mapping(Trainee::getName, Collectors.toList())));
		mapTraineesFromCity.forEach((city, ts) -> {
			System.out.println(city + ":");
			ts.forEach(s -> System.out.print(s + ", "));
			System.out.println("\n-------------------");
		});
		
		System.out.println("**********************");
		String names1 = trainees.stream().map(Trainee::getName).collect(Collectors.joining());
		System.out.println("::: "+names1);
		
		System.out.println("**********************");
		names1 = trainees.stream().map(Trainee::getName).collect(Collectors.joining(" "));
		System.out.println("::: "+names1);
		
		System.out.println("**********************");
		names1 = trainees.stream().map(Trainee::getName).collect(Collectors.joining(", ", "[", "]"));
		System.out.println("::: "+names1);
	}

}

class Trainee {
	private String subject;
	private String name;
	private String surname;
	private String city;
	private int age;

	public Trainee(String subject, String name, String surname, String city, int age) {

		this.subject = subject;
		this.name = name;
		this.surname = surname;
		this.city = city;
		this.age = age;
	}

	public String getSubject() {
		return subject;
	}

	public void setSubject(String subject) {
		this.subject = subject;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getSurname() {
		return surname;
	}

	public void setSurname(String surname) {
		this.surname = surname;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	// Constructors, Getters, Setters, toString()
}
