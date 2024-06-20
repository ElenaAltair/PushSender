package ru.netology.pusher

import com.google.auth.oauth2.GoogleCredentials
import com.google.firebase.FirebaseApp
import com.google.firebase.FirebaseOptions
import com.google.firebase.messaging.FirebaseMessaging
import com.google.firebase.messaging.Message
import java.io.FileInputStream

const val token1:String = "my token"

fun main() {

    val serviceAccount =
        FileInputStream("nmedia-f7c91-firebase-adminsdk-czpm0-80d900b28a.json")

    val options = FirebaseOptions.builder()
        .setCredentials(GoogleCredentials.fromStream(serviceAccount))
        .build()

    FirebaseApp.initializeApp(options)

    val message = Message.builder()
        .putData("action", "NEWPOST")
        .putData("content", """{
          "userId": 1,
          "userName": "Vasiliy",
          "postId": 2,
          "postContent": "This is a new post created by user Vasily. A very new post. This is a new post created by user Vasily. A very new post."
        }""".trimIndent())
        .setToken(token1)
        .build()

    FirebaseMessaging.getInstance().send(message)
}