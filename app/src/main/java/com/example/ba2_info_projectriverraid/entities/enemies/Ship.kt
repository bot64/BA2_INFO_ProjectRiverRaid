package com.example.ba2_info_projectriverraid.entities.enemies
import android.graphics.Canvas
import android.graphics.Color
import android.graphics.Paint
import android.graphics.PointF
import android.content.Context
import com.example.ba2_info_projectriverraid.GameView
import com.example.ba2_info_projectriverraid.R
import com.example.ba2_info_projectriverraid.entities.Entities

//Ship.kt teub
class Ship(
    shipX: Float,
    shipY: Float,
    shipSize: Pair<Float, Float> = Pair(70f,50f),
    health: Float = 3f,
    onScreen: Boolean = true,
    val view: GameView
) : Enemies(shipX, shipY, shipSize, onScreen,health) {
    val shipPaint: Paint = Paint()
    val shipXY = PointF(entitiesX,entitiesY)
    init {
        shipXY.set(view.screenWidth/2, 0f)
        val speed = 10
        shipPaint.color = Color.BLUE
    }
    fun handle_collision(entity: Entities) {
        // Handle collisions between the ship and other entities
    }
    fun draw (canvas : Canvas){
        update()
        canvas.drawRect(
            entitiesX - entitiesSize.first,
            entitiesY - entitiesSize.second,
            entitiesX + entitiesSize.first,
            entitiesY + entitiesSize.second,
            shipPaint
        )
    }

    fun delete() {
        // Remove the ship from the game
    }
    fun update(){

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