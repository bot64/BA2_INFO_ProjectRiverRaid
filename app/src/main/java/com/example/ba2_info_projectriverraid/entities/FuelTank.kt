package com.example.ba2_info_projectriverraid.entities

import android.graphics.Canvas
import android.graphics.Color
import android.graphics.Paint
import android.graphics.RectF
import com.example.ba2_info_projectriverraid.GameView

class FuelTank(
    blockX: Float,
    blockY: Float,
    blockSize: Pair<Float, Float> = Pair(50f, 80f),
    health: Float = 1f,
    onScreen: Boolean = true,
    rect : RectF = RectF(0f,0f,0f,0f),
    val view: GameView,
    val fuelTankPaint: Paint = Paint(),
    val scrollSpeed : Float = 200f
) : Entities(blockX, blockY, blockSize, onScreen, health,fuel = 30f, collisionOrdinal = 4, rect = rect) {

    init {
        fuelTankPaint.color = Color.GREEN
    }
    fun draw (canvas : Canvas){
            super.rect = RectF(
            entitiesX - entitiesSize.first,
            entitiesY - entitiesSize.second,
            entitiesX + entitiesSize.first,
            entitiesY + entitiesSize.second
        )
        canvas.drawRect(rect, fuelTankPaint)
    }
    override fun delete() {
        view.fuelTanks.remove(this)
    }
    fun update(interval : Double){
        var scroll = (interval * scrollSpeed).toFloat()
        entitiesY += scroll
    }
    override fun damage(entities1: Entities, entities2: Entities){
        health -= entities2.health
    }
    override fun bounce(entities1: Entities, entities2: Entities){

    }
    override fun refuel(fuel : Float){
        super.fuel -= 100f-fuel
    }

}