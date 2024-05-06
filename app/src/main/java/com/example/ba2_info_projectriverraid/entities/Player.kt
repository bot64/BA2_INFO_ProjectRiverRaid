package com.example.ba2_info_projectriverraid.entities

import android.content.Context
import android.graphics.drawable.Icon
import com.example.ba2_info_projectriverraid.Main
import android.graphics.Bitmap
import android.graphics.BitmapFactory
import com.example.ba2_info_projectriverraid.R
import com.example.ba2_info_projectriverraid.Main.DifficultyDataManager.getData

class Player(
    context: Context,
    x_pos: Float = getData().playerHome.first,
    y_pos: Float = getData().playerHome.second,
    size: Pair<Float,Float> = getData().defaultSize,
    health: Float = Main.DifficultyDataManager.getData().playerStartingHealth,
    image: Bitmap = BitmapFactory.decodeResource(context.resources, R.drawable.Player),
    override val bitmap: Bitmap= BitmapFactory.decodeResource(context.resources, R.drawable.Player)
) : Entities(x_pos, y_pos, size, health, image) {

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
            x_pos -= speed
        } else if (moveRightPressed) {
            y_pos += speed
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