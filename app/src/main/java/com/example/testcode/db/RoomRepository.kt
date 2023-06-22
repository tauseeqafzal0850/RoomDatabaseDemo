package com.example.testcode.db

import com.example.testcode.db.entity.UserEntity
import javax.inject.Inject

class RoomRepository @Inject constructor(private val appDao: AppDao) {

    fun addNewUser(userEntity: UserEntity): Long {
        return appDao.addNewUser(userEntity = userEntity)
    }

    fun getSpecificUser(employeeID: String): UserEntity? {
        return appDao.getSpecificUser(employeeID = employeeID)
    }

    fun getAllUsers(): List<UserEntity>? {
        return appDao.getAllUsers()
    }

    fun updateUser(userEntity: UserEntity): Int {
        return appDao.updateUser(userEntity)
    }

    fun deleteUser(userEntity: UserEntity): Int {
        return appDao.deleteUser(userEntity)
    }
}