package com.example.testcode.db.entity

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
class UserEntity(
    @PrimaryKey(autoGenerate = true)
    @ColumnInfo()
    val id: Int = 0,
    @ColumnInfo()
    val employeeID:String,
    @ColumnInfo()
    val FullName:String,
    @ColumnInfo()
    val PhoneNumber: String,
    @ColumnInfo()
    val Address: String,
    @ColumnInfo()
    val Age: Int
)