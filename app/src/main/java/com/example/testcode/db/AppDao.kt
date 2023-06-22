package com.example.testcode.db

import androidx.room.*
import com.example.testcode.db.entity.UserEntity

@Dao
interface AppDao {

    @Query ("SELECT * FROM UserEntity WHERE employeeID= :employeeID LIMIT 1")
    fun getSpecificUser(employeeID: String): UserEntity?

    @Query ("SELECT * FROM UserEntity")
    fun getAllUsers(): List<UserEntity>?

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun addNewUser(userEntity: UserEntity):Long

    @Update
    fun updateUser(userEntity: UserEntity):Int

    @Delete
    fun deleteUser(userEntity: UserEntity):Int
}