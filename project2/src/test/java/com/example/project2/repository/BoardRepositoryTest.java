package com.example.project2.repository;

import java.util.stream.IntStream;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.data.web.SpringDataWebProperties.Pageable;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.PageRequest;

import com.example.project2.entity.Board;

@SpringBootTest
public class BoardRepositoryTest {

    @Autowired
    private BoardRepository boardRepository;

    @Test
    public void insertTest() {
        IntStream.rangeClosed(1, 300)
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
        // boardRepository.findByTitle("Title....").forEach(b -> System.out.println(b));
        // boardRepository.findByTitleLike("Title").forEach(b -> {
        // System.out.println(b);
        // });

        // boardRepository.findByTitleStartingWith("Title").forEach(b -> {
        // System.out.println(b)
        // );

        // boardRepository.findByWriterEndingWith("1").forEach(b -> {
        // System.out.println(b)
        // );

        // boardRepository.findByWriterContaining("user").forEach(b ->
        // System.out.println(b)
        // );

        boardRepository.findByWriterContainingOrTitleContaining("user",
                "Title").forEach(b -> System.out.println(b));

        // boardRepository.findByTitleContainingAndIdGraterThan("Title", 10)
        // .forEach(b -> System.out.println(b));

        // boardRepository.findByIdGreaterThanOrderByIdDesc(10L)
        // .forEach(b -> System.out.println(b));

        // 0 : 1 page 의미, pageSize : 한 페이지에 보여질 게시물 개수
        // Pageable pageable = PageRequest.of(0L, 10);

        // boardRepository.findByIdGreaterThanOrderByIdDescPageable(10L, pageable)
        // .forEach(b -> System.out.println(b));

        // boardRepository.findByWriterList("user")
        // .forEach(b -> System.out.println(b));

    }

}
