package com.example.robert.listafilmes

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.AdapterView
import android.widget.ArrayAdapter
import kotlinx.android.synthetic.main.activity_lista_filmes.*

class ListaFilmes : AppCompatActivity() {



    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_lista_filmes)

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

        val aa = ArrayAdapter(this, android.R.layout.simple_spinner_item, lstFilmes)

        spinnerFilmes.setAdapter(aa)

        spinnerFilmes.onItemSelectedListener = object : AdapterView.OnItemSelectedListener {
            override fun onItemSelected(parent: AdapterView<*>, view: View, position: Int, id: Long) {

                // pegando o valor do item selecionado no spinner
                val selectedItem = parent.getItemAtPosition(position).toString()

                when(selectedItem) {
                    getText(R.string.nome_sonhe_liberdade) -> {
                        txtDesc.text = getText(R.string.desc_sonhe_liberdade)
                        imgPoster.setImageResource(R.drawable.sonho_liberdade)
                    }
                    getText(R.string.nome_godfather)-> {
                        txtDesc.text = getText(R.string.desc_godfather)
                        imgPoster.setImageResource(R.drawable.godfather)
                    }
                    getText(R.string.nome_godfather_2)-> {
                        txtDesc.text = getText(R.string.desc_godfather_2)
                        imgPoster.setImageResource(R.drawable.godfather_2)
                    }
                    getText(R.string.nome_pulp_fiction)-> {
                        txtDesc.text = getText(R.string.desc_pulp_fiction)
                        imgPoster.setImageResource(R.drawable.pulp_fiction)
                    }
                    getText(R.string.nome_clube_luta)-> {
                        txtDesc.text = getText(R.string.desc_clube_luta)
                        imgPoster.setImageResource(R.drawable.clube_luta)
                    }
                    getText(R.string.nome_forrest_gump)-> {
                        txtDesc.text = getText(R.string.desc_forrest_gump)
                        imgPoster.setImageResource(R.drawable.forrest_gump)
                    }
                    getText(R.string.nome_matrix)-> {
                        txtDesc.text = getText(R.string.desc_matrix)
                        imgPoster.setImageResource(R.drawable.matrix)
                    }
                    getText(R.string.nome_vida_bela) ->{
                        txtDesc.text = getText(R.string.desc_vida_bela)
                        imgPoster.setImageResource(R.drawable.vida_bela)
                    }
                }
            }

            override fun onNothingSelected(parent: AdapterView<*>) {
                txtDesc.text = ""
                imgPoster.visibility = View.GONE
            }
        }

    }

}
