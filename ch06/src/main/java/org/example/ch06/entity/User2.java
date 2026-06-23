package org.example.ch06.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.*;
import org.example.ch06.dto.User2DTO;

@Getter
//@Setter Entity에서는 Setter 금지
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Builder
@Entity
@Table(name = "user2")  // 매핑 테이블 설정, 생략가능
public class User2 {
    @Id                     // 테이블 PK 속성 선언
    private String userid;

    @Column(name = "name")  // 테이블 매핑 설정, 생략 가능
    private String name;

    @Column(name = "hp")
    private String birth;
    private String addr;

    // DTO 변환 메서드
    public User2DTO toDTO(){
        return User2DTO.builder()
                .userid(userid)
                .name(name)
                .birth(birth)
                .addr(addr)
                .build();
    }


}