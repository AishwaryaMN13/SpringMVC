package demo.service.intf;

import java.util.List;

import demo.model.MainEmp;

public interface  MainEmpInterface {
	public String addnewemp(MainEmp e);
	public List<MainEmp> displayall();
	public List<MainEmp> displayspecific(MainEmp e);
	public String updateemp(MainEmp e);
	public String deleteemp(MainEmp e);
}
