package com.example.novelreview;

import com.example.novelreview.model.Writer;
import com.example.novelreview.model.WriterRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.List;

@SpringBootApplication
public class NovelreviewApplication {
    private static final Logger log = LoggerFactory.getLogger(NovelreviewApplication.class);

    public static void main(String[] args) {
        SpringApplication.run(NovelreviewApplication.class, args);
    }

    @Bean
    public CommandLineRunner demo(WriterRepository writerRepo) {
        return (args) -> {
            writerRepo.save(new Writer("John Bauer", "0123456789", "bauer@example.com"));
            writerRepo.save(new Writer("John Doe", "0123451789", "doe@example.com"));
            writerRepo.save(new Writer("Jane Bauer", "0123457789", "janebauer@example.com"));
            writerRepo.save(new Writer("Nick Bauer", "0123455789", "nick@example.com"));
            writerRepo.save(new Writer("Jane Bauer", "0123454789", "jane@example.com"));

//            fetch all writers
            log.info("List all writers");
            log.info("---------------------");
            for (Writer writer: writerRepo.findAll()) {
                log.info(writer.toString());
            }
            log.info("");

            //fetch writer by name
            log.info("Customer found with findByNameOrderByNameAsc: ");
            log.info("---------------------");
            writerRepo.findByNameContainingOrderByName("Bauer").forEach(writerFound -> {
                log.info(writerFound.toString());
            });

            //fetch writer by name
            log.info("Customer found with findByNameOrderByNameAsc: ");
            log.info("---------------------");
            List<Writer> writerList = writerRepo.searchByNameLike("Bauer");
            log.info("Listing using @Query");
            for (Writer writer:writerList) {
                log.info(writer.toString());
            }

        };
    }

}
