package com.masai.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.masai.entity.Category;

@Service
public interface CategoryService {
    public Category addCategory(Category cat);
    public Category updateCategory(Category cat);
    public Category removeCategory(Category cat);
    public Category viewCategory(Category cat);
    public List<Category> viweAllCategory();
}
