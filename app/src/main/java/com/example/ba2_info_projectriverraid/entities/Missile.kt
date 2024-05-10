package com.example.ba2_info_projectriverraid.entities


import android.graphics.Canvas
import android.graphics.Color
import android.graphics.Paint
import android.graphics.PointF
import com.example.ba2_info_projectriverraid.GameView

// Missile.kt

class Missile(
    missileX: Float,
    missileY: Float,
    entitiesSize: Pair<Float, Float> = Pair(10f, 30f),
    onScreen : Boolean = true,
    health : Float = 0f,
    val missilethick: Float = 20f,
    val missileLength: Float = 50f,
    val view: GameView,
    val speed : Float = 10f,

   ) : Entities(missileX, missileY, entitiesSize, onScreen, health, collisionOrdinal = 5) {

    val missilePaint = Paint()
    var missileXY = PointF(entitiesX, entitiesY)
    init {
        missilePaint.color = Color.LTGRAY
        missilePaint.strokeWidth = missilethick
    }
    fun update() {
        entitiesY -= speed
    }
    fun draw (canvas : Canvas){
        canvas.drawRect(
            entitiesX - entitiesSize.first,
            entitiesY - entitiesSize.second,
            entitiesX + entitiesSize.first,
            entitiesY + entitiesSize.second,
            missilePaint
        )
    }

    override fun damage(entities1: Entities, entities2: Entities){
        health -= entities2.health
    }
    override fun bounce(entities1: Entities, entities2: Entities){

    }
    override fun refuel(entities1: Entities, entities2: Entities){

    }

    override fun delete() {
        view.missiles.remove(this)
    }

}
