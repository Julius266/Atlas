package com.example.sculptor

import android.annotation.SuppressLint
import android.content.ClipData.Item
import android.content.Intent
import android.content.res.Configuration
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.MenuItem
import android.widget.Button
import android.widget.Toast
import androidx.appcompat.app.ActionBarDrawerToggle
import androidx.appcompat.widget.Toolbar
import androidx.core.view.GravityCompat
import androidx.drawerlayout.widget.DrawerLayout
import androidx.fragment.app.Fragment
import com.google.android.material.navigation.NavigationView
import com.google.firebase.auth.ktx.auth
import com.google.firebase.ktx.Firebase

enum class ProviderType{
    BASIC
}

class HomeActivity : AppCompatActivity(){
    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_home)

        val bton: Button = findViewById(R.id.btnEjercicios)
        bton.setOnClickListener {
            val intent: Intent = Intent(this,EjerciciosAvticity::class.java)
            startActivity(intent)
        }
        val bton2: Button = findViewById(R.id.btnCalculadora)
        bton2.setOnClickListener {
            val intent: Intent = Intent(this,CalculadoraActivity::class.java)
            startActivity(intent)
        }

        val bton3: Button = findViewById(R.id.btnLista)
        bton3.setOnClickListener {
            val intent: Intent = Intent(this,ListaActivity::class.java)
            startActivity(intent)
        }

        val bton4: Button = findViewById(R.id.btnCerrarSesion)
        bton4.setOnClickListener {
            Firebase.auth.signOut()
            val intent: Intent = Intent(this,AuthActivity::class.java)
            startActivity(intent)

        }


        }

    }



