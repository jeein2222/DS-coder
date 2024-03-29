package com.example.springproject.dto;

import com.example.springproject.model.RecordEntity;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Builder
@NoArgsConstructor
@AllArgsConstructor
@Data

//외부 사용자에게 서비스 내부의 로직, 데이터베이스 구조 등을 숨기기 위함.
public class RecordDTO {
    private String id;

    private String userid;
    private String title;
    private String question;
    private String code;


    public RecordDTO(final RecordEntity entity){
        this.id=entity.getId();
        this.title=entity.getTitle();
        this.question=entity.getQuestion();
        this.code=entity.getCode();
        this.userid=entity.getUserId();

    }
    public static RecordEntity toEntity(final RecordDTO dto){
        return RecordEntity.builder()
                .id(dto.getId())
                .title(dto.getTitle())
                .question(dto.getQuestion())
                .code(dto.getCode())
                .userId(dto.getUserid())
                .build();
    }
}
