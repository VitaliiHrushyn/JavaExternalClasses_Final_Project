package ua.training.repairagency.model.entities.testimonial;

import java.util.Date;

import ua.training.repairagency.model.entities.AbstractEntity;

public class TestimonialImpl extends AbstractEntity implements Testimonial {
	
	private String text;
	private Date createTime;
	
	public String getText() {
		return text;
	}
	
	public void setText(String text) {
		this.text = text;
	}
	
	public Date getCreateTime() {
		return createTime;
	}

	@Override
	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
		
	}

}
