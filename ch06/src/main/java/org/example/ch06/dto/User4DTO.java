package org.example.ch06.dto;

import lombok.*;
import org.example.ch06.entity.User4;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Builder
public class User4DTO {
    private String userid;
    private String name;
    private String gender;
    private int age;
    private String hp;
    private String addr;

    // Entity 변환 메서드
    public User4 toEntity(){
        return User4.builder()
                .userid(userid)
                .name(name)
                .gender(gender)
                .age(age)
                .hp(hp)
                .addr(addr)
                .build();
    }
}