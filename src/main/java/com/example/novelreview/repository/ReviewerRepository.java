package com.example.novelreview.repository;

import com.example.novelreview.model.Reviewer;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ReviewerRepository extends PagingAndSortingRepository<Reviewer, Integer> {
}
