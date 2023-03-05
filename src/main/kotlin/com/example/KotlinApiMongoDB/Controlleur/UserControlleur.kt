package com.example.KotlinApiMongoDB.Controlleur

import com.example.KotlinApiMongoDB.Model.User
import com.example.KotlinApiMongoDB.Repo.UserRepo
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*
import kotlin.random.Random

@RestController
@RequestMapping("api")
class UserControlleur ( private  val userRepo: UserRepo) {



    @PutMapping("/users/putOne")
    fun putOne(){
        for(i in 1..50){
            val r = User()
            r.id= "$i"
            r.name="name #" + (i + 1)
            r.email="email #" + Random.nextInt(1000)
            r.password="pass"
            this.userRepo.insert(r)
        }

    }


    @GetMapping("/users/getAll")
    fun getAll() :ResponseEntity<List<User>>{

        return ResponseEntity.ok(this.userRepo.findAll())

    }

    @GetMapping("/users/getById")
    fun getById(@RequestParam("s", defaultValue = "") s : String) :ResponseEntity<List<User>>{

        return ResponseEntity.ok(this.userRepo.search(s))

    }
    @DeleteMapping("/users/deleteAll")
    fun deleteAll(): ResponseEntity<String> {
        userRepo.deleteAll()

        return ResponseEntity.ok("done")
    }
    @DeleteMapping("/users/deleteById")
    fun deleteById(@RequestParam("s", defaultValue = "") s : String): ResponseEntity<String> {
        userRepo.deleteById(s)

        return ResponseEntity.ok(" $s was deleteted")
    }

}