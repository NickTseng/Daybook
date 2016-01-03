package com.nick.service

import com.nick.domain.User
import org.springframework.data.repository.CrudRepository

/**
 * Created by nick on 2016/1/3.
 */
interface UserRepository extends CrudRepository<User, Long> {

}

