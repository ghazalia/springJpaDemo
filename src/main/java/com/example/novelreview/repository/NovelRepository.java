package com.example.novelreview.repository;

import java.util.List;

import com.example.novelreview.model.Novel;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface NovelRepository extends PagingAndSortingRepository<Novel, Integer> {

  @Query("Select n from novel n where n.writer_id = ?1 and n.name = ?2")
  Novel findOwnerAndNovelByOwnerIdAndNovelName(Integer writerId, String petName);

  @Query("Select n from novel n where upper(n.name) = ?1")
  List<Novel> findByNameIgnoreCaseIn(String upperCase);

  @Query("select n from novel n where n.id = ?1 and n.name = ?2")
  Novel findByNovelNameAndId(Integer novelId, String novelName);
}
