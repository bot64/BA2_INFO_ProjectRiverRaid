package com.example.ba2_info_projectriverraid.entities

import android.graphics.drawable.Icon
import com.example.ba2_info_projectriverraid.Main

class Player(
    x_pos: Float,
    y_pos: Float,
    size: Pair<Float,Float>,
    health: Float = Main.DifficultyDataManager.getData().playerStartingHealth,
    image: Icon
) : Entities(x_pos, y_pos, size, health, image) {

    // Player-specific properties and methods
    var speed: Float = 5.0f
    var fuel: Float = 100.0f

    // Input states
    private var moveLeftPressed = false
    private var moveRightPressed = false
    private var shootButtonPressed = false

    init {
        val (x, y) = data.playerHome
        this.x_pos = x
        this.y_pos = y
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

    fun shoot() {
        // Create a new missile and add it to the game if the shoot button is pressed
        if (shootButtonPressed) {
            Missile.shoot(this)
        }
    }

    // ... Other methods inherited from Entities ...

}