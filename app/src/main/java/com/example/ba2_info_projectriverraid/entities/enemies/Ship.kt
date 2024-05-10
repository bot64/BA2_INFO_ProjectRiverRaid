package com.example.ba2_info_projectriverraid.entities.enemies
import android.graphics.Canvas
import android.graphics.Color
import android.graphics.Paint
import android.graphics.PointF
import android.graphics.RectF
import com.example.ba2_info_projectriverraid.GameView
import com.example.ba2_info_projectriverraid.entities.Entities

//Ship.kt
class Ship(
    shipX: Float,
    shipY: Float,
    shipSize: Pair<Float, Float> = Pair(70f,50f),
    health: Float = 3f,
    onScreen: Boolean = true,
    rect : RectF = RectF(0f,0f,0f,0f),
    val view: GameView
) : Enemies(shipX, shipY, shipSize, onScreen,health, collisionOrdinal = 2, rect = rect) {
    val shipPaint: Paint = Paint()
    val shipXY = PointF(entitiesX,entitiesY)
    var scrollSpeed : Float = 200f
    var speed : Float = 1f
    var isAlive : Boolean = true

    init {
        shipXY.set(view.screenWidth/2, 0f)
        val speed = 10f
        shipPaint.color = Color.BLUE
    }
    fun draw (canvas : Canvas){
        super.rect = RectF(
            entitiesX - entitiesSize.first,
            entitiesY - entitiesSize.second,
            entitiesX + entitiesSize.first,
            entitiesY + entitiesSize.second
        )
        canvas.drawRect(rect, shipPaint)
    }
    fun update(interval: Double) {
        var scroll = (interval * scrollSpeed).toFloat()
        entitiesY += scroll
        entitiesX += speed

        }
    override fun delete(){
        view.enemies.remove(this)
    }
    override fun damage(entities1: Entities, entities2: Entities){
        health -= entities2.health
    }
    override fun bounce(entities1: Entities, entities2: Entities){
        speed = -speed
    }
}

