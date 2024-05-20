package com.back.m2p6.repository

import com.back.m2p6.model.User
import org.springframework.data.jpa.repository.JpaRepository

interface UserRepository: JpaRepository<User, Long> {


}