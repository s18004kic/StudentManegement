package raisetech.Student.Management;

import java.util.HashMap;
import java.util.Map;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@RestController
public class Application {
	private Map<String, String> students = new HashMap<>();

	public Application(){
		students.put("20","kin momotarou");
		students.put("21","akai tarou");
		students.put("22","midoriya jirou");
	}

	public static void main(String[] args){
		SpringApplication.run(Application.class, args);
	}

	@GetMapping("/students")
	public Map<String,String>getStudents(){
		return students;
	}

	@PostMapping("/students")
	public String addStudent(@RequestParam String age, @RequestParam String name){
		students.put(age, name);
		return "Students added successfully!";
	}
}
//
//	private String name = "aviva kyousitu";
//  private String age = "30";
//
//	private Map<String , String > student;
//	public static void main(String[] args) {
//		SpringApplication.run(Application.class, args);
//	}
//
//	@GetMapping("/StudentInfo")
//		public String getStudentInfo(){
//			return name + " " + age + "歳";
//		}
//
//	@GetMapping("/age")
//	public String getAge() {
//		return age;
//	}
//		@PostMapping("/StudentInfo")
//		public void setStudentInfo(String name, String age){
//			 this.name = name;
//			 this.age = age;
//		}
//		@PostMapping("/studentname")
//	  public void updateStudentName(String name){
//			this.name = name;
//		}
//	}
//@GetMapping("/hello")
//public String hello() {
//return "Hello,World";