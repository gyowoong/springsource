package com.example.guestbook.dto;

import java.time.LocalDateTime;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Builder
@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
@ToString
public class GuestBookDto {

    private Long gno;

    @NotBlank(message = "title 은 필수 입력 요소입니다.")
    private String title;

    @NotEmpty(message = "content 은 필수 입력 요소입니다.")
    private String content;

    @NotBlank(message = "writer 은 필수 입력 요소입니다.")
    private String writer;

    private LocalDateTime regDate; // 최초 생성 시간

    private LocalDateTime updateDate; // 최종 수정 시간

}
