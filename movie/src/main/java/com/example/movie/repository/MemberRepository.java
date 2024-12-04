package com.example.movie.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import com.example.movie.entity.Member;
import com.example.movie.entity.Movie;
import com.example.movie.entity.MovieImage;

public interface MemberRepository extends JpaRepository<Member, Long> {

    Optional<Member> findByEmail(String email);

    // 닉네임 수정
    @Modifying // update , delete 일 때 써야함
    @Query("UPDATE Member m SET m.nickname=:nickname WHERE m.email=:email")
    void updateNickname(String nickname, String email);
}
