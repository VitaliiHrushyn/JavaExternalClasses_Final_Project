package ua.training.repairagency.model.dao.services.interfaces;

import ua.training.repairagency.model.entities.historyrecord.HistoryRecord;

public interface HistoryRecordService {
	
	HistoryRecord getById(int recordId);
	
	HistoryRecord insert(HistoryRecord testimonial);

}
