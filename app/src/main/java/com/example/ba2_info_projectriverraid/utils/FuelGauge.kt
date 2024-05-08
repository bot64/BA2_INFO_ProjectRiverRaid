package com.example.ba2_info_projectriverraid.utils
//import android.graphics.RectF
// FuelGauge.kt
class FuelGauge(
    val fuelGaugeX: Double,
    val fuelGaugeY: Double,
    var fuelLevel: Double = 100.0 // Initial fuel level
) {
    private val uiFuelGauge : UIFuelGauge = UIFuelGauge()
    fun update_fuel() {
        // Deplete fuel slowly based on the constant in utils.Constants
        fuelLevel -= DifficultyAndData.EASY.fuelDepleteRate

        // Check if fuel is empty and trigger game over if necessary
        if (fuelLevel <= 0.0) {
            // Show game over screen
        }
        uiFuelGauge.UI_update_fuel()
    }
    fun refuel() {
        // Refill the fuel gauge to maximum capacity
        fuelLevel = 100.0
        uiFuelGauge.UI_update_fuel()
    }
    // ... Code to draw the fuel gauge on the screen ...
}
class UIFuelGauge{
    fun UI_update_fuel(){
    }
}