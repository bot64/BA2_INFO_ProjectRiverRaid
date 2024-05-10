package com.example.ba2_info_projectriverraid.entities


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

    val view: GameView,
    val speed : Float = 0f,

   ) : Entities(missileX, missileY, entitiesSize, onScreen, health) {

    val missilePaint = Paint()
    var missileXY = PointF(entitiesX, entitiesY)

    fun shoot(player: Player) {
        entitiesX = player.entitiesX
        entitiesY = player.entitiesY - entitiesSize.second
    }
    fun update() {
        entitiesY += speed
    }

    fun outofbound(): Boolean {
        // Check if the missile is outside the game boundaries
        return false
    }

    fun collide(entity: Entities) {
        // Handle collisions between the missile and other entities
    }

    fun delete() {
        // Remove the missile from the game
    }

}
