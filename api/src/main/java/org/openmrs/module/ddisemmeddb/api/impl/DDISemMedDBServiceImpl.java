/**
 * The contents of this file are subject to the OpenMRS Public License
 * Version 1.0 (the "License"); you may not use this file except in
 * compliance with the License. You may obtain a copy of the License at
 * http://license.openmrs.org
 *
 * Software distributed under the License is distributed on an "AS IS"
 * basis, WITHOUT WARRANTY OF ANY KIND, either express or implied. See the
 * License for the specific language governing rights and limitations
 * under the License.
 *
 * Copyright (C) OpenMRS, LLC.  All Rights Reserved.
 */
package org.openmrs.module.ddisemmeddb.api.impl;

import org.openmrs.api.impl.BaseOpenmrsService;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.openmrs.module.ddisemmeddb.api.DDISemMedDBService;
import org.openmrs.module.ddisemmeddb.api.db.DDISemMedDBDAO;

/**
 * It is a default implementation of {@link DDISemMedDBService}.
 */
public class DDISemMedDBServiceImpl extends BaseOpenmrsService implements DDISemMedDBService {
	
	protected final Log log = LogFactory.getLog(this.getClass());
	
	private DDISemMedDBDAO dao;
	
	/**
     * @param dao the dao to set
     */
    public void setDao(DDISemMedDBDAO dao) {
	    this.dao = dao;
    }
    
    /**
     * @return the dao
     */
    public DDISemMedDBDAO getDao() {
	    return dao;
    }
}