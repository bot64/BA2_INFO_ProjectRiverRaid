package com.example.ba2_info_projectriverraid.entities
import android.graphics.RectF
import com.example.ba2_info_projectriverraid.MainActivity.DifficultyDataManager.getData
//abstract
data class Position(val x1: Float, val x2: Float)
abstract class Entities(
    var entitiesX: Float = 0f,
    var entitiesY: Float = 0f,
    var entitiesSize: Pair<Float, Float> = Pair(20.0f, 20.0f),
    var onScreen : Boolean = true,
    var health: Float,
    val collisionOrdinal: Int,
    var fuel : Float = 1f,
    var rect: RectF = RectF(0f,0f,0f,0f)
){
    val data = getData()
    fun getPosition() : Pair<Float, Float> {
        return Pair(entitiesX, entitiesY)
    }
    fun isOutOfBounds(screenWidth : Int, screenHeight : Int) : Boolean {
        return (entitiesX < 0 || entitiesY + entitiesSize.first > screenWidth || entitiesY < 0 || entitiesY + entitiesSize.second > screenHeight)
    }
    fun remove(screenWidth : Int, screenHeight : Int, entities : MutableList<Entities>) {
        // Garbage collector based on outOfBounds()
        val entitiesToRemove = mutableListOf<Entities>()
        for (entity in entities){
            if (entity.isOutOfBounds(screenWidth, screenHeight)) {
                entitiesToRemove.add(entity)
            }
        }
        entities.removeAll(entitiesToRemove)
    }
    fun isShot(missileX : Float, missileY : Float, missileSize : Pair<Float,Float>) : Boolean {
        return entitiesX - entitiesSize.first / 2 < missileX + missileSize.first / 2 &&
                entitiesX + entitiesSize.first / 2 > missileX - missileSize.first / 2 &&
                entitiesY - entitiesSize.second / 2 < missileY + missileSize.second / 2 &&
                entitiesY + entitiesSize.second / 2 > missileY - missileSize.second / 2
    }
    open fun damage(entities1: Entities, entities2: Entities){

    }
    open fun bounce(entities1: Entities, entities2: Entities){

    }
    open fun refuel(fuel: Float){

    }
    fun intersect(rect1: RectF, rect2: RectF) : Boolean{
        return rect1.intersect(rect2)
    }
    open fun delete(){

    }
    companion object { // Static method for detecting collisions
        fun isColliding(entities1: Entities, entities2: Entities): Boolean {
            return entities1.rect.intersect(entities2.rect)
        }
    }
}
// Suggested size for entities (20f, 20f) needs adjusting
// screenWidth and screenHeight values need adjusting
