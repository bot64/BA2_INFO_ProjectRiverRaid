package com.example.ba2_info_projectriverraid.entities

import android.content.Context
import android.graphics.Bitmap
import android.graphics.BitmapFactory
import android.graphics.drawable.Icon
import com.example.ba2_info_projectriverraid.R

class Block(
    context: Context,
    blockX: Float,
    blockY: Float,
    blockSize: Pair<Float, Float> = Pair(20f, 20f),
    health: Float = 999999f,
    image: Bitmap = BitmapFactory.decodeResource(context.resources, R.drawable.block),
    override val bitmap: Bitmap
) : Entities(entitiesX, entitiesY, entitiesSize, health, image) {

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
