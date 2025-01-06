package com.lucasalmeida.dscommerce.repositories;

import com.lucasalmeida.dscommerce.entities.Category;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CategoryRepository extends JpaRepository<Category, Long> {


}
