package com.example.homework3

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.TextUtils
import android.util.Patterns
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.Toast

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val inputEmail = findViewById<EditText>(R.id.inputEmail)
        val userName = findViewById<EditText>(R.id.inputUserName)
        val firstName = findViewById<EditText>(R.id.inputFirstName)
        val lastName = findViewById<EditText>(R.id.inputLastName)
        val inputAge = findViewById<EditText>(R.id.inputAge)
        val saveBtn = findViewById<Button>(R.id.saveBtn)
        val clearBtn = findViewById<Button>(R.id.clearBtn)

        saveBtn.setOnClickListener {
            val inputedEmail = inputEmail.text.toString()
            val userName = userName.text.toString()
            val firstName = firstName.text.toString()
            val lastName = lastName.text.toString()
            val inputAge = inputAge.text.toString().toInt()

            isEmpty(email = inputedEmail,
                userName = userName,
                firstName = firstName,
                lastName = lastName,
                age = inputAge
            )
            inputDetails(userName = userName)
            isEmailValid(email = inputedEmail)
            isAgeValid(age = inputAge)
        }

        clearBtn.setOnLongClickListener {
            inputEmail.setText("")
            userName.setText("")
            firstName.setText("")
            lastName.setText("")
            inputAge.setText("")

            true
        }
    }

    private fun isEmpty(
        email: String,
        userName: String,
        firstName: String,
        lastName: String,
        age: Int,
    ) {
        if (((firstName.isEmpty() && lastName.isEmpty()) || email.isEmpty() || userName.isEmpty() || age.toString()
                .isEmpty())
        ) {
            Toast.makeText(this, "input is empty!!!", Toast.LENGTH_SHORT).show()
        }
    }

    private fun inputDetails(userName: String) {
        if (userName.length in 1 until 10) {
            Toast.makeText(this, "username is too short!!!", Toast.LENGTH_SHORT).show()
        }
    }

    private fun isEmailValid(email: String) {
        if (email.endsWith("@gmail.com")) {

        } else {
            Toast.makeText(this, "E-mail is not valid!!!", Toast.LENGTH_SHORT).show()
        }
    }

    private fun isAgeValid(age: Int) {
        if (age <= 0) {
            Toast.makeText(this, "age is not valid!!!", Toast.LENGTH_SHORT).show()
        }
    }

}
