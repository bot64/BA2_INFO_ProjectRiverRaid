package com.example.ba2_info_projectriverraid.entities

import android.graphics.Canvas
import android.graphics.Color
import android.graphics.Paint
import com.example.ba2_info_projectriverraid.GameView
import com.example.ba2_info_projectriverraid.R

class FuelTank(
    blockX: Float,
    blockY: Float,
    blockSize: Pair<Float, Float> = Pair(80f, 80f),
    health: Float = 999999f,
    onScreen: Boolean = true,
    val view: GameView,
    val fuelTankPaint: Paint = Paint()
) : Entities(blockX, blockY, blockSize, onScreen, health) {

    init {
        fuelTankPaint.color = Color.YELLOW
    }
    fun draw (canvas : Canvas){
        canvas.drawRect(
            entitiesX - entitiesSize.first,
            entitiesY - entitiesSize.second,
            entitiesX + entitiesSize.first,
            entitiesY + entitiesSize.second,
            fuelTankPaint
        )
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