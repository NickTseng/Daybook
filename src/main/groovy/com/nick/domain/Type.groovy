package com.nick.domain

import javax.persistence.*


/**
 * 分類.
 *
 * @author Nick Tseng
 * @since 1.0
 */
@Entity
@Table(name = "types")

class Type {

    /** ID. */
    @Id
    @GeneratedValue
    Long id

    /** 名稱. */
    String name
}
