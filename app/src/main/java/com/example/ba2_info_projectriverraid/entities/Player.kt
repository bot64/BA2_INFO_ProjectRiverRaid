package com.example.ba2_info_projectriverraid.entities
import android.graphics.Paint
import android.graphics.Canvas
import android.graphics.Color
import android.graphics.PointF
import com.example.ba2_info_projectriverraid.GameView
import com.example.ba2_info_projectriverraid.MainActivity.DifficultyDataManager.getData

class Player(
    playerX: Float,
    playerY: Float,
    entitiesSize: Pair<Float,Float> = Pair(40f,40f),
    onScreen: Boolean = true,
    health: Float = 0f,
    val view: GameView,
    val speed : Float = 10f,
    var fuel : Float = 100f
) : Entities(playerX, playerY, entitiesSize, onScreen, health) {
    val playerPaint = Paint()
    var playerXY = PointF(entitiesX, entitiesY)

    init {
        val speed = data.playerSpeed
        var fuel = data.fuelOnstart
        super.entitiesSize = data.defaultSize
        super.health = data.playerStartingHealth
        playerPaint.color = Color.RED
    }
    fun draw(canvas: Canvas) {
        playerPaint.strokeWidth = entitiesSize.first * 1.5f
        canvas.drawRect(
            this.entitiesX - entitiesSize.first,
            canvas.height.toFloat()*0.8f - entitiesSize.second,
            this.entitiesX + entitiesSize.first,
            canvas.height.toFloat()*0.8f + entitiesSize.second,
            playerPaint
        )
    }

    fun setPlayerXY(X: Float = entitiesX, Y: Float = entitiesY) {
        playerXY.set(X, Y)
    }


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

    fun tp(X: Float, Y: Float) {

    }

    /*fun getFuel(): Float {
        return fuel
    }*/
    /*fun handleInput(event: android.view.MotionEvent) {
    // Handle input events and update the input states
    when (event.action) {
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
    }
}*/

    // ... Other methods inherited from Entities ...

}