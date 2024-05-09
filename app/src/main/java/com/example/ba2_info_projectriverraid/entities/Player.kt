package com.example.ba2_info_projectriverraid.entities

import android.content.Context



import android.graphics.Paint
import android.graphics.Canvas
import android.graphics.PointF
import android.graphics.BitmapFactory
import com.example.ba2_info_projectriverraid.GameView
import com.example.ba2_info_projectriverraid.MainActivity.DifficultyDataManager.getData
import com.example.ba2_info_projectriverraid.R

class Player(
    entitiesX: Float = getData().playerHome.first,
    entitiesY: Float = getData().playerHome.second,
    entitiesSize: Pair<Float,Float> = getData().defaultSize,
    health: Float = getData().playerStartingHealth,
    val view: GameView,
    val speed : Float = 0f,
    var fuel : Float = 0f
) : Entities(entitiesX, entitiesY, entitiesSize, health) {
    val playerPaint = Paint()
    init {
        val data = super.data
        val speed = data.playerSpeed
        var fuel = data.fuelOnstart
    }

    /*fun draw(canvas: Canvas) {
        playerPaint.strokeWidth = entitiesSize.first * 1.5f
        canvas.drawRect(

        )
    }*/


    var moveLeftPressed = false
    var moveRightPressed = false
    var shootPressed = false
    fun move() {
        // Update the player's position based on the input states
        if (moveLeftPressed) {
            entitiesX -= speed
        } else if (moveRightPressed) {
            entitiesX += speed
        }
    }

    fun draw(canvas: android.graphics.Canvas) {
        // Draw the player on the canvas
    }

    fun get_fuel(): Float {
        return fuel
    }

    fun handleInput(event: android.view.MotionEvent) {
        // Handle input events and update the input states
        /*when (event.action) {
            android.view.MotionEvent.ACTION_DOWN -> {
                if (event.x_Pos < screenWidth / 2) {
                    moveLeftPressed = true
                } else {
                    moveRightPressed = true
                }
                shootButtonPressed = true
            }

            android.view.MotionEvent.ACTION_UP -> {
                moveLeftPressed = false
                moveRightPressed = false
                shootButtonPressed = false
            }
        }*/
    }


    // ... Other methods inherited from Entities ...

}

