package com.qa.individual_project.controller;

import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.qa.individual_project.model.Category;
import com.qa.individual_project.repository.CategoriesRepository;

@RestController
@RequestMapping("api/v1/")
public class CategoriesController {
	
	@Autowired
	private CategoriesRepository categoriesRepository;
	
	@RequestMapping(value = "categories", method = RequestMethod.GET)
    public List<Category> list(){
        return categoriesRepository.findAll();
    }

	@RequestMapping(value = "categories", method = RequestMethod.POST)
    public Category create(@RequestBody Category category){
        return categoriesRepository.saveAndFlush(category);
    }

	@RequestMapping(value = "categories/{id}", method = RequestMethod.GET)
    public Category get(@PathVariable int id){
        return categoriesRepository.findOne(id);
    }

	@RequestMapping(value = "categories/{id}", method = RequestMethod.PUT)
    public Category update(@PathVariable int id, @RequestBody Category category){
        Category existingCategory = categoriesRepository.findOne(id);
        BeanUtils.copyProperties(category, existingCategory);
        return categoriesRepository.saveAndFlush(category);
    }

	@RequestMapping(value = "categories/{id}", method = RequestMethod.DELETE)
    public Category delete(@PathVariable int id){
        Category existingCategory = categoriesRepository.findOne(id);
        categoriesRepository.delete(existingCategory);
        return existingCategory;
    }
}
