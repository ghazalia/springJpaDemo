package com.example.novelreview.service;

import com.example.novelreview.dto.WriterDto;
import com.example.novelreview.repository.WriterRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class WriterService {
    @Autowired
    private WriterRepository writerRepo;

    public void save(WriterDto writer) {

    }
}
