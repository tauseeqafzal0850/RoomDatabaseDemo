package com.example.testcode.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.lifecycle.ViewModelProvider
import com.example.testcode.databinding.ActivityMainBinding
import com.example.testcode.db.entity.UserEntity
import com.example.testcode.ui.viewmodel.HomeViewModel
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {
    private val binding by lazy { ActivityMainBinding.inflate(layoutInflater) }
    private val mViewModel: HomeViewModel by lazy { ViewModelProvider(this)[HomeViewModel::class.java] }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)
        setupObserver()
        handleEventListener()
    }

    private fun setupObserver() {
        mViewModel.usersList.observe(this) {
            var concatenateList = ""
            it?.let { usersList ->
                usersList.forEach { user ->
                    concatenateList = concatenateList + user.FullName + " : " + user.Address + "\n"
                }
            }
            binding.tvDataOutput.text = concatenateList
        }
    }

    private fun handleEventListener() {
        binding.btnInsertData.setOnClickListener {
            if (binding.editTextFullName.text!!.isEmpty()) {
                Toast.makeText(this, "Enter Full Name", Toast.LENGTH_SHORT).show()
            } else if (binding.editTextEmployeeId.text!!.isEmpty()) {
                Toast.makeText(this, "Enter Employee ID", Toast.LENGTH_SHORT).show()
            } else if (binding.editTextAddress.text!!.isEmpty()) {
                Toast.makeText(this, "Enter Full Address", Toast.LENGTH_SHORT).show()
            } else if (binding.editTextPhoneNumber.text!!.isEmpty()) {
                Toast.makeText(this, "Enter Phone Number", Toast.LENGTH_SHORT).show()
            } else if (binding.editTextAge.text!!.isEmpty()) {
                Toast.makeText(this, "Enter Your Age", Toast.LENGTH_SHORT).show()
            } else {
                mViewModel.getSpecificUser(binding.editTextEmployeeId.text.toString())?.let {
                    Toast.makeText(this, "User Already Registered", Toast.LENGTH_SHORT).show()
                } ?: run {
                    mViewModel.addNewUser(
                        userEntity = UserEntity(
                            0,
                            binding.editTextEmployeeId.text.toString(),
                            binding.editTextFullName.text.toString(),
                            binding.editTextPhoneNumber.text.toString(),
                            binding.editTextAddress.text.toString(),
                            binding.editTextAge.text.toString().toInt()
                        )
                    )
                    Toast.makeText(this, "User Inserted", Toast.LENGTH_SHORT).show()
                    binding.editTextEmployeeId.text!!.clear()
                    binding.editTextFullName.text!!.clear()
                    binding.editTextPhoneNumber.text!!.clear()
                    binding.editTextAddress.text!!.clear()
                    binding.editTextAge.text!!.clear()
                }
            }
        }

        binding.btnShowData.setOnClickListener {
            mViewModel.getAllUsers()
        }
    }
}