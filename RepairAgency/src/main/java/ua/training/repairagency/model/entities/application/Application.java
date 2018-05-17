package ua.training.repairagency.model.entities.application;

import java.math.BigDecimal;
import java.sql.Timestamp;
import java.time.LocalDateTime;

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
	
	LocalDateTime getCreateTime();
	
	public void setCreateTime(LocalDateTime createTime);	
	
	Timestamp getLastUpdateTime();
	
	void setLastUpdateTime(Timestamp timestamp);
	
	public int getVersionId();

	public void setVersionId(int versionId);

}
