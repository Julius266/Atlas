package com.example.sculptor

import android.annotation.SuppressLint
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.google.firebase.database.*

class ListaActivity : AppCompatActivity() {

    private lateinit var dbref2 : DatabaseReference
    private lateinit var ejerciciosRecyclerView2: RecyclerView
    private lateinit var infoArrayList2 : ArrayList<Usuario>

    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_lista)



        val btnRegresar: Button = findViewById(R.id.btnRegresar3)
        btnRegresar.setOnClickListener {
            val intent: Intent = Intent(this,HomeActivity::class.java)
            startActivity(intent)
        }

        ejerciciosRecyclerView2 = findViewById(R.id.recyclerView2)
        ejerciciosRecyclerView2.layoutManager = LinearLayoutManager(this)
        ejerciciosRecyclerView2.setHasFixedSize(true)

        infoArrayList2 = arrayListOf<Usuario>()
        getUserData()
    }

    private fun getUserData() {
        dbref2 = FirebaseDatabase.getInstance().getReference("ejerciciosPierna ")

        dbref2.addValueEventListener(object  : ValueEventListener {
            override fun onDataChange(snapshot: DataSnapshot) {

                if(snapshot.exists()){

                    for(ejercicioSnapshot in snapshot.children){

                        val ejercicio = ejercicioSnapshot.getValue(Usuario::class.java)
                        infoArrayList2.add(ejercicio!!)

                    }

                    ejerciciosRecyclerView2.adapter = EjerciciosAdapter(infoArrayList2)

                }


            }

            override fun onCancelled(error: DatabaseError) {
                TODO("Not yet implemented")
            }

        })
    }
}