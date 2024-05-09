package com.example.ba2_info_projectriverraid.entities
import android.content.Context
import android.graphics.Bitmap
import android.graphics.BitmapFactory
import com.example.ba2_info_projectriverraid.GameView
import com.example.ba2_info_projectriverraid.R

class Block(
    blockX: Float,
    blockY: Float,
    blockSize: Pair<Float, Float> = Pair(80f, 80f),
    health: Float = 999999f,
    onScreen: Boolean = true,
    val view: GameView
) : Entities(blockX, blockY, blockSize, onScreen, health) {

    init {

    }

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