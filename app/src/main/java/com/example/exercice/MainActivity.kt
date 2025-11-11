package com.example.exercice

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.exercice.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    private lateinit var flightAdapter: FlightAdapter
    private var originalFlightList = listOf<Flight>()
    private var currentFlightList = mutableListOf<Flight>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        setupFlightData()
        setupRecyclerView()
        setupClickListeners()
    }
    private fun setupFlightData() {
        originalFlightList = listOf(
            Flight("F100", "Indigo", "DEL", "BLR", "08:30", "10:45", "02h 15m", 7319, android.R.drawable.ic_dialog_map, "FLYAWAY60", true),
            Flight("F200", "Air India", "MUM", "GOI", "12:00", "13:00", "01h 00m", 4500, android.R.drawable.ic_dialog_email),
            Flight("F300", "SpiceJet", "BLR", "DEL", "14:15", "16:30", "02h 15m", 8000, android.R.drawable.ic_dialog_info, "SALE20"),
            Flight("F400", "Vistara", "DEL", "MUM", "06:00", "08:00", "02h 00m", 6200, android.R.drawable.ic_menu_send, isFreeMeal = true),
            Flight("F500", "Indigo", "HYD", "MAA", "10:00", "11:15", "01h 15m", 3500, android.R.drawable.ic_dialog_map)
        )

        currentFlightList.addAll(originalFlightList)
    }
    private fun setupRecyclerView() {
        flightAdapter = FlightAdapter(currentFlightList) { clickedFlight ->
            val intent = Intent(this, FlightDetailsActivity::class.java)
            intent.putExtra("EXTRA_FLIGHT", clickedFlight)
            startActivity(intent)
        }
        binding.rvFlights.apply {
            layoutManager = LinearLayoutManager(this@MainActivity)
            adapter = flightAdapter
        }
    }
    private fun setupClickListeners() {
        binding.btnLowToHigh.setOnClickListener {
            currentFlightList.sortBy { it.price }
            flightAdapter.notifyDataSetChanged()
        }

        binding.btnHighToLow.setOnClickListener {
            currentFlightList.sortByDescending { it.price }
            flightAdapter.notifyDataSetChanged()
        }

        binding.btnAirlineType.setOnClickListener {
            currentFlightList.sortBy { it.airlineName }
            flightAdapter.notifyDataSetChanged()
        }
    }
}