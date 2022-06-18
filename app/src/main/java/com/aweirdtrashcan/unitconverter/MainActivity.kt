package com.aweirdtrashcan.unitconverter

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.AdapterView
import android.widget.ArrayAdapter
import android.widget.Toast
import com.aweirdtrashcan.unitconverter.databinding.ActivityMainBinding
import kotlin.properties.Delegates

class MainActivity : AppCompatActivity() {

    private lateinit var binding : ActivityMainBinding

    private var selectedSpinnerFrom : String? = null

    private var selectedSpinnerTo : String? = null

    private var result : Double? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        setUpSpinnerIdFrom()
        setUpSpinnerIdTo()

        binding.btnConvert.setOnClickListener { convertUnits() }

    }

    private fun setUpSpinnerIdFrom(){
        binding.spinnerFrom.onItemSelectedListener = object : AdapterView.OnItemSelectedListener {
            override fun onItemSelected(
                parent: AdapterView<*>?,
                view: View?,
                position: Int,
                id: Long
            ) {
                selectedSpinnerFrom = parent!!.getItemAtPosition(position).toString()
//                binding.etFirstInput.hint = "${selectedSpinnerFrom!!} to ${selectedSpinnerTo!!}"
            }

            override fun onNothingSelected(parent: AdapterView<*>?) {

            }
        }
    }

    private fun setUpSpinnerIdTo(){
        binding.spinnerTo.onItemSelectedListener = object : AdapterView.OnItemSelectedListener {
            override fun onItemSelected(
                parent: AdapterView<*>?,
                view: View?,
                position: Int,
                id: Long
            ) {
                selectedSpinnerTo = parent!!.getItemAtPosition(position).toString()
            }

            override fun onNothingSelected(parent: AdapterView<*>?) {

            }
        }
    }

    private fun convertUnits(){
        val firstInput : Double? = binding.etFirstInput.text.toString().toDouble()

        if (selectedSpinnerFrom != selectedSpinnerTo){
            if (firstInput != null){
                result = firstInput * 2.205
                binding.tvResult.text = result.toString()
            }
        }
    }

}