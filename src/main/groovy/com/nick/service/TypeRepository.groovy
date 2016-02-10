package com.nick.service

import com.nick.domain.Type
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;
import java.sql.ResultSet;
import java.sql.SQLException;


/**
 * Created by nick on 2016/1/6.
 */

@Repository
public class TypeRepository {

    @Autowired
    protected JdbcTemplate jdbc;

    public List<Type> getTypes() {
        return jdbc.query("SELECT id,  name FROM types", typeMapper)
    }


    private static final RowMapper<Type> typeMapper = new RowMapper<Type>() {
        public Type mapRow(ResultSet rs, int rowNum) throws SQLException {
            Type type = new Type()
            type.id = rs.getLong("id")
            type.name =  rs.getString("name")
            return type;
        }
    };

}