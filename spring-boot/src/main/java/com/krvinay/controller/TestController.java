/**
 * This is demo of almost all HTTP(GET,POST,PUT,DELETE) methods using static list
 * In Rest Api we spring does not provide any opertons on "Head" and "Options" http methods
 */

package com.krvinay.controller;

import java.util.List;
import java.util.ArrayList;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.krvinay.controller.bean.Student;

@RestController
@RequestMapping("/democontroller")
public class TestController {
	
	//localhost:8080/democontroller/test	
	@GetMapping("/test")
	@ResponseStatus(HttpStatus.OK)
	public String test() {
		return "Hi!! This is test controller....";
	}
	
	//localhost:8080/democontroller/getStudent
	@GetMapping("/getStudent")
	public ResponseEntity<Student> getStudent() {		
		Student list=new Student(1,"ravi","101");	
			
		//return new ResponseEntity<Student>(list, HttpStatus.OK);
		
		//Setting headers in the response headers
		return  ResponseEntity.ok().header("custom-header", "vinay").body(list);
	}
	
	//localhost:8080/democontroller/getStudents
	@GetMapping("/getStudents")
	public ResponseEntity<List<Student>> getStudents() {		
		List<Student> list=new ArrayList<>();		
		list.add(new Student(1,"kr","11"));
		list.add(new Student(1,"victor","12"));
		list.add(new Student(1,"raju","13"));		
		return  ResponseEntity.ok().header("custom-header", "vinay").body(list);
	}
	
	//localhost:8080/democontroller/student/create
	@PostMapping("/student/create")
	public ResponseEntity<Student> createStudent(@RequestBody Student student) {		
		Student list=new Student(student.getId(),student.getName(),student.getRollno());			
		return  new ResponseEntity<Student>(list,HttpStatus.CREATED);
	}
	
	//localhost:8080/democontroller/student/creates
	@PostMapping("/student/creates")
	public ResponseEntity<List<Student>> createStudents(@RequestBody List<Student> student) {			
		List<Student> li=new ArrayList<Student>();			
		for(Student s:student) {
			li.add(new Student(s.getId(),s.getName(),s.getRollno()));
		}
		return  new ResponseEntity<List<Student>>(li,HttpStatus.CREATED);
	}
	/**
	 * Demo of @PathVaribale and @DeleteMapping to delete element in a list
	 */
	//localhost:8080/democontroller/student/delete
	@DeleteMapping("/student/delete/{id}")//pathvariable
	public ResponseEntity<List<Student>> deleteStudent(@PathVariable String id) {			
		
		List<Student> list=new ArrayList<Student>();			
		list.add(new Student(1,"kr","11"));
		list.add(new Student(2,"victor","12"));
		list.add(new Student(3,"raju","13"));
		
		list.remove(Integer.parseInt(id));
		System.out.println(list +""+id);
		return new ResponseEntity<List<Student>>(list, HttpStatus.OK);
	}
	/**
	 * Demo of @RequestParam and @PutMapping to update element in a list
	 */
	//localhost:8080/democontroller/student/update?id=1&name=kr
	@PutMapping("/student/update")//RequestParam
	public ResponseEntity<List<Student>> updateStudent(@RequestParam String id, 
			 										   @RequestParam String name) 
	{			
		System.out.println(id +""+name);
		List<Student> list=new ArrayList<Student>();			
		list.add(new Student(1,"kr","11"));
		list.add(new Student(2,"victor","12"));
		list.add(new Student(3,"raju","13"));		
		if(list.contains(name)) {
			list.set(Integer.parseInt(id), new Student(1,"vinay","11"));
		}	
		return new ResponseEntity<List<Student>>(list, HttpStatus.OK);
	}
	
	//localhost:8080/democontroller/patch	
	@PatchMapping("/patch")
	public String patch() {
		return "Hi!! This is test controller for @PatchMapping....";
	}	
}
