package de.usu.test.web.suite.testcase.interfaces.pojos;

/**
 * Class for instantiate plain Java object for Gson serialization.
 * @author uzimmiksov
 *
 */
public class CreatePersonBodySystems {
	private String name;
	
	/**
	 * 
	 * @param name
	 */
	public CreatePersonBodySystems(String name) {
		this.name = name == null ? PERSON_BODY.SYSTEMS.get(0).name : name;
	}
	
	public CreatePersonBodySystems() {
		this.name = PERSON_BODY.SYSTEMS.get(0).name;
	}
}
