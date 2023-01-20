package com.example.sculptor

import android.annotation.SuppressLint
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.content.Intent
import android.widget.Button
import android.widget.TextView
import android.widget.Toast
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.ktx.auth
import com.google.firebase.ktx.Firebase


class RegistoActivity : AppCompatActivity() {

    private lateinit var firebaseAuth: FirebaseAuth


    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_registo)

        val textEmail : TextView = findViewById(R.id.correoEditText)
        val textPass : TextView = findViewById(R.id.contrasenaEditText)
        val textConfirmacion : TextView = findViewById(R.id.confirmacionEditText)
        val btnRegistrado : Button = findViewById(R.id.registradoBtn)

        btnRegistrado.setOnClickListener(){
            var pass = textPass.text.toString()
            var passC = textConfirmacion.text.toString()
            if (pass.equals(passC))
            {
                crearUsuario(textEmail.text.toString(), textPass.text.toString())
            }
            else
            {
                Toast.makeText(baseContext, "Las contraseñas no son iguales",Toast.LENGTH_SHORT).show()
                textPass.requestFocus()
            }
        }
        firebaseAuth= Firebase.auth


        val ton2: Button = findViewById(R.id.buttonRegresar)
        ton2.setOnClickListener {
            val intent: Intent = Intent(this, AuthActivity::class.java)
            startActivity(intent)

        }

    }

    private fun crearUsuario(email: String, password: String){
        firebaseAuth.createUserWithEmailAndPassword(email, password)
            .addOnCompleteListener(this)  {task ->
                if (task.isSuccessful)
                {
                    Toast.makeText(baseContext, "Usuario Registrado", Toast.LENGTH_SHORT).show()
                }
                else
                {
                    Toast.makeText(baseContext, "Error al registrar: " + task.exception, Toast.LENGTH_SHORT).show()

                }
            }

    }
}