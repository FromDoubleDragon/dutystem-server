package com.cowork.dutystem.entity;

import lombok.*;

import java.time.LocalDateTime;

@NoArgsConstructor
@AllArgsConstructor
@ToString
@Setter
@Getter
public class BoardJson {
    private Integer boardSeq;
    private String title;
    private String content;
    private String nickname;
    private LocalDateTime regdate;
}
