package ua.training.repairagency.controller.customtag;

import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Locale;

import javax.servlet.jsp.JspException;
import javax.servlet.jsp.tagext.TagSupport;


public class DateTimeViewTag extends TagSupport {
	private static final long serialVersionUID = 1L;
	
	private LocalDateTime localDateTime;
	private String language;
	
	public void setLanguage(String language) {
			this.language = language;	
	}

	public void setLocalDateTime(LocalDateTime localDateTime) {
		this.localDateTime = localDateTime;
	}

	@Override
    public int doStartTag() throws JspException {
		
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd MMMM yyyy - HH:mm:ss", new Locale(this.language));				
		
		try {
            pageContext.getOut().print( localDateTime.format(formatter) );
        } catch(IOException ioException) {
            throw new JspException("Error: " + ioException.getMessage());
        }       
        return SKIP_BODY;
    }
}