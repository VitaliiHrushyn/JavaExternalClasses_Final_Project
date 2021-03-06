package ua.training.repairagency.model.entities.application;

import java.math.BigDecimal;
import java.sql.Timestamp;
import java.time.LocalDateTime;

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
	private LocalDateTime createTime;
	private Timestamp lastUpdateTime;
	private int versionId;
	
	public AppStatus getStatus() {
		return status;
	}

	public void setStatus(AppStatus status) {
		this.status = status;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getManagerComment() {
		return managerComment;
	}

	public void setManagerComment(String managerComment) {
		this.managerComment = managerComment;
	}

	public BigDecimal getPrice() {
		return price;
	}

	public void setPrice(BigDecimal price) {
		this.price = price;
	}

	public User getCustomer() {
		return customer;
	}

	public void setCustomer(User customer) {
		this.customer = customer;
	}

	public User getWorkman() {
		return workman;
	}

	public void setWorkman(User workman) {
		this.workman = workman;
	}

	public Testimonial getTestimonial() {
		return testimonial;
	}

	public void setTestimonial(Testimonial testimonial) {
		this.testimonial = testimonial;
	}

	public LocalDateTime getCreateTime() {
		return createTime;
	}
	
	public void setCreateTime(LocalDateTime createTime) {
		this.createTime = createTime;
	}
	
	public Timestamp getLastUpdateTime() {
		return lastUpdateTime;
	}

	public void setLastUpdateTime(Timestamp lastUpdateTime) {
		this.lastUpdateTime = lastUpdateTime;		
	}

	public int getVersionId() {
		return versionId;
	}

	public void setVersionId(int versionId) {
		this.versionId = versionId;
	}

	@Override
	public String toString() {
		return "ApplicationImpl [status=" + status + ", description=" + description + ", managerComment="
				+ managerComment + ", price=" + price + ", workman=" + workman
				+ ", testimonial=" + testimonial + ", creatTime=" + createTime + "]";
	}
	
}
