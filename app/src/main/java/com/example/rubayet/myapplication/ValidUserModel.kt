package com.example.rubayet.myapplication
import com.google.gson.annotations.SerializedName

data class ValidUserModel(
		@SerializedName("messageType") val messageType: String,
		@SerializedName("UserID") val userID: String,
		@SerializedName("decodeId") val decodeId: String
)