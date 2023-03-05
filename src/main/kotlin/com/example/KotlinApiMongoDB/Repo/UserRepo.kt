package com.example.KotlinApiMongoDB.Repo

import com.example.KotlinApiMongoDB.Model.User
import org.springframework.data.mongodb.repository.MongoRepository
import org.springframework.data.mongodb.repository.Query

interface UserRepo : MongoRepository< User , String> {


    @Query("{'_id': {\$regex: ?0, \$options: 'i' }}")
    fun search(s: String): List<User>





}