package com.example.ba2_info_projectriverraid.entities

import android.content.Context
import android.graphics.Bitmap
import com.example.ba2_info_projectriverraid.Main
import android.graphics.BitmapFactory
import com.example.ba2_info_projectriverraid.R
import com.example.ba2_info_projectriverraid.Main.DifficultyDataManager.getData

class Player(
    context: Context,
    entitiesX: Float = getData().playerHome.first,
    entitiesY: Float = getData().playerHome.second,
    entitiesSize: Pair<Float,Float> = getData().defaultSize,
    health: Float = Main.DifficultyDataManager.getData().playerStartingHealth,
    bitmap: Bitmap = BitmapFactory.decodeResource(context.resources, R.drawable.player)?.let {
        it
    } ?: throw IllegalArgumentException("Bitmap cannot be null")
    ) : Entities(context,entitiesX, entitiesY, entitiesSize, health, bitmap) {
    // Player-specific properties and methods
    var speed: Float = 5.0f
    var fuel: Float = 100.0f



    // Input states
    private var moveLeftPressed = false
    private var moveRightPressed = false
    private var shootButtonPressed = false

    init {
        speed = data.playerSpeed
        fuel = data.fuelOnstart

    }

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
