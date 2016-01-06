package com.nick.service

import com.nick.domain.Type
import org.springframework.data.jpa.repository.*

/**
 * Created by nick on 2016/1/6.
 */

interface TypeRepository extends JpaRepository<Type, Long> {

}