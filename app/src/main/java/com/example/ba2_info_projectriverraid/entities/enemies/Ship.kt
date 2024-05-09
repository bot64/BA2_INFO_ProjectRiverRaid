package com.example.ba2_info_projectriverraid.entities.enemies
import android.graphics.Canvas
import android.graphics.Color
import android.graphics.Paint
import android.graphics.PointF
import android.content.Context
import com.example.ba2_info_projectriverraid.GameView
import com.example.ba2_info_projectriverraid.R
import com.example.ba2_info_projectriverraid.entities.Entities

//Ship.kt
class Ship(
    shipX: Float,
    shipY: Float,
    shipSize: Pair<Float, Float>,
    health: Float = 1f ,
    val view: GameView,

) : Entities(shipX, shipY, shipSize,health) {
    val shipPaint: Paint = Paint()
    val shipXY = PointF(entitiesX,entitiesY)
    init {

    }
    fun handle_collision(entity: Entities) {
        // Handle collisions between the ship and other entities
    }
    fun draw (canvas : Canvas){
        canvas.drawRect(
            ,
            ,
            ,

        )
    }

    fun delete() {
        // Remove the ship from the game
    }

    fun pop_entity() {
        // Create a new ship and add it to the game
    }
    fun shot(damage : Float) {
        health -= damage
        if (health <= 0){
            delete()
            //add score implementation
        }
    }
}