package de.usu.test.web.suite.testcase.interfaces.pojos;

/**
 * Class for instantiate plain Java object for Gson serialization.
 * @author uzimmiksov
 *
 */
public class CreateTicketBody {
	
	private String personIdReqBy 	=	TICKET_BODY.personIdReqBy;
	private String personIdAffected = 	TICKET_BODY.personIdAffected;
	private String statementtypeId 	= 	TICKET_BODY.statementtypeId;
	private String ticketclassId 	= 	TICKET_BODY.ticketclassId;
	private String tickettypeId 	= 	TICKET_BODY.tickettypeId;
	private String catParentId 		= 	TICKET_BODY.catParentId;
	private String categoryId 		= 	TICKET_BODY.categoryId;
	private String systemId 		= 	TICKET_BODY.systemId;
	private String servicesId 		= 	TICKET_BODY.servicesId;
	private Object attachments 		= 	TICKET_BODY.attachments;
	private String description 		= 	TICKET_BODY.description;
	private String tckShorttext 	= 	TICKET_BODY.tckShorttext;
	private String status 			= 	TICKET_BODY.status;
	
	/**
	 * Getting personIdReqBy from CreateTicketBody POJO
	 * <i><b>Default value: </b> "Person-13034#" </i>
	 * @return String personIdReqBy 
	 */
	public String getPresonIdReqBy() {
		return personIdReqBy;
	}
	
	/**
	 * Setting "personIdReqBy" in CreateTicketBody JSON body
	 * <i><b>Default value: </b> "Person-13034#" </i> 
	 * @param personIdReqBy
	 */
	public void setPersonIdReqBy(String personIdReqBy) {
		this.personIdReqBy = personIdReqBy;
	}
	
	/**
	 * Getting "personIdAffected" from CreateTicketBody POJO
	 * <i><b>Default value: </b> "Person-13034#" </i> 
	 * @return String personIdAffected value
	 */
	public String getPersonIdAffected() {
		return personIdAffected;
	}
	
	/**
	 * Setting "personIdAffected" in CreateTicketBody JSON body 
	 * <i><b>Default value: </b> "Person-13034#" </i> 
	 * @param personIdAffected
	 */
	public void setPersonIdAffected(String personIdAffected) {
		this.personIdAffected = personIdAffected;
	}
	
	/**
	 * Returns statementtypeId attribute set in CreateTicketBody POJO
	 * <i><b>Default value: </b> "Statementtype-102#" </i> 
	 * @return String statementtypeId 
	 */
	public String getStatementtypeId() {
		return statementtypeId;
	}
	
	/**
	 * Setting "statementtypeId" in CreateTicketBody JSON body 
	 * <i><b>Default value: </b> "Statementtype-102#" </i> 
	 * @param statementtypeId
	 */
	public void setStatementtypeId(String statementtypeId) {
		this.statementtypeId = statementtypeId;
	}
	
	/**
	 * Returns ticketclassId attribute set in CreateTicketBody POJO
	 * <i><b>Default value: </b> "Ticketclass-200215#" </i> 
	 * @return String ticketclassId 
	 */
	public String getTicketclassId() {
		return ticketclassId;
	}
	
	/**
	 * Setting "ticketclassId" in CreateTicketBody JSON body 
	 * <i><b>Default value: </b> "Ticketclass-200215#" </i> 
	 * @param ticketclassId
	 */
	public void setTicketclassId(String ticketclassId) {
		this.ticketclassId = ticketclassId;
	}
	
	/**
	 * Returns tickettypeId attribute set in CreateTicketBody POJO
	 * <i><b>Default value: </b> "Tickettype-202495#" </i> 
	 * @return String tickettypeId 
	 */
	public String getTickettypeId() {
		return tickettypeId;
	}
	
	/**
	 * Setting "tickettypeId" in CreateTicketBody JSON body 
	 *  <i><b>Default value: </b> "Tickettype-202495#" </i> 
	 * @param tickettypeId
	 */
	public void setTickettypeId(String tickettypeId) {
		this.tickettypeId = tickettypeId;
	}
	
	/**
	 * Returns catParentId attribute set in CreateTicketBody POJO
	 * <i><b>Default value: </b> "Category-245#" </i>  
	 * @return String catParentId 
	 */
	public String getCatParentId() {
		return catParentId;
	}
	
	/**
	 * Setting "catParentId" in CreateTicketBody JSON body 
	 * <i><b>Default value: </b> "Category-245#" </i> 
	 * @param catParentId
	 */
	public void setCatParentId(String catParentId) {
		this.catParentId = catParentId;
	}
	
	/**
	 * Returns categoryId attribute set in CreateTicketBody POJO
	 * <i><b>Default value: </b> "Category-264#" </i>
	 * @return String categoryId 
	 */
	public String getCategoryId() {
		return categoryId;
	}
	
	/**
	 * Setting "categoryId" in CreateTicketBody JSON body 
	 * <i><b>Default value: </b> "Category-264#" </i>
	 * @param categoryId
	 */
	public void setCategoryId(String categoryId) {
		this.categoryId = categoryId;
	}
	
	/**
	 * Returns systemId attribute set in CreateTicketBody POJO
	 * <i><b>Default value: </b> empty String </i> 
	 * @return String systemId 
	 */
	public String getSystemId() {
		return systemId;
	}
	
	/**
	 * Setting "systemId" in CreateTicketBody JSON body
	 * <i><b>Default value: </b> empty String </i> 
	 * @param systemId
	 */
	public void setSystemId(String systemId) {
		this.systemId = systemId;
	}
	
	/**
	 * Returns servicesId attribute set in CreateTicketBody POJO
	 * <i><b>Default value: </b> empty String </i> 
	 * @return String servicesId 
	 */
	public String getServicesId() {
		return servicesId;
	}
	
	/**
	 * Setting "servicesId" in CreateTicketBody JSON body
	 * <i><b>Default value: </b> empty String </i>  
	 * @param servicesId
	 */
	public void setServicesId(String servicesId) {
		this.servicesId = servicesId;
	}
	
	/**
	 * Returns attachments attribute set in CreateTicketBody POJO
	 * <i><b>Default value: </b> empty Object </i> 
	 * @return String attachments 
	 */
	public Object getAttachments() {
		return attachments;
	}
	
	/**
	 * Setting "attachments" as object in CreateTicketBody JSON body 
	 * <i><b>Default value: </b> empty Object </i>
	 * @param attachments (Object)
	 */
	public void setAttachments(Object attachments) {
		this.attachments = attachments;
	}
	
	/**
	 * Returns description attribute set in CreateTicketBody POJO
	 * <i><b>Default value: </b> empty String </i>
	 * @return String description 
	 */
	public String getDescription() {
		return description;
	}
	
	/**
	 * Setting "servicesId" in CreateTicketBody JSON body 
	 * <i><b>Default value: </b> empty String </i>
	 * @param servicesId
	 */
	public void setDescription(String description) {
		this.description = description;
	}
	
	/**
	 * Setting "tckShorttext" in CreateTicketBody JSON body 
	 * <i><b>Default value: </b> "Created at: + current timestamp" </i>
	 * @param tckShorttext
	 */
	public String getTckShorttext() {
		return tckShorttext;
	}
	
	/**
	 * Setting "tckShorttext" in CreateTicketBody JSON body 
	 * <i><b>Default value: </b> "Created at: + current timestamp" </i>
	 * @param tckShorttext
	 */
	public void setTckShorttext(String tckShorttext) {
		this.tckShorttext = tckShorttext;
	}
	
	/**
	 * Setting "status" in CreateTicketBody JSON body 
	 * <i><b>Default value: </b> "IN_CRE" </i>
	 * @param status
	 */
	public String getStatus() {
		return status;
	}
	
	/**
	 * Setting "status" in CreateTicketBody JSON body 
	 * <i><b>Default value: </b> "IN_CRE" </i>
	 * @param status
	 */
	public void setStatus(String status) {
		this.status = status;
	}
}


