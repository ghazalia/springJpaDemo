package com.example.novelreview.model;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface WriterRepository extends CrudRepository<Writer, Integer> {

    List<Writer> findByNameContainingOrderByName(String name);

    @Query("Select w from Writer w where w.name like %:name% order by w.name ASC ")
    List<Writer> searchByNameLike(@Param("name") String name);
}
