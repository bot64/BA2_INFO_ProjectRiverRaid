package com.example.ba2_info_projectriverraid.entities
import com.example.ba2_info_projectriverraid.MainActivity.DifficultyDataManager.getData


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
}
// Suggested size for entities (20f, 20f) needs adjusting
// screenWidth and screenHeight values need adjusting
