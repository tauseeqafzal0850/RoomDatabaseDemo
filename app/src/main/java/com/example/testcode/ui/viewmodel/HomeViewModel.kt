package com.example.testcode.ui.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.testcode.db.RoomRepository
import com.example.testcode.db.entity.UserEntity
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class HomeViewModel @Inject constructor(private val repository: RoomRepository) : ViewModel() {

    var usersList: MutableLiveData<List<UserEntity>?> = MutableLiveData()

     fun getAllUsers() {
        val list = repository.getAllUsers()
         usersList.postValue(list)
    }

    fun getSpecificUser(employeeId:String): UserEntity? {
        return repository.getSpecificUser(employeeID = employeeId)
    }
    fun addNewUser(userEntity: UserEntity): Long {
        return repository.addNewUser(userEntity = userEntity)
    }

    fun deleteUser(userEntity: UserEntity): Int {
        return repository.deleteUser(userEntity)
    }
}