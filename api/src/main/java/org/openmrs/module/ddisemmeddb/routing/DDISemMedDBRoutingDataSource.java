package org.openmrs.module.ddisemmeddb.routing;

import org.springframework.jdbc.datasource.lookup.AbstractRoutingDataSource;

public class DDISemMedDBRoutingDataSource extends AbstractRoutingDataSource {

	@Override
	protected Object determineCurrentLookupKey() {
		return null;
	}

}
