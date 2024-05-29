package com.example.dependencyinjectiondagger

import android.content.ContentValues.TAG
import android.nfc.Tag
import android.util.Log
import javax.inject.Inject
import javax.inject.Singleton

interface NotificationService{
    fun send(to : String , from:String , body : String?)

}
@Singleton
class EmailService  @Inject constructor(private var popData : Int) : NotificationService {
    override fun send(to: String, from: String, body: String?) {
        Log.d("SIDBOT", "Email Sent $popData")
    }
}
class MessageService(private var retryCount : Int) : NotificationService{
    override fun send(to: String, from: String, body: String?) {
        Log.d(TAG , "Message Sent - Retry Cout $retryCount")
    }

}