package com.example.board.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import com.example.board.entity.Reply;

public interface ReplyRepository extends JpaRepository<Reply, Long> {

    // reply 테이블의 board_bno를 이용해서 reply 삭제하는 Query Method 생성
    @Modifying
    @Query("DELETE FROM Reply r WHERE r.board.bno = :bno")
    void deletebyBno(Long bno);
}
