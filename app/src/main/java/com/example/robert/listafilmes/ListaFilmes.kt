package com.example.robert.listafilmes

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.widget.ArrayAdapter
import kotlinx.android.synthetic.main.activity_lista_filmes.*

class ListaFilmes : AppCompatActivity() {

    var languages = arrayOf(
        "English",
        "French",
        "Spanish",
        "Hindi",
        "Russian",
        "Telugu",
        "Chinese",
        "German",
        "Portuguese",
        "Arabic",
        "Dutch",
        "Urdu",
        "Italian",
        "Tamil",
        "Persian",
        "Turkish",
        "Other"
    )

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_lista_filmes)



        // Create an ArrayAdapter using a simple spinner layout and languages array
        val aa = ArrayAdapter(this, android.R.layout.simple_spinner_item, languages)
        // Set layout to use when the list of choices appear
        aa.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
        // Set Adapter to Spinner
        spinnerFilmes.setAdapter(aa)
    }

}
