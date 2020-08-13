package com.cowork.dutystem.mapper;

import com.cowork.dutystem.entity.Board;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface TestMapper {

    String getTestTitle1();

    String getTestTitle2();

    Board getBoard();
}
