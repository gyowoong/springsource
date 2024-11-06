package com.example.memo.repository;

import java.util.List;
import java.util.stream.LongStream;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.example.memo.entity.Memo;

@SpringBootTest
public class MemoRepositoryTest {

    @Autowired
    private MemoRepository memoRepository;

    // C
    @Test
    public void testMemoInsert() {
        LongStream.rangeClosed(1, 10).forEach(i -> {
            Memo memo = Memo.builder().memoText("memo practice" + i).build();
            memoRepository.save(memo);
        });
    }

    // R
    @Test
    public void testMemoRead() {
        // 26번 메모 가져오기
        Memo memo = memoRepository.findById(26L).get();
        System.out.println(memo);

        System.out.println();

        // 전체 메모 가져오기
        List<Memo> list = memoRepository.findAll();
        list.forEach(m -> System.out.println(memo));
    }

    // U
    @Test
    public void testMemoUpdate() {
        // 27번 메모 내용 수정
        Memo memo = memoRepository.findById(27L).get();
        memo.setMemoText("memo 수정");
        memoRepository.save(memo);
    }

    // D
    @Test
    public void testMemoDelete() {
        // 메모 삭제
        memoRepository.deleteById(30L);
    }

}
