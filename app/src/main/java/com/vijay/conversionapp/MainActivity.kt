package com.vijay.conversionapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.LayoutInflater
import android.widget.ArrayAdapter
import com.vijay.conversionapp.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding

    val conversions = arrayOf(
        "Select conversion type",
        "KM TO MI",
        "MI TO KM",
        "IN TO CM",
        "CE TO IN",
        "KG TO LBS",
        "LBS TO KG"
    )
    val unitsvalue = arrayOf("", "0.621371", "1.60934", "2.54", "0.393701", "2.20462", "0.453592")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val adapter = ArrayAdapter(this, android.R.layout.simple_dropdown_item_1line, conversions)
        binding.conopctions.adapter = adapter

        binding.convert.setOnClickListener {

            val value = binding.userinput.text.toString().toDouble()
            val answer = value * unitsvalue[binding.conopctions.selectedItemPosition].toDouble()

            binding.result.text = answer.toString()
        }
    }
}
