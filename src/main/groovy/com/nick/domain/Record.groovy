package com.nick.domain

import javax.persistence.*

/**
 * Created by nick on 2016/1/4.
 */
@Entity
@Table(name = "records")
class Record {
    @Id
    @GeneratedValue
    Long id

    Date recordDate

    String desc

    Integer amount





}