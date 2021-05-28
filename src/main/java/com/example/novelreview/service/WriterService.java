package com.example.novelreview.service;

import com.example.novelreview.dto.WriterDto;
import com.example.novelreview.exception.EmailAlreadyExistsException;
import com.example.novelreview.exception.WriterNotFoundException;
import com.example.novelreview.model.Writer;
import com.example.novelreview.repository.WriterRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import java.util.ArrayList;
import java.util.List;

@Service
public class WriterService {
    @Autowired
    private WriterRepository writerRepo;

    public void save(WriterDto writer) throws EmailAlreadyExistsException {
        Writer newWriter = new Writer();
        if (newWriter.getEmail().equals(writer.getEmail())) {
            throw new EmailAlreadyExistsException("Email already exist");
        }

        newWriter.setName(writer.getName());
        newWriter.setEmail(writer.getEmail());
        newWriter.setPhone(writer.getPhone());
        writerRepo.save(newWriter);
    }

    public List<Writer> listAllWriters() {
        List<Writer> writers = new ArrayList<>();
        writerRepo.findAll().forEach(writer -> writers.add(writer));
        return writers;
    }

    public Long count() {
        return writerRepo.count();
    }

    public void deleteById(Integer writerId) {
        writerRepo.deleteById(writerId);
    }

    public void updateWriter(Writer writerToUpdate) {
        Writer writerInDB = writerRepo.findById(writerToUpdate.getId())
                .orElseThrow(() -> new WriterNotFoundException("Not Found"));
        writerInDB.setEmail(writerToUpdate.getEmail());
        writerInDB.setPhone(writerToUpdate.getPhone());
        writerInDB.setName(writerToUpdate.getName());
        writerRepo.save(writerInDB);
    }

    public Writer findWriterById(Integer writerId) {
        return writerRepo.findById(writerId)
                .orElseThrow(() -> new WriterNotFoundException("Not Found"));
    }

    public List<Writer> findWriterByName(String writerName) {
        List<Writer> writers = new ArrayList<>();

        if (StringUtils.hasText(writerName)) {
            writerRepo.findByNameIgnoreCaseIn(writerName.toUpperCase())
                    .forEach(writer -> writers.add(writer));
        } else {
            return listAllWriters();
        }

        return writers;
    }

}
