package ua.training.repairagency.model.entities.testimonial;

import java.time.LocalDateTime;

import ua.training.repairagency.model.entities.AbstractEntity;

public class TestimonialImpl extends AbstractEntity implements Testimonial {
	
	private String text;
	private LocalDateTime createTime;
	
	public String getText() {
		return text;
	}
	
	public void setText(String text) {
		this.text = text;
	}
	
	public LocalDateTime getCreateTime() {
		return createTime;
	}

	@Override
	public void setCreateTime(LocalDateTime createTime) {
		this.createTime = createTime;
		
	}

}
