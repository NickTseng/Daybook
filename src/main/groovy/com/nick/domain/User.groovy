package com.nick.domain

import javax.persistence.*
/**
 * Created by nick on 2016/1/3.
 */

@Entity
class User {
    @Id
    @GeneratedValue
    Long id
}
