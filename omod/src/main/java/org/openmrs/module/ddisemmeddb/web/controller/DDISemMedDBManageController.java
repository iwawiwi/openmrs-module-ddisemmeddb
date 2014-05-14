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

import java.util.List;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.openmrs.api.context.Context;
import org.openmrs.module.ddisemmeddb.DDISemMedDB;
import org.openmrs.module.ddisemmeddb.api.DDISemMedDBService;
import org.openmrs.module.ddisemmeddb.api.impl.DDISemMedDBServiceImpl;
import org.openmrs.module.ddisemmeddb.api.jdbc.JdbcDDISemMedDBDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.servlet.ModelAndView;

/**
 * The main controller.
 * TODO: Not Secure
 */
@Controller
public class  DDISemMedDBManageController {
	
	protected final Log log = LogFactory.getLog(getClass());
//	@Autowired
//	private JdbcDDISemMedDBDAO ddiSemMedDBDAO;
	
	@RequestMapping(value = "/module/ddisemmeddb/manage", method = RequestMethod.GET)
	public void manage(ModelMap model) {
		model.addAttribute("user", Context.getAuthenticatedUser());
	}
	
	@RequestMapping(value = "module/ddisemmeddb/index", method = RequestMethod.GET)
	public void index(ModelMap model) {
		model.addAttribute("user", Context.getAuthenticatedUser());
	}
	
	@RequestMapping(value = "module/ddisemmeddb/check", method = RequestMethod.POST)
	public String check(@RequestParam("drug1") String drug1, @RequestParam("drug2") String drug2, ModelMap model) {
		log.info(drug1);
		log.info(drug2);
		
		try {
			Context.openSession();
			System.out.println("[INFO] Here in CHECK method!");
			List<DDISemMedDB> results= (List<DDISemMedDB>) Context.getService(DDISemMedDBService.class).check();
			log.info(results.get(0).getS_name());
			log.info(results.size());
			System.out.println("[INFO] Result set size "+results.size());
			
			// There is potential DDI found
			if (results.size() != 0) {
				model.addAttribute("results", results);
//				ModelAndView mv = new ModelAndView("check");
//				mv.addObject("flashScope.message", "Potential DDIs found! Please check results.");
//				return mv;
//				model.addAttribute("message", "Potential DDIs found! Please check results.");
				System.out.println("[INFO] Will be redirected to checkResult!");
				return "checkResult";
			} else {
//				ModelAndView mv = new ModelAndView("check");
//				mv.addObject("flashScope.message", "Success! No potential DDIs found.");
//				return mv;
//				model.addAttribute("message", "Success! No potential DDIs found.");
				return "redirect:index.form";
			}
		} finally {
			Context.closeSession();
		}
		
//		if (StringUtils.isEmpty(drug1) && StringUtils.isEmpty(drug2)) {
//			return "index.form";
//		}
//		else {
//			return "redirect:index.form";
//		}
	}
	
//	@RequestMapping(value = "module/ddisemmeddb/check", method = RequestMethod.GET)
//	public String checkResult(ModelMap model) {
//		try {
//			Context.openSession();
//			return "checkResult";
//		} finally {
//			Context.closeSession();
//		}
//	}
	
//	@RequestMapping(value = "module/ddisemmeddb/list", method = RequestMethod.GET)
//	public void list() {
//		
//	}
}
