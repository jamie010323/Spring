package org.example.ch06.controller;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.example.ch06.dto.User3DTO;
import org.example.ch06.service.User3Service;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;

@Slf4j
@RequiredArgsConstructor
@Controller
public class User3Controller {

    // 서비스 주입, @RequiredArgsConstructor 선언
    private final User3Service service;

    @GetMapping("/user3/list")
    public String list(Model model){

        // 서비스 호출
        List<User3DTO> dtoList = service.getUserAll();

        // 모델 참조
        model.addAttribute("dtoList", dtoList);

        return "/user3/list";
    }

    @GetMapping("/user3/register")
    public String register(){
        return "/user3/register";
    }

    @PostMapping("/user3/register")
    public String register(User3DTO dto){
        log.info(dto.toString());
        // 서비스 호출
        service.register(dto);
        // 목록 이동
        return "redirect:/user3/list";
    }


    @GetMapping("/user3/modify")
    public String modify(Model model, String userid){
        log.info(userid);

        // 서비스 호출
        User3DTO dto = service.getUser(userid);
        log.info(dto.toString());

        // 모델 참조
        model.addAttribute(dto); // 키값을 생략하면 소문자로 시작하는 객체 타입이 이름이 됨

        return "/user3/modify";
    }

    @PostMapping("/user3/modify")
    public String modify(User3DTO dto){
        log.info(dto.toString());

        // 서비스 호출
        service.modify(dto);

        // 목록 이동
        return "redirect:/user3/list?modify=success";
    }

    @GetMapping("/user3/remove")
    public String remove(String userid){
        log.info(userid);

        // 서비스 호출
        service.remove(userid);

        // 목록 이동
        return "redirect:/user3/list?remove=success";
    }
}