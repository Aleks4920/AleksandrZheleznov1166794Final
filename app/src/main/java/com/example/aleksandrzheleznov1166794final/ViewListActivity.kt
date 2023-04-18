package com.example.aleksandrzheleznov1166794final

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.aleksandrzheleznov1166794final.databinding.ActivityAddNewItemBinding
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.firestore.FirebaseFirestore

class ViewListActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_view_list)

        // bind to activity_add_new_item.xml
        private var binding: ActivityAddNewItemBinding = ActivityAddNewItemBinding.inflate(layoutInflater)
        setContentView(binding.root)
        private var auth : FirebaseAuth = FirebaseAuth.getInstance()



        }




}