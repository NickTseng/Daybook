package com.nick.service

import com.nick.domain.Record
import org.springframework.data.repository.CrudRepository
import org.springframework.data.jpa.repository.Query

/**
 * Created by nick on 2016/1/4.
 */

interface RecordRepository extends CrudRepository<Record, Long> {
//    @Query("select b from Book b " +
//            "where b.from between ?1 and ?2 and b.to between ?1 and ?2")
//    List<Record> findByDatesBetween(Date departure, Date arrival);

    List<Record> findByRecordDateBetween(Date departure, Date arrival)

}