package com.example.ba2_info_projectriverraid.utils

// FuelGauge.kt
class FuelGauge(
    val pos_x: Double,
    val pos_y: Double,
    var pos: Double = 100.0 // Initial fuel level
) {

    fun update_fuel() {
        // Deplete fuel slowly based on the constant in utils.Constants
        pos -= DifficultyAndData.EASY.fuelDepleteRate

        // Check if fuel is empty and trigger game over if necessary
        if (pos <= 0.0) {
            // Show game over screen
        }
    }

    fun refuel() {
        // Refill the fuel gauge to maximum capacity
        pos = 100.0
    }

    // ... Code to draw the fuel gauge on the screen ...

}