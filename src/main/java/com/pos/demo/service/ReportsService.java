package com.pos.demo.service;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.pos.demo.entity.Customer;
import com.pos.demo.entity.Expenses;
import com.pos.demo.entity.OrderedItems;
import com.pos.demo.entity.Orders;
import com.pos.demo.entity.Reports;
import com.pos.demo.repository.CustomerRepository;
import com.pos.demo.repository.ExpensesRepository;
import com.pos.demo.repository.OrderRepository;
import com.pos.demo.repository.OrderedItemsRepository;
import com.pos.demo.repository.ReportsRepository;

@Service
public class ReportsService {

	@Autowired
	ReportsRepository reportsRepository;
	@Autowired
	ExpensesRepository expensesRepository;
	@Autowired
	OrderedItemsRepository orderedItemsRepository;
	
	public List<Reports> getReports() {
		// TODO Auto-generated method stub
		List<Reports> reports = new ArrayList<>();
		reportsRepository.findAll().forEach(reports::add);
		return reports;
	}
	public Reports generateReport(int reportid) {
		// TODO Auto-generated method stub
		
		Reports report = reportsRepository.findById(reportid).get();
		List<Expenses> expenses = expensesRepository.findAllByOrderDate(report.getReportDate()).get();
		List<OrderedItems> orders = orderedItemsRepository.findAllByOrderDate(report.getReportDate()).get();
		report.addOrders(orders);
		report.addExpenses(expenses);
		float total = 0;
		for(int i=0; i< orders.size(); i++) {
			total += orders.get(i).getSubTotal();
		}
		for(int i=0; i< expenses.size(); i++) {
			total -= expenses.get(i).getAmount();
		}
		report.setTotal(total);
		report.setNoSales(orders.size());
		reportsRepository.save(report);
		return report;
	}
	public int addReport() {
		// TODO Auto-generated method stub
		Reports report = new Reports();
		reportsRepository.save(report);
		return report.getReportid();
	}
	public String deleteReport(int id) {
		// TODO Auto-generated method stub
		Reports report = reportsRepository.findById(id).get();
		reportsRepository.delete(report);
		return "Report was Deleted!";
	}
	
}
