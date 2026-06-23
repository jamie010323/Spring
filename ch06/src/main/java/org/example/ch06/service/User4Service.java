package org.example.ch06.service;

import lombok.RequiredArgsConstructor;
import org.example.ch06.dto.User4DTO;
import org.example.ch06.entity.User4;
import org.example.ch06.repository.User4Repository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@RequiredArgsConstructor
@Service
public class User4Service {

    // @RequiredArgsConstructor 어노테이션으로 생성자 주입
    private final User4Repository repository;

    // 기본 서비스 메서드
    public void register(User4DTO dto){

        // DTO를 Entity 변환
        User4 entity = dto.toEntity();

        // JPA save() 메서드 호출, Entity가 데이터베이스에 INSERT
        repository.save(entity);
    }

    public User4DTO getUser(String userid){

        // JPA 조회, Optional 타입은 엔티티를 안전하게 사용하기 위한 Wrapper 클래스
        Optional<User4> optUser4 = repository.findById(userid);

        // Entity 존재 여부 확인
        if(optUser4.isPresent()){
            // 존재하면 Optional 타입으로 포장된 Entity 꺼내기
            User4 entity = optUser4.get();

            // DTO 변환 후 반환
            return entity.toDTO();
        }
        return null;
    }

    public List<User4DTO> getUserAll(){

        // JPA 조회 메서드 호출, SELECT * FROM User4
        List<User4> entityList = repository.findAll();

        // DTO 리스트 변환
        List<User4DTO> dtoList = entityList.stream()
                .map(entity -> entity.toDTO())
                .toList();

        return dtoList;
    }

    public void modify(User4DTO dto){

        // 엔티티 존재 여부 확인
        boolean isExist = repository.existsById(dto.getUserid());

        // 수정하려는 엔티티가 존재하면 수정
        if(isExist){
            // DTO를 Entity 변환
            User4 entity = dto.toEntity();

            // JPA 수정 메서드, save() 메서드는 INSERT or UPDATE 수행
            repository.save(entity);
        }

    }

    public void remove(String userid){
        // JPA 삭제 메서드 호출, DELETE FROM User4 Where userid='아이디' 수행
        repository.deleteById(userid);
    }


}