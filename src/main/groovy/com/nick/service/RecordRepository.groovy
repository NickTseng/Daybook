package com.nick.service

import com.nick.domain.Record
import org.springframework.data.jpa.repository.*

/**
 * Created by nick on 2016/1/4.
 */

interface RecordRepository extends JpaRepository<Record, Long> {

    List<Record> findByRecordDateBetween(Date departure, Date arrival)

}