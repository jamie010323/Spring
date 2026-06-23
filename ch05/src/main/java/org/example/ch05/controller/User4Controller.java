package org.example.ch05.controller;


import lombok.RequiredArgsConstructor;
import org.example.ch05.dto.User4DTO;
import org.example.ch05.service.User4Service;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;

@RequiredArgsConstructor
@Controller
public class User4Controller {

    // @RequiredArgsConstructor 어노테이션으로 의존객체 주입 ⭐⭐⭐⭐⭐
    private final User4Service service;

    @GetMapping("/user4/list")
    public String list(Model model) {

        // 조회 서비스 요청
        List<User4DTO> dtoList = service.getAll();

        // 모델참조: 뷰(html)에서 컨트롤러 데이터 참조
        model.addAttribute("dtoList", dtoList);

        return "/user4/list";
    }

    @GetMapping("/user4/register")
    public String register() {
        return "/user4/register";
    }

    @PostMapping("/user4/register")
    public String register(User4DTO dto) {
        System.out.println(dto);

        // 등록 서비스 호출
        service.register(dto);


        return "redirect:/user4/list";
    }

    @GetMapping("/user4/modify")
    public String modify(String userid, Model model) {
        System.out.println(userid);

        // 수정 조회 서비스 호출
        User4DTO dto = service.getById(userid);

        // 모델 참조
        model.addAttribute(dto); // 키값 생략하면 해당 객체 소문자로 시작하는 타입명

        return "/user4/modify";
    }

    @PostMapping("/user4/modify")
    public String modify(User4DTO dto) {
        System.out.println(dto);

        // 수정 서비스 요청
        service.modify(dto);

        // 수정 후 목록 이동
        return "redirect:/user4/list?modify=success";
    }

    @GetMapping("/user4/remove")
    public String remove(String userid) {
        System.out.println(userid);

        // 삭제 서비스 요청
        service.remove(userid);

        // 삭제 후 목록 이동
        return "redirect:/user4/list?remove=success";
    }
}