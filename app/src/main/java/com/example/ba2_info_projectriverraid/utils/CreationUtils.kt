package com.example.ba2_info_projectriverraid
import kotlin.random.Random
import com.example.ba2_info_projectriverraid.entities.Block
import com.example.ba2_info_projectriverraid.entities.Entities
import com.example.ba2_info_projectriverraid.entities.FuelTank
import com.example.ba2_info_projectriverraid.entities.enemies.Ship

object CreationUtils { // Singleton object with global access in GameView and GameThread for utilities
    sealed class EntityType{
        data object Enemy : EntityType()
        data object Block : EntityType()
        data object FuelTank : EntityType()
    }
    fun createEntities(numEntities : Int, entities : MutableList<Entities>,
                       screenWidth : Float, screenHeight : Float, type : EntityType, gameView : GameView){
        repeat(numEntities){
            val newEntity = when(type){
                EntityType.Enemy -> Ship(Random.nextFloat()*screenWidth, Random.nextFloat()*screenHeight, view = gameView)
                EntityType.Block -> Block(Random.nextFloat()*screenWidth, Random.nextFloat()*screenHeight, view = gameView)
                EntityType.FuelTank -> FuelTank(Random.nextFloat()*screenWidth, Random.nextFloat()*screenHeight, view = gameView)
                else -> throw IllegalArgumentException("Invalid Entity Type")
            }
            if (entities.none{Entities.isColliding(newEntity, it)}) {entities.add(newEntity)}
        }
    }
}
