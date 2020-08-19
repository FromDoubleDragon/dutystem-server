package com.cowork.dutystem.configuration.typehandler;

import com.cowork.dutystem.entity.BoardJson;
import org.apache.ibatis.type.JdbcType;
import org.apache.ibatis.type.MappedTypes;
import org.apache.ibatis.type.TypeHandler;

import java.sql.CallableStatement;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;


@MappedTypes(BoardJson.class)
public class BoardJsonTypeHandler implements TypeHandler<BoardJson> {

    @Override
    public void setParameter(PreparedStatement preparedStatement, int columIndex, BoardJson boardJson, JdbcType jdbcType) throws SQLException {
        preparedStatement.setObject(columIndex, boardJson);
    }

    @Override
    public BoardJson getResult(ResultSet resultSet, String columnName) throws SQLException {
        String boardJson = resultSet.getString(columnName);
        
    }

    @Override
    public BoardJson getResult(ResultSet resultSet, int columIndex) throws SQLException {
        return null;
    }

    @Override
    public BoardJson getResult(CallableStatement callableStatement, int columIndex) throws SQLException {
        return null;
    }
}
