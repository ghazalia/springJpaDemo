package com.example.novelreview.service;

import java.util.ArrayList;
import java.util.List;

import com.example.novelreview.exception.DataAlreadyExistException;
import com.example.novelreview.exception.DataNotFoundException;
import com.example.novelreview.model.Novel;
import com.example.novelreview.repository.NovelRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.StringUtils;

/**
 * NovelService
 */
public class NovelService {
  @Autowired
  private NovelRepository novelRepo;

  public void save(Novel novelToAdd) throws DataAlreadyExistException {

    if (novelIsNew(novelToAdd)) {
      novelRepo.save(novelToAdd);
    } else {
      throw new DataAlreadyExistException("Data Already Exist");
    }

  }

  private boolean novelIsNew(Novel novelToAdd) {
    return novelRepo.findOwnerAndNovelByOwnerIdAndNovelName(novelToAdd.getWriter().getId(),
        novelToAdd.getName()) == null;
  }

  public List<Novel> listAllNovels() {
    List<Novel> novels = new ArrayList<>();
    novelRepo.findAll().forEach(novel -> novels.add(novel));
    return novels;
  }

  public Long count() {
    return novelRepo.count();
  }

  public List<Novel> findNovelByName(String novelName) {

    if (StringUtils.hasText(novelName)) {
      List<Novel> novels = new ArrayList<>();
      novelRepo.findByNameIgnoreCaseIn(novelName.toUpperCase()).forEach(novel -> novels.add(novel));
      return novels;
    } else {
      return this.listAllNovels();
    }
  }

  public void updateNovel(Novel novelToUpdate) throws DataAlreadyExistException {
    if (StringUtils.hasText(novelToUpdate.getName())
        && novelRepo.findByNovelNameAndId(novelToUpdate.getId(), novelToUpdate.getName()) == null) {
      novelRepo.save(novelToUpdate);
    } else {
      throw new DataAlreadyExistException("Duplicate novel for the same author");
    }
  }

  public void deleteNovelById(Novel novelToDelete) throws DataNotFoundException {
    if (novelRepo.existsById(novelToDelete.getId())) {
      novelRepo.delete(novelToDelete);
    } else {
      throw new DataNotFoundException("Data Not Found");
    }
  }

}