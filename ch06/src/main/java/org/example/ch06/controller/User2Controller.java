package org.example.ch06.controller;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.example.ch06.dto.User2DTO;
import org.example.ch06.service.User2Service;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;

@Slf4j
@RequiredArgsConstructor
@Controller
public class User2Controller {

    // 서비스 주입, @RequiredArgsConstructor 선언
    private final User2Service service;

    @GetMapping("/user2/list")
    public String list(Model model){

        // 서비스 호출
        List<User2DTO> dtoList = service.getUserAll();

        // 모델 참조
        model.addAttribute("dtoList", dtoList);

        return "/user2/list";
    }

    @GetMapping("/user2/register")
    public String register(){
        return "/user2/register";
    }

    @PostMapping("/user2/register")
    public String register(User2DTO dto){
        log.info(dto.toString());
        // 서비스 호출
        service.register(dto);
        // 목록 이동
        return "redirect:/user2/list";
    }


    @GetMapping("/user2/modify")
    public String modify(Model model, String userid){
        log.info(userid);

        // 서비스 호출
        User2DTO dto = service.getUser(userid);
        log.info(dto.toString());

        // 모델 참조
        model.addAttribute(dto); // 키값을 생략하면 소문자로 시작하는 객체 타입이 이름이 됨

        return "/user2/modify";
    }

    @PostMapping("/user2/modify")
    public String modify(User2DTO dto){
        log.info(dto.toString());

        // 서비스 호출
        service.modify(dto);

        // 목록 이동
        return "redirect:/user2/list?modify=success";
    }

    @GetMapping("/user2/remove")
    public String remove(String userid){
        log.info(userid);

        // 서비스 호출
        service.remove(userid);

        // 목록 이동
        return "redirect:/user2/list?remove=success";
    }
}