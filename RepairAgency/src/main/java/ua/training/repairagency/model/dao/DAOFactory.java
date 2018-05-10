package ua.training.repairagency.model.dao;

import ua.training.repairagency.model.dao.interfaces.ApplicationDAO;
import ua.training.repairagency.model.dao.interfaces.HistoryRecordDAO;
import ua.training.repairagency.model.dao.interfaces.TestimonialDAO;
import ua.training.repairagency.model.dao.interfaces.UserDAO;

public abstract class DAOFactory {
	
	private static DAOFactory daoFactory;
	
	public static DAOFactory getInstance() {
		if (daoFactory == null) {
			synchronized (DAOFactory.class) {
				if (daoFactory == null) {
					DAOFactory temp = new JDBCDAOFactory();
					daoFactory = temp;
				}				
			}
		}
		return daoFactory;
	}
	
	public abstract UserDAO createUserDAO();
	public abstract ApplicationDAO createApplicationDAO();
	public abstract TestimonialDAO createTestimonialDAO();
	public abstract HistoryRecordDAO createHistoryRecordDAO();

}
