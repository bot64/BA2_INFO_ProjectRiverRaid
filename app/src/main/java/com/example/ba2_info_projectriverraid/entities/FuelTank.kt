package com.example.ba2_info_projectriverraid.entities

import android.graphics.Canvas
import android.graphics.Color
import android.graphics.Paint
import com.example.ba2_info_projectriverraid.GameView

class FuelTank(
    blockX: Float,
    blockY: Float,
    blockSize: Pair<Float, Float> = Pair(50f, 80f),
    health: Float = 1f,
    onScreen: Boolean = true,
    val view: GameView,
    val fuelTankPaint: Paint = Paint(),
    val scrollSpeed : Float = 200f
) : Entities(blockX, blockY, blockSize, onScreen, health) {

    init {
        fuelTankPaint.color = Color.GREEN
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
        view.fuelTanks.remove(this)
    }
    fun update(interval : Double){
        var scroll = (interval * scrollSpeed).toFloat()
        entitiesY += scroll
    }

    fun pop_block() {
        // Create a new block and add it to the game
    }

    fun handle_collision() {
        // Handle the collision between the block and the player
    }

}