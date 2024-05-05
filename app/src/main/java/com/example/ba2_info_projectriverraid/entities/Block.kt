package com.example.ba2_info_projectriverraid.entities

class Block(
    x_pos: Double,
    y_pos: Double,
    size: Double,
    image: android.graphics.drawable.Icon,
    var collision_prop: Int
) : Entities(x_pos, y_pos, size, image), BlockFunctions {

    override fun delete() {
        // Remove the block from the game
    }

    override fun pop_block() {
        // Create a new block and add it to the game
    }

    fun handle_collision() {
        // Handle the collision between the block and the player
    }

}