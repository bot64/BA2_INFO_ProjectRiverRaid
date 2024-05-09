package com.example.ba2_info_projectriverraid.entities
import com.example.ba2_info_projectriverraid.MainActivity.DifficultyDataManager.getData
import android.graphics.RectF

abstract class Entities(
    var entitiesX: Float = 0f,
    var entitiesY: Float = 0f,
    var entitiesSize: Pair<Float, Float> = Pair(20.0f, 20.0f),
    var onScreen : Boolean = true,
    var health: Float
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
    companion object { // Static method for detecting collisions
        fun isColliding(entities1: Entities, entities2: Entities): Boolean {

            val boundingBox1 = RectF(
                entities1.entitiesX, entities1.entitiesY,
                entities1.entitiesX + entities1.entitiesSize.first,
                entities1.entitiesY + entities1.entitiesSize.second
            )
            val boundingBox2 = RectF(
                entities2.entitiesX, entities2.entitiesY,
                entities2.entitiesX + entities2.entitiesSize.first,
                entities2.entitiesY + entities2.entitiesSize.second
            )
            return boundingBox1.intersect(boundingBox2)
        }
    }
}
// Suggested size for entities (20f, 20f) needs adjusting
// screenWidth and screenHeight values need adjusting
