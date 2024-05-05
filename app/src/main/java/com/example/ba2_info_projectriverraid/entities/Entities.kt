package com.example.ba2_info_projectriverraid.entities

import android.graphics.drawable.Icon

// Entities.kt
abstract class Entities(
    var x_pos: Double,
    var y_pos: Double,
    var size: Double,
    var image: Icon
) {

    fun getposition(): List<Double> {
        return listOf(x_pos, y_pos)
    }

    fun outofbound(): Boolean {
        // Check if the entity is outside the game boundaries
        return false
    }

    abstract fun shot() {
        // Handle the entity being shot
    }

    abstract fun delete()

    abstract fun pop_entity()

}

// Enemy-specific functions
interface EnemyFunctions {
    fun create_enemies()
    fun pop_ennemies()
    fun update_x()
}

// Block-specific functions
interface BlockFunctions {
    fun create_blocks()
    fun pop_block()
}

// FuelTank-specific functions
interface FuelTankFunctions {
    fun create_fuel_tanks()
    fun pop_fuel_tank()
}