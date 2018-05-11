package ua.training.repairagency.model.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import ua.training.repairagency.model.constants.Query;
import ua.training.repairagency.model.dao.interfaces.HistoryRecordDAO;
import ua.training.repairagency.model.entities.historyrecord.HistoryRecord;

public class HistoryRecordDAOImpl extends AbstractDAO<HistoryRecord> implements HistoryRecordDAO {

	public HistoryRecordDAOImpl(Connection connection) {
		super(connection);
	}

	@Override
	public HistoryRecord create(HistoryRecord entity) throws SQLException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public HistoryRecord update(HistoryRecord entity) throws SQLException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public HistoryRecord getById(int id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<HistoryRecord> getAll() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public HistoryRecord delete(HistoryRecord entity) {
		// TODO Auto-generated method stub
		return null;
	}

//	@Override
//	public String getCreateQuery() {
//		return queryBundle.getString(Query.RECORD_INSERT);
//	}
//
//	@Override
//	public void fillCreateStatement(PreparedStatement statement, HistoryRecord entity) throws SQLException {
//		// TODO Auto-generated method stub
//		
//	}
//
//	@Override
//	public String getUpdateQuery() {
//		throw new UnsupportedOperationException();
//	}
//
//	@Override
//	public void fillUpdateStatement(PreparedStatement statement, HistoryRecord entity) throws SQLException {
//		throw new UnsupportedOperationException();
//	}
//
//	@Override
//	public String getByIDQuery() {
//		return queryBundle.getString(Query.RECORD_GET_BY_ID);
//	}
//
//	@Override
//	public String getDeleteQuery() {
//		throw new UnsupportedOperationException();
//	}
//
//	@Override
//	public String getAllQuery() {
//		return queryBundle.getString(Query.RECORD_GET_ALL);
//	}
//
//	@Override
//	String getByParamQuery(String name) {
//		return null;
//	}
//
//	@Override
//	public HistoryRecord extractEntity(ResultSet rs, boolean eager) throws SQLException {
//		// TODO Auto-generated method stub
//		return null;
//	}

	
}
