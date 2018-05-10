package ua.training.repairagency.model.entities.testimonial;

import java.util.Date;

import ua.training.repairagency.model.entities.Entity;

public interface Testimonial extends Entity {

	public String getText();
	
	public void setText(String text);
	
	public Date getCreateTime();

	public void setCreateTime(Date date);

}
