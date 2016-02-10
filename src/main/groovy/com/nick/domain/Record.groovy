package com.nick.domain

import javax.persistence.*

/**
 * 記帳資料
 *
 * @author Nick Tseng
 * @since 1.0 
 */
@Entity
@Table(name = "records")
class Record {
    /** Id. */
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    Long id

    /** 料號. */
    Date recordDate

    /** 描述. */
    String description

    /** 金額. */
    Integer amount

    /** 分類. */
    Long typeId

    /** 新增時間. */
    Date createdAt

    /** 更新時間. */
    Date updatedAt

}