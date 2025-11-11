package com.example.exercice

import android.os.Bundle
import android.widget.Button
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity
import com.example.exercice.databinding.ActivityFlightDesignBinding

class FlightDetailsActivity : AppCompatActivity() {

    private lateinit var binding: ActivityFlightDesignBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityFlightDesignBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val flight = intent.getSerializableExtra("EXTRA_FLIGHT") as? Flight

        if (flight != null) {
            bindFlightData(flight)
        }
        binding.btnBack.setOnClickListener {
            finish()
        }

        binding.btnDownloadTicket.setOnClickListener {
            showSuccessDialog()
        }
    }

    private fun bindFlightData(flight: Flight) {
        binding.ivAirlineLogo.setImageResource(flight.airlineLogoRes)
        binding.tvDelCode.text = flight.departureCity
        binding.tvDelAirport.text = getAirportName(flight.departureCity)
        binding.tvBlrCode.text = flight.arrivalCity
        binding.tvBlrAirport.text = getAirportName(flight.arrivalCity)
        binding.tvDuration.text = flight.duration
        binding.tvFlightCode.text = flight.id
        binding.tvBoardingTime.text = flight.departureTime
        binding.tvDate.text = "20 December 2022"
        binding.tvPassenger.text = "01 Adult"
        binding.tvPassengerName.text = "Shreya Kumar"
        binding.tvFlightType.text = "Economy"
        binding.tvGate.text = "A5"
        binding.tvTerminal.text = "T2"
        binding.tvSeat.text = "A5"
    }
    private fun getAirportName(cityCode: String): String {
        return when (cityCode) {
            "DEL" -> "Delhi International Airport"
            "BLR" -> "Bengaluru Airport India"
            "MUM" -> "Mumbai Airport"
            "GOI" -> "Goa Airport"
            "HYD" -> "Hyderabad Airport"
            "MAA" -> "Chennai Airport"
            else -> "Airport"
        }
    }

    private fun showSuccessDialog() {
        val dialogView = layoutInflater.inflate(R.layout.dialog_success, null)
        val builder = AlertDialog.Builder(this)
            .setView(dialogView)

        val dialog = builder.create()

        dialog.window?.setBackgroundDrawableResource(android.R.color.transparent)

        val btnOk = dialogView.findViewById<Button>(R.id.btn_ok)
        btnOk.setOnClickListener {
            dialog.dismiss()
        }
        dialog.show()
    }
}