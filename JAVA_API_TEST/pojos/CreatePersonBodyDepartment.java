package de.usu.test.web.suite.testcase.interfaces.pojos;

/**
 * Class for instantiate plain Java object for Gson serialization.
 * @author uzimmiksov
 *
 */
public class CreatePersonBodyDepartment {
	private String departmentNo = ""; 
	
	/**
	 * Constructor for CreatePersonBodyDepartment POJO as a part of CreatePerson request body
	 * @param departmentNo JSON parameter
	 */
	public CreatePersonBodyDepartment(String departmentNo) {
		this.departmentNo = departmentNo.isEmpty() ? PERSON_BODY.DEPARTMENT_NO.departmentNo : departmentNo;
	}
	
	/**
	 * Constructor for CreatePersonBodyDepartment POJO as a pert of CreatePerson request body
	 */
	public CreatePersonBodyDepartment() {
		this.departmentNo = PERSON_BODY.DEPARTMENT_NO.departmentNo;
	}
}
