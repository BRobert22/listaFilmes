package com.example.robert.listafilmes

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.widget.ArrayAdapter
import kotlinx.android.synthetic.main.activity_lista_filmes.*

class ListaFilmes : AppCompatActivity() {

    var lstFilmes = arrayOf(
        getText(R.string.nome_sonhe_liberdade),
        getText(R.string.nome_godfather),
        getText(R.string.nome_godfather_2),
        getText(R.string.nome_pulp_fiction),
        getText(R.string.nome_clube_luta),
        getText(R.string.nome_forrest_gump),
        getText(R.string.nome_matrix),
        getText(R.string.nome_vida_bela)
    )

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_lista_filmes)

        // Create an ArrayAdapter using a simple spinner layout and languages array
        val aa = ArrayAdapter(this, android.R.layout.simple_spinner_item, lstFilmes)
        // Set layout to use when the list of choices appear
        aa.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
        // Set Adapter to Spinner
        spinnerFilmes.setAdapter(aa)

    }

}
