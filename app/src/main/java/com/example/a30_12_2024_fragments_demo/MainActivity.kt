package com.example.a30_12_2024_fragments_demo

import android.os.Bundle
import android.os.TransactionTooLargeException
import android.widget.Button
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.fragment.app.FragmentTransaction
import androidx.recyclerview.widget.LinearLayoutManager

class MainActivity : AppCompatActivity() {

    private lateinit var fragmentA: FragmentA
    private  var fragmentManager = supportFragmentManager
    private lateinit var fragmentTransaction:FragmentTransaction
    private var counterFragments:ArrayList<FragmentA> = ArrayList<FragmentA>()
    private lateinit var btnAddFragment: Button
    private lateinit var btnRemove: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        btnAddFragment = findViewById(R.id.btnAddFragment)
        btnRemove = findViewById(R.id.btnRemove)

        btnAddFragment.setOnClickListener {
            fragmentA = FragmentA()
            fragmentTransaction = fragmentManager.beginTransaction()
            fragmentTransaction.add(R.id.fragment, fragmentA)
                .addToBackStack("Added A fragment")
                .commit()
            counterFragments.add(fragmentA)
        }

        btnRemove.setOnClickListener {
            var indexToBeRemoved = counterFragments.size-1
            var counterFragmentA = counterFragments[indexToBeRemoved]


             var fragmentTransaction1 = fragmentManager.beginTransaction()
                 fragmentTransaction1  .remove(counterFragmentA)
                 fragmentTransaction1  .commit()

            counterFragments.remove(counterFragmentA)
        }
    }
}