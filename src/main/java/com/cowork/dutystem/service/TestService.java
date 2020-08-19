package com.cowork.dutystem.service;

import org.springframework.stereotype.Service;

@Service
public class TestService {

    public Object getTest() throws Exception {
        return "test";
    }

    public Object getTest2() {
        return "test2";
    }
}
