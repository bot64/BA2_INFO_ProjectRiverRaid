package com.example.ba2_info_projectriverraid.entities

abstract class Player(
    x_pos: Double,
    y_pos: Double,
    size: Double,
    image: android.graphics.drawable.Icon
) : Entities(x_pos, y_pos, size, image) {

    // Player-specific properties and methods
    var speed: Double = 5.0
    var fuel: Double = 100.0

    // Input states
    private var moveLeftPressed = false
    private var moveRightPressed = false
    private var shootButtonPressed = false

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

    fun get_fuel(): Double {
        return fuel
    }

    fun handleInput(event: android.view.MotionEvent) {
        // Handle input events and update the input states
        /*when (event.action) {
            android.view.MotionEvent.ACTION_DOWN -> {
                if (event.x < screenWidth / 2) {
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
            // ... code to create and add a new missile ...
        }
    }

    // ... Other methods inherited from Entities ...

}