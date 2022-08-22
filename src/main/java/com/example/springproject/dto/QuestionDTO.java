package com.example.springproject.dto;

import com.example.springproject.model.QuestionEntity;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.BufferedReader;

@Builder
@NoArgsConstructor
@AllArgsConstructor
@Data

//외부 사용자에게 서비스 내부의 로직, 데이터베이스 구조 등을 숨기기 위함.
public class QuestionDTO {
    private String id;
    private String title;
    private String question;
    private String code;
    private String comment;


    public QuestionDTO(final QuestionEntity entity){
        this.id=entity.getId();
        this.title=entity.getTitle();
        this.question=entity.getQuestion();
        this.code=entity.getCode();
        this.comment=entity.getComment();

    }
    public static QuestionEntity toEntity(final QuestionDTO dto){
        return QuestionEntity.builder()
                .id(dto.getId())
                .title(dto.getTitle())
                .question(dto.getQuestion())
                .code(dto.getCode())
                .comment(dto.getComment())
                .build();
    }
}
