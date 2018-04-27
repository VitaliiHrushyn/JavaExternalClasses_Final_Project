package ua.training.repairagency.model.entities.application;

import java.math.BigDecimal;
import java.util.Date;

import ua.training.repairagency.model.entities.AbstractEntity;
import ua.training.repairagency.model.entities.testimonial.Testimonial;
import ua.training.repairagency.model.entities.user.User;

public class ApplicationImpl extends AbstractEntity implements Application {

	private AppStatus status;
	private String description;
	private String managerComment;
	private BigDecimal price;
	private User customer;
	private User workman;
	private Testimonial testimonial;
	private Date creatTime;
	
	@Override
	public AppStatus getStatus() {
		return status;
	}

	@Override
	public void setStatus(AppStatus status) {
		this.status = status;
	}

	@Override
	public String getDescription() {
		return description;
	}

	@Override
	public void setDescription(String description) {
		this.description = description;
	}

	@Override
	public String getManagerComment() {
		return managerComment;
	}

	@Override
	public void setManagerComment(String managerComment) {
		this.managerComment = managerComment;
	}

	@Override
	public BigDecimal getPrice() {
		return price;
	}

	@Override
	public void setPrice(BigDecimal price) {
		this.price = price;
	}

	@Override
	public User getCustomer() {
		return customer;
	}

	@Override
	public void setCustomer(User customer) {
		this.customer = customer;
	}

	@Override
	public User getWorkman() {
		return workman;
	}

	@Override
	public void setWorkman(User workman) {
		this.workman = workman;
	}

	@Override
	public Testimonial getTestimonial() {
		return testimonial;
	}

	@Override
	public void setTestimonial(Testimonial testimonial) {
		this.testimonial = testimonial;
	}

	@Override
	public Date getCreatTime() {
		return creatTime;
	}

}
