package org.openmrs.module.ddisemmeddb.api.jdbc;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.openmrs.module.ddisemmeddb.DDISemMedDB;
import org.openmrs.module.ddisemmeddb.api.db.DDISemMedDBDAO;
import org.springframework.jdbc.core.support.JdbcDaoSupport;

public class JdbcDDISemMedDBDAO extends JdbcDaoSupport implements DDISemMedDBDAO {
	public List<DDISemMedDB> check() {
		List<DDISemMedDB> results = new ArrayList<DDISemMedDB>();
		String sql = "SELECT s_name FROM predication_aggregate LIMIT 10";
		
		List<Map<String, Object>> rows = getJdbcTemplate().queryForList(sql);
		for(Map<String, Object> row : rows) {
			DDISemMedDB object = new DDISemMedDB();
			object.setS_name((String) row.get("s_name"));
			results.add(object);
		}
		
		return results;
	}
}
