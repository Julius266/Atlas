package com.example.sculptor

import android.annotation.SuppressLint
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.google.firebase.database.*

class CalculadoraActivity : AppCompatActivity() {

    private lateinit var dbref1 : DatabaseReference
    private lateinit var ejerciciosRecyclerView1: RecyclerView
    private lateinit var infoArrayList1 : ArrayList<Usuario>

    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_calculadora)

        val btonRegresar1: Button = findViewById(R.id.btnRegresar2)
        btonRegresar1.setOnClickListener {
            val intent: Intent = Intent(this,HomeActivity::class.java)
            startActivity(intent)
        }

        ejerciciosRecyclerView1 = findViewById(R.id.recyclerView1)
        ejerciciosRecyclerView1.layoutManager = LinearLayoutManager(this)
        ejerciciosRecyclerView1.setHasFixedSize(true)

        infoArrayList1 = arrayListOf<Usuario>()
        getUserData()
    }

    private fun getUserData() {
        dbref1 = FirebaseDatabase.getInstance().getReference("ejerciciosEspalda")

        dbref1.addValueEventListener(object  : ValueEventListener {
            override fun onDataChange(snapshot: DataSnapshot) {

                if(snapshot.exists()){

                    for(ejercicioSnapshot in snapshot.children){

                        val ejercicio = ejercicioSnapshot.getValue(Usuario::class.java)
                        infoArrayList1.add(ejercicio!!)

                    }

                    ejerciciosRecyclerView1.adapter = EjerciciosAdapter(infoArrayList1)

                }


            }

            override fun onCancelled(error: DatabaseError) {
                TODO("Not yet implemented")
            }

        })
    }
}