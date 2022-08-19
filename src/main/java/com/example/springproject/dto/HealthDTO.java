package com.example.springproject.dto;

import com.example.springproject.model.HealthEntity;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Builder
@NoArgsConstructor
@AllArgsConstructor
@Data

//외부 사용자에게 서비스 내부의 로직, 데이터베이스 구조 등을 숨기기 위함.
public class HealthDTO {
    private String id; //오브젝트 아이디
    private String title; //운동 종목
    private float time; //운동 시간
    private String food; //하루 동안 먹은 것
    private boolean done; //완료한 경우

    public HealthDTO(final HealthEntity entity){
        this.id=entity.getId();
        this.title=entity.getTitle();
        this.time=entity.getTime();
        this.food=entity.getFood();
        this.done=entity.isDone();
    }
    public static HealthEntity toEntity(final HealthDTO dto){
        return HealthEntity.builder()
                .id(dto.getId())
                .title(dto.getTitle())
                .time(dto.getTime())
                .food(dto.getFood())
                .done(dto.isDone())
                .build();
    }
}
