package org.openmrs.module.ddisemmeddb.api.jdbc;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.apache.commons.lang.StringUtils;
import org.openmrs.module.ddisemmeddb.DDISemMedDB;
import org.openmrs.module.ddisemmeddb.api.db.DDISemMedDBDAO;
import org.springframework.jdbc.core.support.JdbcDaoSupport;

/**
 * Query for DGD Schema:
 * 
 * 
 * @author iwawiwi
 *
 */
public class JdbcDDISemMedDBDAO extends JdbcDaoSupport implements DDISemMedDBDAO {
	private static String PUBMED_BASE_URL = "http://www.ncbi.nlm.nih.gov/pubmed/";
	
	public List<DDISemMedDB> check(List<String> drugs) {
		List<DDISemMedDB> results = new ArrayList<DDISemMedDB>();
		
		// construct drug list to check
		String drugListQuery = constructDrugListQuery(drugs);
		
		// DGD Schema
		String sql = "select distinct pagg.s_name as d1, pagg.predicate as p1, pagg.o_name as g, pagg2.predicate as p2, pagg2.o_name as d2 "
				+ "from predication_aggregate pagg "
				+ "inner join predication_aggregate pagg2 on pagg.s_type = 'phsu' and pagg2.o_type = 'phsu' "
				+ "and pagg.o_name = pagg2.s_name and pagg.o_type in ('gngm', 'aapp') "
				+ "and lower(pagg.s_name) in (" + drugListQuery + ") "
				+ "and pagg.o_name = pagg2.s_name and pagg.s_name <> pagg2.o_name "
				+ "and lower(pagg2.o_name) in (" + drugListQuery + ") "
				+ "and pagg2.predicate in ('INHIBITS', 'INTERACTS_WITH', 'STIMULATES') "
				+ "and pagg.predicate in ('INHIBITS', 'INTERACTS_WITH', 'STIMULATES')";
		System.out.println("[JDBC-DAO] SQL = " + sql);
		
		List<Map<String, Object>> rows = getJdbcTemplate().queryForList(sql);
		for(Map<String, Object> row : rows) {
			DDISemMedDB object = new DDISemMedDB();
			object.setDrug1((String) row.get("d1"));
			object.setDrug2((String) row.get("d2"));
			object.setPredicate1((String) row.get("p1"));
			object.setPredicate2((String) row.get("p2"));
			object.setGeneName((String) row.get("g"));
			object.setUrlCheck(constructUrlCheck(object.getDrug1(), object.getGeneName(), object.getDrug2()));
			results.add(object);
		}
		
		return results;
	}
	
	public List<DDISemMedDB> checkDGFGD(List<String> drugs) {
		List<DDISemMedDB> results = new ArrayList<DDISemMedDB>();
		
		return results;
	}
	
	private String constructUrlCheck(String drug1, String gene, String drug2) {
		String query = String.format("?term=(%s+AND+%s)+OR+(%s+AND+%s)", drug1, gene, gene, drug2);
		return PUBMED_BASE_URL+query;
	}
	
	private String constructDrugListQuery(List<String> drugs) {
		List<String> listString = new ArrayList<String>();
		for (String obj : drugs) {
			// contain string
			if (!StringUtils.isEmpty(obj)) {
				listString.add(String.format("lower('%s')", obj));
			}
		}
		return StringUtils.join(listString, ",");
	}
}
