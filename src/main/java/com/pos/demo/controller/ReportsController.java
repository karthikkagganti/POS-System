package com.pos.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.pos.demo.entity.Reports;
import com.pos.demo.service.ReportsService;


@CrossOrigin
@RestController
public class ReportsController {
	
	@Autowired
	private ReportsService reportsService;
	
	@GetMapping("/report")
	public List<Reports> getReport(){
		return reportsService.getReports();
	}
	
	@GetMapping("/report/{reportid}")
	public Reports addExpenses(@PathVariable int reportid) {
		return reportsService.generateReport(reportid);
	}
	
	@PostMapping("/report")
	public int addReport() {
		return reportsService.addReport();
	}
	
	@DeleteMapping("/report/{id}")
	public String deleteReport(@PathVariable int id) {
		return reportsService.deleteReport(id);
	}
}
