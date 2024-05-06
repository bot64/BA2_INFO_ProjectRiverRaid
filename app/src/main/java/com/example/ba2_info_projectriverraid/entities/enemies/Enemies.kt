package com.example.ba2_info_projectriverraid.entities.enemies

import kotlin.math.sqrt
import kotlin.math.pow
// Needed for checkDistance
import android.content.Context
import android.graphics.Bitmap
import com.example.ba2_info_projectriverraid.entities.Entities
import com.example.ba2_info_projectriverraid.entities.Position

interface MovePattern{
    fun move(coordinates : Position, movePattern : Pair<Float, Float>) : Pair<Float, Float>
    }
class DefaultMovePattern : MovePattern{
    override fun move(coordinates : Position, movePattern : Pair<Float, Float>) : Pair<Float, Float>{
        return Pair(coordinates.x1 + movePattern.first, coordinates.x2 + movePattern.second)
    }
}
interface PerimeterObserver {
    fun checkDistance(targetCoordinates : Position): Boolean
    fun moveOnDetection(targetCoordinates : Position)
    fun add(observer : MutableList<PerimeterObserver>)
}
class CustomMovePattern(private val targetCoordinates : Position) : MovePattern{
    override fun move(coordinates : Position, movePattern : Pair<Float, Float>) : Pair<Float, Float>{
        // todo : Custom MovePattern logic
        return Pair(coordinates.x1 + movePattern.first, coordinates.x2 + movePattern.second)
    }
}
open class Enemies(
    context : Context,
    var enemiesX : Float,
    var enemiesY : Float,
    var enemiesSize : Pair<Float, Float>,
    var enemiesHealth : Float,
    val enemiesBitmap : Bitmap?)
    : Entities(context,enemiesX, enemiesY, enemiesSize,enemiesHealth, enemiesBitmap),
    PerimeterObserver{
    var movePattern: MovePattern = DefaultMovePattern()
    override fun moveOnDetection(targetCoordinates: Position) {
        if (checkDistance(targetCoordinates)) {
            movePattern = CustomMovePattern(targetCoordinates)
        }
    }
    override fun checkDistance(targetCoordinates: Position): Boolean {
        val distance = sqrt((enemiesX - targetCoordinates.x1).pow(2)
                + (enemiesY - targetCoordinates.x2).pow(2))
        return distance < 40 // Define threshold value here
    }
    override fun add(observer : MutableList<PerimeterObserver>){
        //todo
    }
}
