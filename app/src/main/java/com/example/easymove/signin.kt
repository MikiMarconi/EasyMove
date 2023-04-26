package com.example.easymove

import android.content.Intent
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.easymove.databinding.ActivityMainBinding
import com.example.easymove.databinding.ActivitySigninBinding
import com.google.firebase.FirebaseApp
import com.google.firebase.auth.FirebaseAuth

class signin : AppCompatActivity() {

    private lateinit var binding:ActivitySigninBinding
    private lateinit var firebaseAuth: FirebaseAuth

    override fun onCreate(savedInstanceState: Bundle?){
        super.onCreate(savedInstanceState)
        FirebaseApp.initializeApp(this)
        binding = ActivitySigninBinding.inflate(layoutInflater)
        setContentView(binding.root)


        firebaseAuth = FirebaseAuth.getInstance()
        firebaseAuth = FirebaseAuth.getInstance()
        binding.loginBTN.setOnClickListener{
            val username = binding.usernameLE.text.toString()
            val password = binding.passwordLE.text.toString()

            if (username.isNotEmpty() && password.isNotEmpty()) {
                firebaseAuth.createUserWithEmailAndPassword(username, password).addOnCompleteListener{
                    if(it.isSuccessful){
                        val intent = Intent(this, ActivityMainBinding::class.java)
                        startActivity(intent)
                    }else{
                        Toast.makeText(this, it.exception.toString(), Toast.LENGTH_SHORT).show()
                    }
                }

            }else{
                Toast.makeText(this, "Username o Password non inseriti", Toast.LENGTH_SHORT).show()
            }
        }
    }

}