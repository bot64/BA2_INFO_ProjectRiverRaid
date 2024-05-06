package com.example.ba2_info_projectriverraid.entities
import kotlin.random.Random
import android.graphics.drawable.Icon
import com.example.ba2_info_projectriverraid.Main
import com.example.ba2_info_projectriverraid.entities.enemies.Ship


abstract class Entities(
    var x_pos: Float,
    var y_pos: Float,
    var size: Pair<Float, Float> = Pair(20.0f, 20.0f),
    var health: Float,
    var image: Icon){
    val data = Main.DifficultyDataManager.getData()
    fun getPosition() : Pair<Float, Float> {
        return Pair(x_pos, y_pos)
    }
    fun isOutOfBounds(screenWidth : Int, screenHeight : Int) : Boolean {
        return (x_pos < 0 || x_pos + size.first > screenWidth || y_pos < 0 || y_pos + size.second > screenHeight)
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
        return x_pos - size.first / 2 < missileX + missileSize.first / 2 &&
                x_pos + size.first / 2 > missileX - missileSize.first / 2 &&
                y_pos - size.second / 2 < missileY + missileSize.second / 2 &&
                y_pos + size.second / 2 > missileY - missileSize.second / 2
    }
    protected fun createEnemies(numEnemies : Int, entities : MutableList<Entities>, screenWidth : Int, screenHeight : Int) {
        // Creates [numEnemies] 'enemies' objects at randomized (x_pos,y_pos) values
        repeat(numEnemies) {
            val enemy = Ship(Random.nextFloat()*screenWidth, Random.nextFloat()*screenHeight, Pair(20f,20f))
            entities.add(enemy)
        }
    }
    protected fun createBlocks(numBlocks : Int, entities : MutableList<Entities>, screenWidth : Int, screenHeight : Int) {
        // Creates [numBlocks] 'block' objects at randomized (x_pos,y_pos) values
        repeat(numBlocks){
            val block = Block(
                Random.nextFloat() * screenWidth,
                Random.nextFloat() * screenHeight
            )
            entities.add(block)
        }
    }
    protected fun createFuelTanks(numFuelTanks : Int, entities : MutableList<Entities>, screenWidth : Int, screenHeight : Int) {
        // Creates [numFuelTanks] 'fuel_tank' objects at randomized (x_pos,y_pos) values
        repeat(numFuelTanks){
            val fuelTank = FuelTank(
                Random.nextFloat()*screenWidth,
                Random.nextFloat()*screenHeight)
            entities.add(fuelTank)
        }
    }
}
// Suggested size for entities (20f, 20f) needs adjusting
// screenWidth and screenHeight values need adjusting
