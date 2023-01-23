package com.example.sculptor

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.google.firebase.database.*

class EjerciciosAvticity : AppCompatActivity() {

    private lateinit var dbref : DatabaseReference
    private lateinit var ejerciciosRecyclerView: RecyclerView
    private lateinit var infoArrayList : ArrayList<Usuario>


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_ejercicios_avticity)

        val btonRegresar: Button = findViewById(R.id.btnRegresar)
        btonRegresar.setOnClickListener{
            val intent: Intent = Intent(this,HomeActivity::class.java)
            startActivity(intent)
        }

        ejerciciosRecyclerView = findViewById(R.id.recyclerView)
        ejerciciosRecyclerView.layoutManager = LinearLayoutManager(this)
        ejerciciosRecyclerView.setHasFixedSize(true)

        infoArrayList = arrayListOf<Usuario>()
        getUserData()



    }

    private fun getUserData() {
        dbref = FirebaseDatabase.getInstance().getReference("ejercicios")

        dbref.addValueEventListener(object  : ValueEventListener{
            override fun onDataChange(snapshot: DataSnapshot) {

                if(snapshot.exists()){

                    for(ejercicioSnapshot in snapshot.children){

                        val ejercicio = ejercicioSnapshot.getValue(Usuario::class.java)
                        infoArrayList.add(ejercicio!!)

                    }

                    ejerciciosRecyclerView.adapter = EjerciciosAdapter(infoArrayList)

                }


            }

            override fun onCancelled(error: DatabaseError) {
                TODO("Not yet implemented")
            }

        })
    }


}