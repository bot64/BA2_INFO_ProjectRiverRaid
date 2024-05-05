package com.example.ba2_info_projectriverraid.entities
import kotlin.random.Random
import android.graphics.drawable.Drawable

abstract class Entities (var x : Float, var y : Float, var size : Pair<Float,Float>, var image : Drawable){
    fun getPosition() : Pair<Float, Float> {
        return Pair(x, y)
    }
    fun outOfBounds(screenWidth : Int, screenHeight : Int) : Boolean {
        return (x < 0 || x + size.first > screenWidth || y < 0 || y + size.second > screenHeight)
    }
    fun remove(screenWidth : Int, screenHeight : Int, entities : MutableList<Entities>) {
        // Garbage collector based on outOfBounds()
        val entitiesToRemove = mutableListOf<Entities>()
        for (entity in entities){
            if (entity.outOfBounds(screenWidth, screenHeight)) {
                entitiesToRemove.add(entity)
            }
        }
        entities.removeAll(entitiesToRemove)
    }
    fun isShot(missileX : Float, missileY : Float, missileSize : Pair<Float,Float>) : Boolean {
        return x - size.first / 2 < missileX + missileSize.first / 2 &&
                x + size.first / 2 > missileX - missileSize.first / 2 &&
                y - size.second / 2 < missileY + missileSize.second / 2 &&
                y + size.second / 2 > missileY - missileSize.second / 2
    }
    protected fun createEnemies(numEnemies : Int, entities : MutableList<Entities>, screenWidth : Int, screenHeight : Int) {
        // Creates [numEnemies] 'enemies' objects at randomized (x,y) values
        repeat(numEnemies) {
            val enemy = Enemies(Random.nextFloat()*screenWidth, Random.nextFloat()*screenHeight, Pair(20f,20f), enemyImage)
            enemy.movePattern = CustomMovePattern() // Set CustomMovePattern in the Enemies subclass
            entities.add(enemy)
        }
    }
    protected fun createBlocks(numBlocks : Int, entities : MutableList<Entities>, screenWidth : Int, screenHeight : Int) {
        // Creates [numBlocks] 'block' objects at randomized (x,y) values
        repeat(numBlocks){
            val block = Blocks(Random.nextFloat()*screenWidth, Random.nextFloat()*screenHeight, Pair(20f,20f), blockImage)
            entities.add(block)
        }
    }
    protected fun createFuelTanks(numFuelTanks : Int, entities : MutableList<Entities>, screenWidth : Int, screenHeight : Int) {
        // Creates [numFuelTanks] 'fuel_tank' objects at randomized (x,y) values
        repeat(numFuelTanks){
            val fuelTank = FuelTanks(Random.nextFloat()*screenWidth, Random.nextFloat()*screenHeight, Pair(20f,20f), fueltankImage)
            entities.add(fuelTank)
        }
    }
}
// Suggested size for entities (20f, 20f) needs adjusting
// screenWidth and screenHeight values need adjusting
