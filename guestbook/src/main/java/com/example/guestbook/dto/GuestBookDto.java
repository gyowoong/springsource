package com.example.guestbook.dto;

import java.time.LocalDateTime;

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

    private String title;

    private String writer;

    private String content;

    private LocalDateTime regDate; // 최초 생성 시간

    private LocalDateTime updateDate; // 최종 수정 시간

}
