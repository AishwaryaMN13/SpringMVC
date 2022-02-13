package demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import demo.model.MainEmp;
import demo.service.intf.MainEmpInterface;


@RestController
@RequestMapping("/mainemployee")
public class MainEmpController {
	
	@Autowired
	@Qualifier(value = "main")
	MainEmpInterface mei;
	
	@PostMapping("/addnewemp") 
	public String adde(@RequestBody MainEmp me)
	{   String a=mei.addnewemp(me);
		return a;
	}
	@RequestMapping("/displayall")
	public @ResponseBody ResponseEntity<List<MainEmp>> disall()
	{
		ResponseEntity<List<MainEmp>> b=new ResponseEntity(mei.displayall(),HttpStatus.OK);
		return b;
	}
	@RequestMapping("/displayspecific")
	public List<MainEmp> dissp(@RequestBody MainEmp e)
	{
		List<MainEmp> c=mei.displayspecific(e);
		return c;
	}
	
	@RequestMapping("/delete")
	public String del(@RequestBody MainEmp e)
	{
		 String d=mei.deleteemp(e);
		return d;
	}
	
	@RequestMapping("/update")
	public String up(@RequestBody MainEmp e) {
		String f=mei.updateemp(e);
		return f;
	}
}
