package com.example.multipledb;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.multipledb.primary.PRepository;
import com.example.multipledb.primary.PrimaryEntity;
import com.example.multipledb.secondary.SRepository;
import com.example.multipledb.secondary.SecondaryEntity;

@RestController
public class TestController {
    @Autowired
    private PRepository primaryRepository;
    @Autowired
    private SRepository secondaryRepository;
    @GetMapping("/test")
    public String test() {
        PrimaryEntity primaryEntity = new PrimaryEntity();
        primaryEntity.setName("Primary Entity");
        primaryRepository.save(primaryEntity);
        SecondaryEntity secondaryEntity = new SecondaryEntity();
        secondaryEntity.setDescription("Secondary Entity");
        secondaryRepository.save(secondaryEntity);
        return "Entities saved!";
    }
}
