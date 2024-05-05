package com.example.ba2_info_projectriverraid.entities.enemies

import com.example.ba2_info_projectriverraid.entities.Entities

// Ship.kt
class Ship(
    x_pos: Double,
    y_pos: Double,
    size: Double,
    image: android.graphics.drawable.Icon
) : Entities(x_pos, y_pos, size, image) {

    // Ship-specific properties and methods

    fun handle_collision(entity: Entities) {
        // Handle collisions between the ship and other entities
    }

    override fun delete() {
        // Remove the ship from the game
    }

    override fun pop_entity() {
        // Create a new ship and add it to the game
    }
    fun shot() {
        // Create a function for what happens when the entity is shot
        }
    }