package com.cowork.dutystem.service;

import com.cowork.dutystem.entity.Board;
import com.cowork.dutystem.mapper.TestMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TestService {

    @Autowired
    private TestMapper testMapper;

    public String getTest() throws Exception {
        return testMapper.getTestTitle1();
    }

    public String getTest2() throws Exception {
        return testMapper.getTestTitle2();
    }

    public Board getBoard() throws Exception {
        Board board = testMapper.getBoard();
        return board;
    }

}
