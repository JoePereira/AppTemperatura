package br.com.apptemperatura

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.SeekBar
import android.widget.TextView
import kotlin.math.round

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
//Identificar elementos pelos findViewById
        val seekBarTemperatura = findViewById<SeekBar>(R.id.seekBarTemperatura)

        val textViewCelsius = findViewById<TextView>(R.id.textViewCelsius)
        val textViewFahrenheit = findViewById<TextView>(R.id.textViewFahrenheit)


        //Valor inicial da seekBar
        seekBarTemperatura.progress = 0
        atualizarTemperaturas(0, textViewCelsius, textViewFahrenheit)


        seekBarTemperatura.setOnSeekBarChangeListener(object: SeekBar.OnSeekBarChangeListener {
            override fun onProgressChanged(seekBar: SeekBar?, progress: Int, fromUser: Boolean) {
                atualizarTemperaturas(progress, textViewCelsius, textViewFahrenheit)
            }

            override fun onStartTrackingTouch(seekBar: SeekBar?) {}

            override fun onStopTrackingTouch(seekBar: SeekBar?) {}
        })

    }

    private fun atualizarTemperaturas(progress: Int, textViewCelsius: TextView, textViewFahrenheit: TextView){
        val temperaturaCelsius = (progress).toDouble()

        val temperaturaFahrennheit =  (temperaturaCelsius * 9/5) + 32

        val temperaturaCelsiusArredondada = round(temperaturaCelsius * 10) / 10
        val temperaturaFahrenheitArredondada = round(temperaturaFahrennheit * 10) / 10

        textViewCelsius.text = "$temperaturaCelsiusArredondada °C"
        textViewFahrenheit.text = "$temperaturaFahrenheitArredondada °F"
    }
}