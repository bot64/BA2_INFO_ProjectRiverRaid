package com.example.ba2_info_projectriverraid.entities

import android.graphics.drawable.Icon

abstract class Block(
    x_pos: Float,
    y_pos: Double,
    size: Double,
    image: Icon,
    var collision_prop: Int
) : Entities(x_pos, y_pos, size, image) {

    fun delete() {
        // Remove the block from the game
    }

    fun pop_block() {
        // Create a new block and add it to the game
    }

    fun handle_collision() {
        // Handle the collision between the block and the player
    }

}