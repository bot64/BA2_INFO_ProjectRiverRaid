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
import com.example.ba2_info_projectriverraid.entities.Missile

import android.app.Activity
import android.util.Log
import com.example.ba2_info_projectriverraid.R
//import com.example.ba2_info_projectriverraid.entities.Block
//import com.example.ba2_info_projectriverraid.entities.Entities
//import com.example.ba2_info_projectriverraid.entities.FuelTank
//import com.example.ba2_info_projectriverraid.entities.enemies.Ship

class GameView @JvmOverloads constructor (context: Context, attributes: AttributeSet? = null, defStyleAttr: Int = 0) : SurfaceView(context, attributes, defStyleAttr), SurfaceHolder.Callback, Runnable {
    lateinit var canvas: Canvas
    val backgroundPaint = Paint()
    var screenWidth = 0f
    var screenHeight = 0f
    var drawing = false
    lateinit var thread : Thread
    val player = Player(0f, 0f, view = this)
    val missile = Missile(player.entitiesX,player.entitiesY, view = this)

    init {
        backgroundPaint.color = Color.WHITE
    }

    fun pause() {
        drawing = false
        thread.join()
    }
    fun resume() {
        drawing = true
        thread = Thread(this)
        thread.start()
    }
    override fun run() {
        while (drawing) {
            draw()
        }
    }

    override fun onSizeChanged(w:Int, h:Int, oldw:Int, oldh:Int) {
        super.onSizeChanged(w, h, oldw, oldh)
        screenWidth = w.toFloat()
        screenHeight = h.toFloat()
        player.entitiesX = screenWidth/2f
        player.entitiesY = screenHeight*0.8f
    }


    fun draw() {
        if (holder.surface.isValid) {
            canvas = holder.lockCanvas()
            canvas.drawRect(0f, 0f, canvas.width.toFloat(),
                canvas.height.toFloat(), backgroundPaint)
            player.draw(canvas)
            holder.unlockCanvasAndPost(canvas)
        }
    }

    override fun surfaceChanged(holder: SurfaceHolder, format: Int, screenWidth: Int, screenHeight: Int) {}

    override fun surfaceCreated(holder: SurfaceHolder) {
    }




    override fun surfaceDestroyed(holder: SurfaceHolder) {}
    /*private fun createEnemies(numEnemies : Int, entities : MutableList<Entities>, screenWidth : Int, screenHeight : Int) {
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
    }*/
}

