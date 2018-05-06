package ua.training.repairagency.model.constants;

public interface Query {
	
	/* user queries */
	String USER_GET_BY_ID = "user.get.by.id";
	String USER_GET_ALL = "user.get.all";
	String USER_DELETE = "user.delete";	
	String USER_INSERT = "user.insert";
	String USER_UPDATE = "user.update";
	String USER_GET_BY_LOGIN = "user.get.by.login";
	
	/* application queries */
	String APPLICATION_GET_BY_ID = "application.get.by.id";
	String APPLICATION_GET_ALL = "application.get.all";
	String APPLICATION_DELETE = "application.delete";	
	String APPLICATION_INSERT = "application.insert";
	String APPLICATION_UPDATE = "application.update";
//	String APPLICATION_GET_BY_LOGIN = "application.get.by.login";
	
	/* history record queries */
	String RECORD_GET_BY_ID = "record.get.by.id";
	String RECORD_GET_ALL = "record.get.all";
//	String RECORD_DELETE = "record.delete";	
	String RECORD_INSERT = "record.insert";
//	String RECORD_UPDATE = "record.update";
			
	/* testimonials queries */
	String TESTIMONIAL_GET_BY_ID = "testimonial.get.by.id";
	String TESTIMONIAL_GET_ALL = "testimonial.get.all";
	String TESTIMONIAL_DELETE = "testimonial.delete";	
	String TESTIMONIAL_INSERT = "testimonial.insert";
	String TESTIMONIAL_UPDATE = "testimonial.update";
//	String TESTIMONIAL_GET_BY_LOGIN = "testimonial.get.by.login";		
	
	
	
}
