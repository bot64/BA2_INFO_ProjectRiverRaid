package com.example.ba2_info_projectriverraid.entities.enemies
//this class is a version of entities specialized to manage the different types of enemies
// Needed for checkDistance
import android.graphics.RectF
import com.example.ba2_info_projectriverraid.entities.Entities
import com.example.ba2_info_projectriverraid.entities.Position
import kotlin.math.pow
import kotlin.math.sqrt

interface MovePattern{
    fun move(coordinates : Position, movePattern : Pair<Float, Float>) : Pair<Float, Float>
    }
class DefaultMovePattern : MovePattern{
    override fun move(coordinates : Position, movePattern : Pair<Float, Float>) : Pair<Float, Float>{
        return Pair(coordinates.x1 + movePattern.first, coordinates.x2 + movePattern.second)
    }
}
class CustomMovePattern(private val targetCoordinates : Position, private val movement: MovePattern)
    : MovePattern{
    // Decorator for DefaultMovePattern, adds Custom behavior with a delegating mechanism
        override fun move(coordinates: Position, movePattern: Pair<Float, Float>): Pair<Float, Float>{
            val deltaX = coordinates.x1 - targetCoordinates.x1
            val deltaY = coordinates.x2 - targetCoordinates.x2
            val customMovePattern = Pair(deltaX, deltaY)
        return movement.move(coordinates, customMovePattern)
        }
}
interface PerimeterObserver {
    fun checkDistance(targetCoordinates : Position): Boolean
    // Determines the condition for detection
    fun moveOnDetection(targetCoordinates : Position)
    // Changes the behavior to Custom on detection
}
open class Enemies(
    var enemiesX : Float,
    var enemiesY : Float,
    var size : Pair<Float, Float>,
    onScreen : Boolean = true,
    health : Float,
    collisionOrdinal : Int,
    rect : RectF
    )
    : Entities(enemiesX, enemiesY, size, onScreen, health, collisionOrdinal, rect = rect),
    PerimeterObserver{
    var movePattern: MovePattern = DefaultMovePattern()
    override fun checkDistance(targetCoordinates: Position): Boolean {
        val distance = sqrt((enemiesX - targetCoordinates.x1).pow(2)
                + (enemiesY - targetCoordinates.x2).pow(2))
        return distance < 40 // Define Perimeter/distance threshold here
    }
    override fun moveOnDetection(targetCoordinates: Position) {
        if (checkDistance(targetCoordinates)) {
            movePattern = CustomMovePattern(targetCoordinates, DefaultMovePattern())
        }
    }
    override fun delete(){

    }
    override fun damage(entities1: Entities, entities2: Entities){

    }
    override fun bounce(entities1: Entities, entities2: Entities){

    }
}
