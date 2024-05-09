package com.example.ba2_info_projectriverraid.entities
import android.graphics.Paint
import android.graphics.Canvas
import android.graphics.Color
import android.graphics.PointF
import com.example.ba2_info_projectriverraid.GameView
import com.example.ba2_info_projectriverraid.entities.enemies.PerimeterObserver
import com.example.ba2_info_projectriverraid.MainActivity.DifficultyDataManager.getData

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
    val view: GameView,
    val speed : Float = 10f,
    var fuel : Float = 100f
) : Entities(entitiesX, entitiesY, entitiesSize, onScreen, health) {
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