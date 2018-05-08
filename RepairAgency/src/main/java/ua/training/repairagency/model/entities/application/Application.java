package ua.training.repairagency.model.entities.application;

import java.math.BigDecimal;
import java.util.Date;

import ua.training.repairagency.model.entities.Entity;
import ua.training.repairagency.model.entities.testimonial.Testimonial;
import ua.training.repairagency.model.entities.user.User;

public interface Application extends Entity {
	
	AppStatus getStatus();
	
	void setStatus(AppStatus status);
	
	String getDescription();
	
	void setDescription(String description);
	
	String getManagerComment();
	
	void setManagerComment(String managerComment);
	
	BigDecimal getPrice();
	
	void setPrice(BigDecimal price);
	
	User getCustomer();
	
	void setCustomer(User customer);
	
	User getWorkman();
	
	void setWorkman(User workman);
	
	Testimonial getTestimonial();
	
	void setTestimonial(Testimonial testimonial);
	
	Date getCreatTime();
	
	public void setCreatTime(Date createTime);	

}
