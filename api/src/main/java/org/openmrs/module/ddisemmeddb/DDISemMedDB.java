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
package org.openmrs.module.ddisemmeddb;

import java.io.Serializable;
import org.openmrs.BaseOpenmrsObject;
import org.openmrs.BaseOpenmrsMetadata;

/**
 * Attribute:
 * pagg.s_name, pagg.predicate, pagg.o_name, pagg2.predicate, pagg2.o_name, pagg.SID, pagg2.SID 
 * It is a model class. It should extend either {@link BaseOpenmrsObject} or {@link BaseOpenmrsMetadata}.
 */
public class DDISemMedDB implements Serializable {

	private static final long serialVersionUID = 1L;
	
	private String drug1;
	private String drug1Type;
	private String predicate1;
	private String geneName;
	private String geneNameType;
	private String predicate2;
	private String drug2;
	private String drug2Type;
	private String urlCheck;
	
	public String getDrug1() {
		return drug1;
	}
	public void setDrug1(String drug1) {
		this.drug1 = drug1;
	}
	public String getPredicate1() {
		return predicate1;
	}
	public void setPredicate1(String predicate1) {
		this.predicate1 = predicate1;
	}
	public String getGeneName() {
		return geneName;
	}
	public void setGeneName(String geneName) {
		this.geneName = geneName;
	}
	public String getPredicate2() {
		return predicate2;
	}
	public void setPredicate2(String predicate2) {
		this.predicate2 = predicate2;
	}
	public String getDrug2() {
		return drug2;
	}
	public void setDrug2(String drug2) {
		this.drug2 = drug2;
	}
	public String getUrlCheck() {
		return urlCheck;
	}
	public void setUrlCheck(String urlCheck) {
		this.urlCheck = urlCheck;
	}
	public String getDrug1Type() {
		return drug1Type;
	}
	public void setDrug1Type(String drug1Type) {
		this.drug1Type = drug1Type;
	}
	public String getGeneNameType() {
		return geneNameType;
	}
	public void setGeneNameType(String geneNameType) {
		this.geneNameType = geneNameType;
	}
	public String getDrug2Type() {
		return drug2Type;
	}
	public void setDrug2Type(String drug2Type) {
		this.drug2Type = drug2Type;
	}
}