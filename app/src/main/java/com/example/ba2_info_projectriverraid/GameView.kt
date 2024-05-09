package com.example.ba2_info_projectriverraid

import kotlin.random.Random
import android.content.Context
import android.graphics.Canvas
import android.graphics.Color
import android.graphics.Paint
import android.util.AttributeSet
import android.view.SurfaceHolder
import android.view.SurfaceView
import com.example.ba2_info_projectriverraid.entities.Player
import com.example.ba2_info_projectriverraid.customviews.TopView
import com.example.ba2_info_projectriverraid.customviews.BotView
import android.app.Activity
import com.example.ba2_info_projectriverraid.R
import com.example.ba2_info_projectriverraid.entities.Block
import com.example.ba2_info_projectriverraid.entities.Entities
import com.example.ba2_info_projectriverraid.entities.FuelTank
import com.example.ba2_info_projectriverraid.entities.enemies.Ship

class GameView @JvmOverloads constructor (context: Context, attrs: AttributeSet) : SurfaceView(context, attrs) , SurfaceHolder.Callback {

    private val player = Player(context)

    val runnable = object : Runnable {
        override fun run() {
            while (running) {
                val canvas = holder.lockCanvas()
                canvas.drawColor(Color.WHITE) // Set the background color to white
                player.bitmap?.let { canvas.drawBitmap(it, player.entitiesX, player.entitiesY, null) }
                holder.unlockCanvasAndPost(canvas)
            }
        }
    }

    private var thread: Thread? = null
    private var running = false


    init {
        holder.addCallback(this)
        player.entitiesX = width / 2f // Set the player's initial x position
        player.entitiesY = height / 2f // Set the player's initial y position
    }

    override fun surfaceCreated(holder: SurfaceHolder) {
        running = true
        thread = Thread(runnable)
        thread?.start()
    }

    override fun surfaceChanged(holder: SurfaceHolder, format: Int, width: Int, height: Int) {
        var screenWidth = width
        var screenHeight = height

    }

    override fun surfaceDestroyed(holder: SurfaceHolder) {
        running = false
        thread?.join()
    }
    private fun createEnemies(numEnemies : Int, entities : MutableList<Entities>, screenWidth : Int, screenHeight : Int) {
        //Creates [numEnemies] 'enemies' objects at randomized (entitiesX,entitiesY) values
        repeat(numEnemies) {
            val enemy = Ship(context,Random.nextFloat()*screenWidth, Random.nextFloat()*screenHeight, Pair(20f,20f), 1f)
            entities.add(enemy)
        }
    }
    private fun createBlocks(numBlocks : Int, entities : MutableList<Entities>, screenWidth : Int, screenHeight : Int) {
        // Creates [numBlocks] 'block' objects at randomized (entitiesX,entitiesY) values
        repeat(numBlocks){
            val block = Block(context,Random.nextFloat() * screenWidth,Random.nextFloat() * screenHeight)
            entities.add(block)
        }
    }

    private fun createFuelTanks(numFuelTanks : Int, entities : MutableList<Entities>, screenWidth : Int, screenHeight : Int) {
        // Creates [numFuelTanks] 'fuel_tank' objects at randomized (entitiesX,entitiesY) values
        repeat(numFuelTanks){
            val fuelTank = FuelTank(context, Random.nextFloat()*screenWidth,Random.nextFloat()*screenHeight,Pair(20f,20f))
        }
    }
}
