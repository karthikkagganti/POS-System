package com.pos.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.pos.demo.entity.Reports;

public interface ReportsRepository extends JpaRepository<Reports, Integer>{
}
