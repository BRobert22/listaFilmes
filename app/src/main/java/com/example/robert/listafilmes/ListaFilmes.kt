package com.example.robert.listafilmes

import android.app.Notification
import android.app.NotificationManager
import android.app.PendingIntent
import android.content.Context
import android.os.Build
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.AdapterView
import android.widget.ArrayAdapter
import kotlinx.android.synthetic.main.activity_lista_filmes.*

class ListaFilmes : AppCompatActivity() {

    private val channelId = "rober.com.ListarFilmes"
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_lista_filmes)

        carregarSpinner()
    }

    fun carregarSpinner() {

        val lstFilmes = arrayOf(
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

                when (selectedItem) {
                    getText(R.string.nome_sonhe_liberdade) -> {
                        updateMovies(getText(R.string.desc_sonhe_liberdade).toString(), R.drawable.sonho_liberdade)
                        sendNotification(getText(R.string.nome_sonhe_liberdade).toString())
                    }
                    getText(R.string.nome_godfather) -> {
                        updateMovies(getText(R.string.desc_godfather).toString(), R.drawable.godfather)
                        sendNotification(getText(R.string.nome_godfather).toString())
                    }
                    getText(R.string.nome_godfather_2) -> {
                        updateMovies(getText(R.string.desc_godfather_2).toString(), R.drawable.godfather_2)
                        sendNotification(getText(R.string.nome_godfather_2).toString())
                    }
                    getText(R.string.nome_pulp_fiction) -> {
                        updateMovies(getText(R.string.desc_pulp_fiction).toString(), R.drawable.pulp_fiction)
                        sendNotification(getText(R.string.nome_pulp_fiction).toString())
                    }
                    getText(R.string.nome_clube_luta) -> {
                        updateMovies(getText(R.string.desc_clube_luta).toString(), R.drawable.clube_luta)
                        sendNotification(getText(R.string.nome_clube_luta).toString())
                    }
                    getText(R.string.nome_forrest_gump) -> {
                        updateMovies(getText(R.string.desc_forrest_gump).toString(), R.drawable.forrest_gump)
                        sendNotification(getText(R.string.nome_forrest_gump).toString())
                    }
                    getText(R.string.nome_matrix) -> {
                        updateMovies(getText(R.string.desc_matrix).toString(), R.drawable.matrix)
                        sendNotification(getText(R.string.nome_matrix).toString())
                    }
                    getText(R.string.nome_vida_bela) -> {
                        updateMovies(getText(R.string.desc_vida_bela).toString(), R.drawable.vida_bela)
                        sendNotification(getText(R.string.nome_vida_bela).toString())
                    }
                }
            }

            override fun onNothingSelected(parent: AdapterView<*>) {
                txtDesc.text = ""
                imgPoster.visibility = View.GONE
            }
        }
    }

    fun updateMovies(strDesc: String, IDimg: Int) {
        txtDesc.text = strDesc
        imgPoster.setImageResource(IDimg)
    }

    fun sendNotification(strTitulo: String){
        val pendingIntent = PendingIntent.getActivity(this, 0, intent, 0)

        val mNotification = if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
            Notification.Builder(this, channelId)
        } else {
            Notification.Builder(this)
        }.apply {
            setContentIntent(pendingIntent)
            setSmallIcon(R.drawable.notification_icon_background)
            setAutoCancel(true)
            setContentTitle(strTitulo)
            setContentText("O filme " + strTitulo + " foi selecionado")
        }.build()
        val mNotificationId: Int = 1000
        val nManager = this.getSystemService(Context.NOTIFICATION_SERVICE) as NotificationManager
        nManager.notify(mNotificationId, mNotification)
    }
}
