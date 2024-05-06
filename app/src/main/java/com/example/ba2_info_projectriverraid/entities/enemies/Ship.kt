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
    shipX: Float,
    shipY: Float,
    size: Pair<Float, Float>,
    health: Float = 1f,
    image: Bitmap = BitmapFactory.decodeResource(context.resources, R.drawable.ship),
    override val bitmap: Bitmap
) : Entities(context,shipX, shipY, size,health, image) {

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