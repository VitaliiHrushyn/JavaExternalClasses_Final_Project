package ua.training.repairagency.model.entities.testimonial;

import java.time.LocalDateTime;

import ua.training.repairagency.model.entities.Entity;

public interface Testimonial extends Entity {

	public String getText();
	
	public void setText(String text);
	
	public LocalDateTime getCreateTime();

	public void setCreateTime(LocalDateTime dateTime);

}
