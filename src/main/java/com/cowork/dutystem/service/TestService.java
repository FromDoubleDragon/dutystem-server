package com.cowork.dutystem.service;

import org.springframework.stereotype.Service;

@Service
public class TestService {

    public Object getTest() throws Exception {
        throw new Exception("에러 발생");
    }

}
