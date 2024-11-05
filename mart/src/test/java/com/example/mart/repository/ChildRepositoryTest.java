package com.example.mart.repository;

import java.util.stream.IntStream;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.example.mart.entity.cascade.Child;
import com.example.mart.entity.cascade.Parent;
import com.example.mart.repository.ParentRepository;
import com.example.mart.repository.ChildRepository;

@SpringBootTest
public class ChildRepositoryTest {

    @Autowired
    private ParentRepository parentRepository;

    @Autowired
    private ChildRepository childRepository;

    @Test
    public void testChildInsert() {
        Child child = Child.builder().name("Child1").build();
        childRepository.save();

    }
}
