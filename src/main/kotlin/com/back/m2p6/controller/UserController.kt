package com.back.m2p6.controller

import com.back.m2p6.model.User
import com.back.m2p6.service.UserService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("/users")
@CrossOrigin(methods = [RequestMethod.GET, RequestMethod.POST, RequestMethod.PATCH, RequestMethod.PUT], origins = ["http://localhost:3000"] )
class UserController {

    @Autowired
    lateinit var userService: UserService

    @GetMapping
    fun list(): ResponseEntity<List<User>> {
        val users = userService.list()
        return ResponseEntity(users, HttpStatus.OK)
    }

    @PostMapping
    fun save(@RequestBody user: User): ResponseEntity<User> {
        val savedUser = userService.save(user)
        return ResponseEntity(savedUser, HttpStatus.CREATED)
    }

    @PutMapping("/{id}")
    fun update(@PathVariable id: Long, @RequestBody user: User): ResponseEntity<User> {
        val existingUser = userService.getById(id) ?: return ResponseEntity(HttpStatus.NOT_FOUND)
        user.id = id
        val updatedUser = userService.update(user)
        return ResponseEntity(updatedUser, HttpStatus.OK)
    }

    @DeleteMapping("/{id}")
    fun delete(@PathVariable id: Long): ResponseEntity<Void> {
        val existingUser = userService.getById(id) ?: return ResponseEntity(HttpStatus.NOT_FOUND)
        userService.delete(id)
        return ResponseEntity(HttpStatus.NO_CONTENT)
    }

    @GetMapping("/{id}")
    fun getById(@PathVariable id: Long): ResponseEntity<User> {
        val user = userService.getById(id) ?: return ResponseEntity(HttpStatus.NOT_FOUND)
        return ResponseEntity(user, HttpStatus.OK)
    }
}