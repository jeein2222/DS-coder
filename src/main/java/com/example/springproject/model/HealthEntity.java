package com.example.springproject.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Builder
@NoArgsConstructor
@AllArgsConstructor
@Data
@Entity
@Table(name="Health")
public class HealthEntity {
    @Id
    @GeneratedValue(generator="system-uuid")
    @GenericGenerator(name="system-uuid",strategy = "uuid")
    private String id; //오브젝트 아이디
    private String userId; //이 오브젝트를 생성한 사용자의 아이디
    private String title; //운동 종목
    private float time; //운동 시간
    private String food; //하루 동안 먹은 것
    private boolean done; //완료한 경우

}
