package com.example.listadapteranddiffutil

import android.os.Bundle
import android.os.Handler
import android.os.Looper
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
        val recyclerView = findViewById<RecyclerView>(R.id.rv_programming)
        val adapter = ProgrammingAdapter()
        val p1 = ProgrammingItem(1, "J", "Java")
        val p2 = ProgrammingItem(2, "P", "Python")
        val p3 = ProgrammingItem(3, "K", "Kotlin")

        adapter.submitList(
            listOf(
                p1, p2, p3
            )
        )

        recyclerView.layoutManager = LinearLayoutManager(this)
        recyclerView.setHasFixedSize(true)
        recyclerView.adapter = adapter

        Handler(Looper.getMainLooper()).postDelayed(
            Runnable {
                val p3 = ProgrammingItem(3, "K", "Kotlin")
                val p4 = ProgrammingItem(4, "N", "Node")
                val p5 = ProgrammingItem(5, "A", "Android")
                val p6 = ProgrammingItem(6, "R", "React")

                adapter.submitList(
                    listOf(
                        p3,p4,p5, p6
                    )
                )
            }, 3000
        )
    }
}