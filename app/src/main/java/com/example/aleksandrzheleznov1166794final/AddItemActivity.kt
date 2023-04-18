package com.example.aleksandrzheleznov1166794final

import android.R
import android.content.Intent
import android.os.Bundle
import android.widget.ArrayAdapter
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.aleksandrzheleznov1166794final.databinding.ActivityAddNewItemBinding
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.firestore.FirebaseFirestore


class AddItemActivity : AppCompatActivity(){

    // bind to activity_add_new_item.xml
    private lateinit var binding: ActivityAddNewItemBinding
    private lateinit var auth : FirebaseAuth

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityAddNewItemBinding.inflate(layoutInflater)
        setContentView(binding.root)
        auth = FirebaseAuth.getInstance()

        binding.top10Ranking.prompt = "Top 10 Ranking"


        //populate the spinner top10Ranking with the list 1-10
        val spinner = binding.top10Ranking
        val list = mutableListOf<String>()
        for (i in 1..10) {
            list.add(i.toString())
        }
        val adapter = ArrayAdapter(this, R.layout.simple_spinner_dropdown_item, list)
        spinner.adapter = adapter










        binding.addDestinationBtn.setOnClickListener {

            if (binding.destinationName.text.toString()
                    .isNotEmpty() && binding.destinationDescription.text.toString()
                    .isNotEmpty() && binding.top10Ranking.selectedItem.toString().isNotEmpty()
            ) {
                // add destination to firebase
                val db = FirebaseFirestore.getInstance()
                val destination = hashMapOf(
                    "destinationName" to binding.destinationName.text.toString(),
                    "destinationDescription" to binding.destinationDescription.text.toString(),
                    "top10Ranking" to binding.top10Ranking.selectedItem.toString(),
                    "userId" to auth.currentUser?.uid
                )
                db.collection("destinations")
                    .add(destination)
                    .addOnSuccessListener { documentReference ->
                        Toast.makeText(this, "Destination added successfully", Toast.LENGTH_SHORT)
                            .show()
                        val intent = Intent(this, MainActivity::class.java)
                        startActivity(intent)
                    }
                    .addOnFailureListener { e ->
                        Toast.makeText(this, "Error adding destination", Toast.LENGTH_SHORT).show()
                    }
            } else {
                Toast.makeText(this, "Please fill out all fields", Toast.LENGTH_SHORT).show()
            }


        }
    }



}