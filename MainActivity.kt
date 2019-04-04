package com.example.practicelayout

import android.annotation.SuppressLint
import android.app.DatePickerDialog

import android.app.TimePickerDialog
import android.icu.util.Calendar
import android.icu.util.Calendar.getInstance
import android.os.Build
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.annotation.RequiresApi
import android.widget.*
import com.example.practicelayout.R.layout.activity_main
import java.text.SimpleDateFormat


class MainActivity : AppCompatActivity() {
     lateinit var edit:EditText
       @SuppressLint("SimpleDateFormat")
       @RequiresApi(Build.VERSION_CODES.N)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(activity_main)
        val edittext= findViewById<TextView>(R.id.et_time)
           edittext.setOnClickListener {
            val cal = Calendar.getInstance()
            val timeSetListener = TimePickerDialog.OnTimeSetListener { view, hour, minute ->
                cal.set(Calendar.HOUR_OF_DAY, hour)
                cal.set(Calendar.MINUTE, minute)
                edittext.text = SimpleDateFormat("HH:mm").format(cal.time)
            }
            TimePickerDialog(this, timeSetListener, cal.get(Calendar.HOUR_OF_DAY), cal.get(Calendar.MINUTE), true).show()
        }
        edit=findViewById(R.id.etentername)
        edit.setOnClickListener (null)
        edit.isFocusable=false
        edit.isClickable=true
        edit.setOnClickListener{view->
            callTheDataPicker()

        }
       }
    @RequiresApi(Build.VERSION_CODES.N)
    private fun  callTheDataPicker(){
        val c= getInstance()
        val year=c.get(Calendar.YEAR)
        val month=c.get(Calendar.MONTH)
        val day=c.get(Calendar.DAY_OF_MONTH)
        val seedate=DatePickerDialog(this,DatePickerDialog.OnDateSetListener { view, year, monthOfYear, dayOfMonth ->
            edit.setText("$dayOfMonth/${(monthOfYear +1 )}/$year")
        }, year,month,day
        )
        seedate.show()
    }
    }


