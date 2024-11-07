package com.example.project2.repository;

import java.util.stream.IntStream;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.example.project2.entity.Board;

@SpringBootTest
public class BoardRepositoryTest {

    @Autowired
    private BoardRepository boardRepository;

    @Test
    public void insertTest() {
        IntStream.rangeClosed(1, 20)
                .forEach(i -> {
                    Board board = Board.builder()
                            .title("자유게시판" + i)
                            .content("abcdefg" + i)
                            .writer("홍길동" + i)
                            .build();
                    boardRepository.save(board);
                });
    }

    @Test
    public void selectOneTest() {
        System.out.println(boardRepository.findById(1L).get());
    }

    @Test
    public void selectAllTest() {
        boardRepository.findAll().forEach(board -> System.out.println(board));
    }

    @Test
    public void UpdateTest() {
        Board board = boardRepository.findById(7L).get();
        board.setTitle("게시판");
        board.setContent("123456");
        boardRepository.save(board);
    }

    @Test
    public void deleteTest() {
        boardRepository.deleteById(6L);
    }

    @Test
    public void testTitleList() {
        boardRepository.findByTitle("Title....").forEach(b -> {
            System.out.println(b);
        });
        boardRepository.findByTitleLike("Title").forEach(b -> {
            System.out.println(b);
        });
    }

}
