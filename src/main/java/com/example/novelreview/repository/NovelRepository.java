package com.example.novelreview.repository;

import com.example.novelreview.model.Novel;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface NovelRepository extends PagingAndSortingRepository<Novel, Integer> {
}
