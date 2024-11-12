package raisetech.Student.Management;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.Mapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@RestController
public class Application {
	//private Map<String, String> students = new HashMap<>();
//
	//public Application(){
	//	students.put("20","kin momotarou");
	//	students.put("21","akai tarou");
	//	students.put("22","midoriya jirou");
	//}

	@Autowired
	private StudentRepository repository;

	//private String name = "aviva kyousitu";
  //private String age = "30";

	//private Map<String , String > student;
	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
	}

	@GetMapping("/StudentInfo")
	public String getStudent(@RequestParam String name){
		Student student = repository.searchByName(name);
		return student.getName() + " " + student.getAge() + "歳";
	}

	// 学生の一覧を取得するエンドポイント
	@GetMapping("/dataList")
	public List<Student> getAllStudents() {
		return repository.findAll();  // 全学生データを返す
	}

	//@GetMapping("/age")
	//public String getAge() {
	//	return age;
	//}
		@PostMapping("/student")
		public void registerStudent(String name, String age){
			 repository.registerStudent(name, age);
		}
		@PatchMapping("/student")
	  public void updateStudent(String name, String age){
			repository.updateStudent(name, age);
		}

		@DeleteMapping("/student")
		public void deleteStudent(String name){
			repository.deleteStudent(name);
		}
	}
	//private Map<String, String> students = new HashMap<>();

//public Application(){
//	students.put("20","kin momotarou");
//	students.put("21","akai tarou");
//	students.put("22","midoriya jirou");
//}

//public static void main(String[] args){
//	SpringApplication.run(Application.class, args);
//}

//@GetMapping("/students")
//public Map<String,String>getStudents(){
//	return students;
//}

//@PostMapping("/students")
//public String addStudent(@RequestParam String age, @RequestParam String name){
//	students.put(age, name);
//	return "Students added successfully!";
//}
//
//

//@GetMapping("/hello")
//public String hello() {
//return "Hello,World";