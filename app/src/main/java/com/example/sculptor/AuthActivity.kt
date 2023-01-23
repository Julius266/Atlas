package com.example.sculptor

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.ktx.auth
import com.google.firebase.ktx.Firebase

class AuthActivity : AppCompatActivity() {


    private lateinit var firebaseAuth: FirebaseAuth



    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_auth)
        val ton : Button = findViewById(R.id.loginButton)
        val mailText: TextView = findViewById(R.id.emailEditText)
        val pssText: TextView = findViewById(R.id.passwordEditText)

        val ton2: Button = findViewById(R.id.logoutButton)
        ton2.setOnClickListener {
            val intent: Intent = Intent(this, RegistoActivity::class.java)
            startActivity(intent)
        }

        firebaseAuth= Firebase.auth
        ton.setOnClickListener()
        {
            singIn(mailText.text.toString(), pssText.text.toString())
            /*val btn: Button = findViewById(R.id.loginButton)*/
            ton.setOnClickListener {
                if (mailText.text.isEmpty() || pssText.text.isEmpty()) {
                    Toast.makeText(baseContext, "Llene los campos requeridos", Toast.LENGTH_SHORT).show()
                }
                singIn(mailText.text.toString(), pssText.text.toString())
                val intent: Intent = Intent(this, HomeActivity::class.java)
                startActivity(intent)
            }
        }

    }

    private fun singIn(email: String, password: String)
    {
        firebaseAuth.signInWithEmailAndPassword(email, password)
            .addOnCompleteListener(this) { task ->
                if (task.isSuccessful) {
                    val user = firebaseAuth.currentUser
                    Toast.makeText(baseContext, user?.uid.toString(), Toast.LENGTH_SHORT).show()
                }
                else
                {
                    Toast.makeText(baseContext,"Ingrese correctamente el correo o contraseña" , Toast.LENGTH_SHORT).show()
                }
            }
    }

}