package com.example.ba2_info_projectriverraid.entities.enemies

import android.content.Context
import android.graphics.Bitmap
import android.graphics.BitmapFactory
import android.graphics.drawable.Icon
import com.example.ba2_info_projectriverraid.R
import com.example.ba2_info_projectriverraid.entities.Entities

// Ship.kt
class Ship(
    context: Context,
    x_pos: Float,
    y_pos: Float,
    size: Pair<Float, Float>,
    health: Float = 1f,
    image: Bitmap = BitmapFactory.decodeResource(context.resources, R.drawable.Ship),
    override val bitmap: Bitmap
) : Entities(x_pos, y_pos, size,health, image) {

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