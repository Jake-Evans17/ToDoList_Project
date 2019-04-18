package com.qa.individual_project.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.qa.individual_project.model.Category;

public interface CategoriesRepository extends JpaRepository<Category, Integer> {

}
