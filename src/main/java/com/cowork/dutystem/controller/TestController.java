package com.cowork.dutystem.controller;

import com.cowork.dutystem.service.TestService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequiredArgsConstructor
@RequestMapping("/api/v1/test")
@RestController
public class TestController {

    private final TestService testService;

    @GetMapping("/permit-all")
    public Object getTest() throws Exception {
        return testService.getTest();
    }

    @GetMapping("/auth")
    public Object getTest2() throws Exception {
        return testService.getTest2();
    }

    @GetMapping("/board")
    public Object getBoard() throws Exception {
        return testService.getBoard();
    }

}
