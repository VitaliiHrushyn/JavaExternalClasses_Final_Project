package ua.training.repairagency.model.entities.testimonial;

import java.util.Date;

import ua.training.repairagency.model.entities.AbstractEntity;

public class TestimonialImpl extends AbstractEntity implements Testimonial {
	
	private String text;
	private Date createTime;
	
	@Override
	public String getText() {
		return text;
	}
	
	@Override
	public void setText(String text) {
		this.text = text;
	}
	
	@Override
	public Date getCreateTime() {
		return createTime;
	}

}
