package com.example.ba2_info_projectriverraid.entities


import android.graphics.Canvas
import android.graphics.Color
import android.graphics.Paint
import android.graphics.RectF
import com.example.ba2_info_projectriverraid.GameView

// Missile.kt

class Missile(
    missileX: Float,
    missileY: Float,
    entitiesSize: Pair<Float, Float> = Pair(10f, 30f),
    onScreen : Boolean = true,
    health : Float = 1f,
    rect : RectF = RectF(0f,0f,0f,0f),
    val view: GameView,
    val speed : Float = 10f,

    ) : Entities(missileX, missileY, entitiesSize, onScreen, health, collisionOrdinal = 5, rect = rect) {

    val missilePaint = Paint()
    init {
        missilePaint.color = Color.LTGRAY
    }
    fun update() {
        entitiesY -= speed
    }
    fun draw (canvas : Canvas){
            super.rect = RectF(
            entitiesX - entitiesSize.first,
            entitiesY - entitiesSize.second,
            entitiesX + entitiesSize.first,
            entitiesY + entitiesSize.second
        )
        canvas.drawRect(rect, missilePaint)
    }

    override fun damage(entities1: Entities, entities2: Entities){
        entities1.health -= entities2.health
    }

    override fun delete() {
        view.missiles.remove(this)
    }

}
