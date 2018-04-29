package ua.training.repairagency.model.dao.interfaces;

public abstract class DAOFactory {
	
	private static DAOFactory daoFactory;
	
	public static DAOFactory getInstance() {
		if (daoFactory == null) {
			synchronized (DAOFactory.class) {
				if (daoFactory == null) {
//					DAOFactory temp = new JDBCDAOFactory();
//					daoFactory = temp;
				}
				
			}
		}
		return daoFactory;
	}
	
	public abstract UserDAO createUserDAO();
//	
//	public abstract AbstractDAO<Driver> createDriverDAO();
//	
//	public abstract CarDriverDAO createCarDriverDAO();

}
