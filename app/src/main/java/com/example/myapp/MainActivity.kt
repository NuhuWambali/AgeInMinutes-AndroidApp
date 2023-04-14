package com.example.myapp

import android.app.DatePickerDialog
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.TextView
import android.widget.Toast
import java.text.SimpleDateFormat
import java.util.*

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val btnDatePicker=findViewById<Button>(R.id.btnDatePicker)
        btnDatePicker.setOnClickListener {View->
            clickDatePicker(View)

        }
    }
   fun clickDatePicker(view: View){
       val myCalendar= Calendar.getInstance()
       val Year=myCalendar.get(Calendar.YEAR)
       val Month=myCalendar.get(Calendar.MONTH)
       val Day=myCalendar.get(Calendar.DAY_OF_MONTH)

       val dpd=DatePickerDialog(this,DatePickerDialog.OnDateSetListener
       {
               View, selectedYear, selectedMonth, selectedDayOfMonth -> Toast.makeText(this, "the year chosen is $selectedYear,the month selected is $selectedMonth, and the day selected is $selectedDayOfMonth",Toast.LENGTH_SHORT).show()

           val selectedDate="$selectedDayOfMonth/${selectedMonth+1}/$selectedYear"
           val selectedDateKeep=findViewById<TextView>(R.id.tvSelectedDate)
           selectedDateKeep.setText(selectedDate)
           val sdf=SimpleDateFormat("dd/MM/yyyy",Locale.ENGLISH)
           val theDate=sdf.parse(selectedDate)

           val selectedDateInMinutes=theDate!!.time/60000
           val currentDate=sdf.parse(sdf.format(System.currentTimeMillis()))
           val currentDateToMinutes=currentDate!!.time/60000
           val differenceInMinutes=currentDateToMinutes-selectedDateInMinutes
           val ageInMinutesKeep=findViewById<TextView>(R.id.tvSelectedDateInMinutes)
           ageInMinutesKeep.setText(differenceInMinutes.toString())

       }, Year,Month,Day)
       dpd.datePicker.setMaxDate(Date().time-86400000)
       dpd.show()



   }
}