package com.stmanagment.sts.repository;

import com.stmanagment.sts.model.Category;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.stereotype.Repository;

@Repository
@RepositoryRestResource(collectionResourceRel = "productCategory", path = "product-category")
public interface CategoryRepository extends JpaRepository<Category, Long> {
    
}
