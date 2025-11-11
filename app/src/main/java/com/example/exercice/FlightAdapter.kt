package com.example.exercice

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.exercice.databinding.ItemFlightBinding

class FlightAdapter(
    private val flights: List<Flight>,
    private val onItemClick: (Flight) -> Unit
) : RecyclerView.Adapter<FlightAdapter.FlightViewHolder>() {

    class FlightViewHolder(val binding: ItemFlightBinding) :
        RecyclerView.ViewHolder(binding.root)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): FlightViewHolder {
        val binding = ItemFlightBinding.inflate(
            LayoutInflater.from(parent.context),
            parent,
            false
        )
        return FlightViewHolder(binding)
    }

    override fun onBindViewHolder(holder: FlightViewHolder, position: Int) {
        val flight = flights[position]

        holder.binding.ivAirlineLogo.setImageResource(flight.airlineLogoRes)
        holder.binding.tvAirlineName.text = flight.airlineName
        holder.binding.tvDepartureTime.text = flight.departureTime
        holder.binding.tvDepartureCity.text = flight.departureCity
        holder.binding.tvArrivalTime.text = flight.arrivalTime
        holder.binding.tvArrivalCity.text = flight.arrivalCity
        holder.binding.tvDuration.text = flight.duration
        holder.binding.tvPrice.text = "${flight.price}"

        if (flight.isFreeMeal) {
            holder.binding.tvFreeMeal.visibility = android.view.View.VISIBLE
        } else {
            holder.binding.tvFreeMeal.visibility = android.view.View.GONE
        }

        if (flight.promoCode != null) {
            holder.binding.tvPromoCode.visibility = android.view.View.VISIBLE
            holder.binding.tvPromoCode.text = flight.promoCode
        } else {
            holder.binding.tvPromoCode.visibility = android.view.View.GONE
        }

        holder.itemView.setOnClickListener {
            onItemClick(flight)
        }
    }

    override fun getItemCount(): Int {
        return flights.size
    }
}