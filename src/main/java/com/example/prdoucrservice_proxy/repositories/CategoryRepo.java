package com.example.prdoucrservice_proxy.repositories;

import com.example.prdoucrservice_proxy.models.Categories;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface CategoryRepo extends JpaRepository<Categories,Long> {
    Categories save(Categories categories);

    Categories findById(long id);
//   @Query(value = "SELECT c.name FROM Categories c WHERE c.id=?1")
//    String findCategoriesById(long id);
//    @Query(value = "SELECT c.name FROM Categories c WHERE c.id=:id")
//    String findCategoriesByName(@Param("id") long id);

}
