package com.example.KotlinApiMongoDB.Model

import org.springframework.data.annotation.Id
import org.springframework.data.mongodb.core.mapping.Document


@Document
class User {
    @Id
    var id =""
    var  name=""
    var email =""
    var password =""
}