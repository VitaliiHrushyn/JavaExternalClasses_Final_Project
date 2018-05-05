package ua.training.repairagency.model.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import ua.training.repairagency.model.dao.interfaces.HistoryRecordDAO;
import ua.training.repairagency.model.entities.historyrecord.HistoryRecord;

public class HistoryRecordDAOImpl extends AbstractDAO<HistoryRecord> implements HistoryRecordDAO {

	public HistoryRecordDAOImpl(Connection connection) {
		super(connection);
	}

	@Override
	public String getCreateQuery() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void fillCreateStatement(PreparedStatement statement, HistoryRecord entity) throws SQLException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public String getUpdateQuery() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void fillUpdateStatement(PreparedStatement statement, HistoryRecord entity) throws SQLException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public String getByIDQuery() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String getDeleteQuery() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String getAllQuery() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	String getByParamQuery(String name) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public HistoryRecord extractEntity(ResultSet rs, boolean eager) throws SQLException {
		// TODO Auto-generated method stub
		return null;
	}

	
}
