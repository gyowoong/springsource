package com.example.movie.controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.movie.dto.ReviewDto;
import com.example.movie.service.ReviewService;

import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RequestMapping("/reviews")
@RequiredArgsConstructor
@Log4j2
@RestController
public class ReviewController {

    private final ReviewService reviewService;

    // ~~ /reviews/45/all
    @GetMapping("/{mno}/all")
    public List<ReviewDto> getList(@PathVariable Long mno) {
        log.info("리뷰 리스트 요청 {}", mno);

        List<ReviewDto> reviews = reviewService.getReviews(mno);

        return reviews;
    }

    // ~~~/reviews/mno(245)/reviewNo(50) + @DeleteMapping
    @PreAuthorize("authentication.name == #reviewDto.email")
    @DeleteMapping("/mno/{reviewNo}")
    public Long deleteReview(@PathVariable Long reviewNo) {
        log.info("리뷰 삭제 요청 {}", reviewNo);

        reviewService.removeReview(reviewNo);

        return reviewNo;
    }

    // ~~/reviews/mno/reviewNo + @GetMapping
    @GetMapping("/mno/{reviewNo}")
    public ReviewDto getRow(@PathVariable Long reviewNo) {
        log.info("리뷰 수정 요청 {}", reviewNo);

        ReviewDto reviewDto = reviewService.getReview(reviewNo);
        return reviewDto;

    }

    // ~~/reviews/mno/reviewNo + @PutMapping + ReviewDto
    @PreAuthorize("authentication.name == #reviewDto.email")
    @PutMapping("/mno/{reviewNo}")
    public Long putReview(@PathVariable Long reviewNo, @RequestBody ReviewDto reviewDto) {
        log.info("리뷰 수정 요청 {}, {}", reviewNo, reviewDto);

        reviewDto.setReviewNo(reviewNo);
        reviewNo = reviewService.modifyReview(reviewDto);

        return reviewNo;
    }

    // ~~/reviews/mno/ + PostMapping + ReviewDto
    @PostMapping("/{mno}")
    public Long postReview(@RequestBody ReviewDto reviewDto) {
        log.info("리뷰 등록 {}", reviewDto);

        return reviewService.addReview(reviewDto);

    }
}