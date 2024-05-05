package com.example.ba2_info_projectriverraid.entities.enemies

import android.graphics.drawable.Icon
import com.example.ba2_info_projectriverraid.entities.Entities

// Ship.kt
class Ship(
    x_pos: Float,
    y_pos: Float,
    size: Pair<Float, Float>,
    image: Icon
) : Entities(x_pos, y_pos, size, image) {

    // Ship-specific properties and methods

    fun handle_collision(entity: Entities) {
        // Handle collisions between the ship and other entities
    }

    fun delete() {
        // Remove the ship from the game
    }

    fun pop_entity() {
        // Create a new ship and add it to the game
    }
    fun shot() {
        // Create a function for what happens when the entity is shot
        }
    }