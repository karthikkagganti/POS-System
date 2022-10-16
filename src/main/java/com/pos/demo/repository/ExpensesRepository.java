package com.pos.demo.repository;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.pos.demo.entity.Expenses;

public interface ExpensesRepository extends JpaRepository<Expenses, Integer> {
	Optional<List<Expenses>> findAllByOrderDate(LocalDate date);

}
