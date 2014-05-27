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
package org.openmrs.module.ddisemmeddb.web.controller;

import java.util.ArrayList;
import java.util.List;

import org.apache.commons.lang.StringUtils;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.openmrs.Patient;
import org.openmrs.api.context.Context;
import org.openmrs.api.PatientService;
import org.openmrs.module.ddisemmeddb.DDISemMedDB;
import org.openmrs.module.ddisemmeddb.api.DDISemMedDBService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * The main controller.
 * TODO: Not Secure
 */
@Controller
@RequestMapping("/module/ddisemmeddb")
public class  DDISemMedDBManageController {
	
	protected final Log log = LogFactory.getLog(getClass());
	private static String messageControl = "";
	private static List<DDISemMedDB> resultsStatic = new ArrayList<DDISemMedDB>();
	private static List<String> drugList = new ArrayList<String>();
	private static Integer patientId;
//	@Autowired
//	private JdbcDDISemMedDBDAO ddiSemMedDBDAO;
	
	@RequestMapping(value = "/manage", method = RequestMethod.GET)
	public void manage(ModelMap model) {
		model.addAttribute("user", Context.getAuthenticatedUser());
	}
	
	@RequestMapping(value = "/index", method = RequestMethod.GET)
	public void index(ModelMap model) {
		PatientService patientService = (PatientService) Context.getService(PatientService.class);
		List<Patient> patients = patientService.getAllPatients();
		model.addAttribute("patients", patients);
	}
	
	@ModelAttribute("add")
	@RequestMapping(value = "/add", method = RequestMethod.GET)
	public void add(@RequestParam(value = "patientId") Integer patientId, ModelMap model) {
//		model.addAttribute("user", Context.getAuthenticatedUser());
//		System.out.println("[CTR-DDI] Patient ID selected " + patientId);
		DDISemMedDBManageController.patientId = patientId;
		PatientService patientService = (PatientService) Context.getService(PatientService.class);
		Patient patient = patientService.getPatient(patientId);
//		model.addAttribute("patientId", patientId);
		model.addAttribute("patient", patient);
	}
	
//	@RequestMapping(value = "/add", method = RequestMethod.GET)
//	public String add(ModelMap model) {
//		model.addAttribute("user", Context.getAuthenticatedUser());
//		System.out.println("[CTR-DDI] No patient Id! ");
//		return "redirect:index.form";
//	}
	
	@RequestMapping(value = "/check", method = RequestMethod.POST)
	public String check(@RequestParam(value = "drug1", required = true) String drug1, 
			@RequestParam(value = "drug2", required = false) String drug2,
			@RequestParam(value = "drug3", required = false) String drug3,
			@RequestParam(value = "drug4", required = false) String drug4,
			@RequestParam(value = "drug5", required = false) String drug5,
			@RequestParam(value = "drug6", required = false) String drug6,
//			@RequestParam(value = "patientId", required = true) Integer patientId,
			ModelMap model) {
//		System.out.println("[CTR-DDI] Drug 1 = " + drug1);
//		System.out.println("[CTR-DDI] Drug 2 = " + drug2);
//		System.out.println("[CTR-DDI] Patient ID " + patientId);
		
		if (StringUtils.isEmpty(drug1) && StringUtils.isEmpty(drug2) && StringUtils.isEmpty(drug3)
				&& StringUtils.isEmpty(drug4) && StringUtils.isEmpty(drug5) && StringUtils.isEmpty(drug6)) {
			return "redirect:add.form?patientId=4";
		}
		
		// add drugs
		drugList = new ArrayList<String>();
		drugList.add(drug1);
		drugList.add(drug2);
		drugList.add(drug3);
		drugList.add(drug4);
		drugList.add(drug5);
		drugList.add(drug6);
		
		List<DDISemMedDB> results = new ArrayList<DDISemMedDB>();
		System.out.println("[INFO] Here in CHECK method!");
		results = (List<DDISemMedDB>) Context.getService(DDISemMedDBService.class).check(drugList);

		log.info(results.size());
		System.out.println("[INFO] Result set size " + results.size());
		
		if (results.size() != 0) {
//			ModelAndView mv = new ModelAndView("checkResult");
//			mv.addObject("message", "Potential DDIs found! Please check results.");
//			mv.addObject("results", results);
//			return mv;
//			model.addAttribute("results", results);
//			model.addAttribute("message", "Potential DDIs found! Please check results.");
//			System.out.println("[INFO] Will be redirected to checkResult!");
			messageControl = "Potential DDIs found! Please check results.";
			resultsStatic = results;
			return "redirect:checkResult.form";
//			checkResult(model);
		} else {
//			ModelAndView mv = new ModelAndView("redirect:index.form");
//			mv.addObject("message", "Success! No potential DDIs found.");
//			return mv;
//			model.addAttribute("message", "Success! No potential DDIs found.");
//			model.addAttribute("results", results);
			messageControl = "Success! No potential DDIs found.";
			resultsStatic = results;
			// TODO: Should save PatientMedication relation
			return "redirect:checkResult.form";
//			checkResult(model);
		}
		
		
//		if (StringUtils.isEmpty(drug1) && StringUtils.isEmpty(drug2)) {
//			return "index.form";
//		}
//		else {
//			return "redirect:index.form";
//		}
	}
	
//	@ModelAttribute("checkResult")
	@RequestMapping(value = "/checkResult", method = RequestMethod.GET)
	public void checkResult(ModelMap model) {
		model.addAttribute("results", resultsStatic);
		model.addAttribute("message", messageControl);
		model.addAttribute("drugList", drugList);
		model.addAttribute("patientId", patientId);
	}
	
//	@RequestMapping(value = "module/ddisemmeddb/list", method = RequestMethod.GET)
//	public void list() {
//		
//	}
}
