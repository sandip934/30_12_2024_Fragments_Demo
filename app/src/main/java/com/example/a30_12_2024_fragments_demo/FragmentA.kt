package com.example.a30_12_2024_fragments_demo

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.TextView
import androidx.fragment.app.Fragment

class FragmentA : Fragment() {


    private lateinit var txtCounterView : TextView
    private lateinit var btnIncrement : Button
    private lateinit var btnDecrement : Button
    private var count :  Int = 0

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        val fragmentView = inflater.inflate(R.layout.fragment_,null)
        txtCounterView = fragmentView.findViewById(R.id.txtView)
        btnIncrement = fragmentView.findViewById(R.id.btnIncrement)
        btnDecrement = fragmentView.findViewById(R.id.btnDecrement)
        btnIncrement.setOnClickListener {
            count++
            txtCounterView.text =""+ count
        }
        btnDecrement.setOnClickListener {
            if(count>0){
                count--
            }
            txtCounterView.text =""+ count
        }

        return fragmentView
    }
}