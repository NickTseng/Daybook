package com.nick.service

import com.nick.domain.Record
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;
import java.sql.ResultSet;
import java.sql.SQLException;


/**
 * Created by nick on 2016/1/4.
 */

@Repository
public class RecordRepository {

    @Autowired
    protected JdbcTemplate jdbc;

    public List<Record> findByRecordDateBetween(Date startDate, Date endDate) {
        return jdbc.query("SELECT id,  amount,  created_at," +
                        "  description, record_date, updated_at, type_id           " +
                        "  FROM records", recordMapper)
    }

    public boolean insert(Record record){
        String sqlInsert = "INSERT INTO records (amount, description, record_date, type_id)"
        + " VALUES (?, ?, ?, ?)";
        JdbcTemplate.update(sqlInsert, { record.amount, record.description, record.recordDate, record.typeId})

    }


    private static final RowMapper<Record> recordMapper = new RowMapper<Record>() {
        public Record mapRow(ResultSet rs, int rowNum) throws SQLException {
            Record record = new Record()
            record.id = rs.getLong("id")
            record.amount =  rs.getInt("amount")
            record.createdAt =  rs.getDate("created_at")
            record.typeId =  rs.getLong("type_id")
            record.recordDate =  rs.getDate("record_date")
            record.updatedAt =  rs.getDate("updated_at")

            return record;
        }
    };


}