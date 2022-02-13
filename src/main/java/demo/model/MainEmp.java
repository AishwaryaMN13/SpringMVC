package demo.model;

import java.util.Objects;


public class MainEmp {
	private int id;
	private String name;
	private String phone;
	private String email;
	private String worklocation;
	private String position;
	public MainEmp() {
		super();
		// TODO Auto-generated constructor stub
	}
	public MainEmp(int id, String name, String phone, String email, String worklocation, String position) {
		super();
		this.id = id;
		this.name = name;
		this.phone = phone;
		this.email = email;
		this.worklocation = worklocation;
		this.position = position;
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
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getWorklocation() {
		return worklocation;
	}
	public void setWorklocation(String worklocation) {
		this.worklocation = worklocation;
	}
	public String getPosition() {
		return position;
	}
	public void setPosition(String position) {
		this.position = position;
	}
	@Override
	public int hashCode() {
		return Objects.hash(id);
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		MainEmp other = (MainEmp) obj;
		return id == other.id;
	}
}
