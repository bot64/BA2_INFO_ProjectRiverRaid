package com.example.ba2_info_projectriverraid.entities

import android.graphics.Canvas
import android.graphics.Color
import android.graphics.Paint
import android.graphics.PointF
import android.graphics.RectF
import com.example.ba2_info_projectriverraid.GameView
import com.example.ba2_info_projectriverraid.entities.enemies.PerimeterObserver


interface PerimeterObservable{
    // Dynamic adding and removal of observers to the list by the target
    val observers : MutableList<PerimeterObserver>
    fun addObserver(observer: PerimeterObserver){observers.add(observer)}
    fun removeObserver(observer: PerimeterObserver){observers.remove(observer)}
}
class Player(
    entitiesX: Float,
    entitiesY: Float,
    entitiesSize: Pair<Float,Float> = Pair(40f,40f),
    onScreen: Boolean = true,
    health: Float = 0f,
    rect : RectF = RectF(0f,0f,0f,0f),
    val view: GameView,
    val speed : Float = 10f,
    val moveLeftPressed : Boolean,
    val moveRightPressed : Boolean,
    val shootPressed : Boolean,
) : Entities(entitiesX, entitiesY, entitiesSize, onScreen, health, fuel = 100f, collisionOrdinal = 1, rect = rect) {
    val playerPaint = Paint()
    var playerXY = PointF(entitiesX, entitiesY)
    init {
        val speed = data.playerSpeed
        var fuel = data.fuelOnstart
        this.entitiesSize = data.defaultSize
        this.health = data.playerStartingHealth
        playerPaint.color = Color.RED
    }
    fun draw(canvas: Canvas) {
        super.rect = RectF(
            entitiesX - entitiesSize.first,
            entitiesY - entitiesSize.second,
            entitiesX + entitiesSize.first,
            entitiesY + entitiesSize.second
        )
        canvas.drawRect(rect, playerPaint)
    }

    fun setPlayerXY(X: Float = entitiesX, Y: Float = entitiesY) {
        playerXY.set(X, Y)
    }
    fun move(left :Boolean, right : Boolean) {
        // Update the player's position based on the input states
        if (left) {
            entitiesX -= speed
        } else if (right) {
            entitiesX += speed
        }
    }
    val observers : MutableList<PerimeterObserver> = ArrayList()
    fun addObserver(observer : PerimeterObserver){observers.add(observer)}
    fun removeObserver(observer : PerimeterObserver){observers.remove(observer)}
    fun notifyObserver(){
        // Allows for observer notifications based on the target's coordinates
        if (observers.isNotEmpty()){
            observers.forEach{observer -> observer.moveOnDetection(Position(entitiesX, entitiesY))}
        }
    }
    fun sendNewPosition(newX : Float, newY : Float){
        // 'update' function with notification functionalities
        entitiesX = newX; entitiesY = newY; notifyObserver()
    }

    fun get_Fuel(): Float {
        return fuel
    }
    override fun damage(entities1: Entities, entities2: Entities){
        health -= entities2.health
    }
    override fun refuel(fuel: Float) {
        super.fuel += fuel
        if (super.fuel>=100){super.fuel = 100f}
    }

}

    // ... Other methods inherited from Entities ...
