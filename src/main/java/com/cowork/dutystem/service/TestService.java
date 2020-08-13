package com.cowork.dutystem.service;

import com.cowork.dutystem.mapper.TestMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TestService {

    @Autowired
    private TestMapper testMapper;

    public Object getTest() throws Exception {
        return "test";
    }

    public Object getTest2() {
        return "test2";
    }
}
