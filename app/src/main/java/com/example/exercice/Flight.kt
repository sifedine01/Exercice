package com.example.exercice

import java.io.Serializable

data class Flight(
    val id: String,
    val airlineName: String,
    val departureCity: String,
    val arrivalCity: String,
    val departureTime: String,
    val arrivalTime: String,
    val duration: String,
    val price: Int,
    val airlineLogoRes: Int,
    val promoCode: String? = null,
    val isFreeMeal: Boolean = false
) : Serializable