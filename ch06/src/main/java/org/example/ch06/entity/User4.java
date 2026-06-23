package org.example.ch06.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.*;
import org.example.ch06.dto.User4DTO;

@Getter
//@Setter Entity에서는 Setter 금지
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Builder
@Entity
@Table(name = "user4")  // 매핑 테이블 설정, 생략가능
public class User4 {
    @Id                     // 테이블 PK 속성 선언
    private String userid;

    @Column(name = "name")  // 테이블 매핑 설정, 생략 가능
    private String name;

    @Column(name = "gender")
    private String gender;
    private int age;
    private String hp;
    private String addr;

    // DTO 변환 메서드
    public User4DTO toDTO(){
        return User4DTO.builder()
                .userid(userid)
                .name(name)
                .gender(gender)
                .age(age)
                .hp(hp)
                .addr(addr)
                .build();
    }


}