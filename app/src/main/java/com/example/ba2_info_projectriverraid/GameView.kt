package com.example.ba2_info_projectriverraid

import android.content.Context
import android.graphics.Canvas
import android.graphics.Color
import android.graphics.Paint
import android.util.AttributeSet
import android.view.MotionEvent
import android.view.SurfaceHolder
import android.view.SurfaceView
import com.example.ba2_info_projectriverraid.MainActivity.DifficultyDataManager.getData
import com.example.ba2_info_projectriverraid.entities.Block
import com.example.ba2_info_projectriverraid.entities.FuelTank
import com.example.ba2_info_projectriverraid.entities.Missile
import com.example.ba2_info_projectriverraid.entities.Player
import com.example.ba2_info_projectriverraid.entities.enemies.Ship
import kotlin.random.Random

//import com.example.ba2_info_projectriverraid.entities.FuelTank
class GameView @JvmOverloads constructor (context: Context, attributes: AttributeSet? = null, defStyleAttr: Int = 0) : SurfaceView(context, attributes, defStyleAttr), SurfaceHolder.Callback, Runnable {
    lateinit var canvas: Canvas
    val backgroundPaint = Paint()
    var screenWidth = 0f
    var screenHeight = 0f
    var drawing = false
    var moveLeftPressed = false
    var moveRightPressed = false
    var shootPressed = false
    var lastMissileShotTime : Long = 0.toLong()
    lateinit var thread : Thread
    val player = Player(
        0f,
        0f,
        view = this,
        moveRightPressed = moveRightPressed,
        moveLeftPressed = moveLeftPressed,
        shootPressed = shootPressed)
    val missiles = mutableListOf<Missile>()
    val blocks = mutableListOf<Block>()
    val enemies = mutableListOf<Ship>()
    val fuelTanks = mutableListOf<FuelTank>()
    init {
        backgroundPaint.color = Color.WHITE
    }

    override fun onTouchEvent(event: MotionEvent): Boolean {
        when (event.action) {
            MotionEvent.ACTION_DOWN -> {
                // Check if the touch occurred on the left side of the screen
                if (event.x < screenWidth / 2) {
                    moveLeftPressed = true
                    shootPressed = true
                } else {
                    moveRightPressed = true
                    shootPressed = true
                }
            }
            MotionEvent.ACTION_UP -> {
                // Reset all the ...pressed values to false
                moveLeftPressed = false
                moveRightPressed = false
                shootPressed = false
            }
        }

        return true
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
        var previousFrameTime = System.currentTimeMillis()
        while (drawing) {
            val currentTime = System.currentTimeMillis()
            val elapsedTimeMS = (currentTime-previousFrameTime).toDouble()
            updatePositions(elapsedTimeMS)
            draw()
            previousFrameTime = currentTime
        }
    }

    override fun onSizeChanged(w:Int, h:Int, oldw:Int, oldh:Int) {
        super.onSizeChanged(w, h, oldw, oldh)
        screenWidth = w.toFloat()
        screenHeight = h.toFloat()
        player.entitiesX = screenWidth / 2f
        player.entitiesY = screenHeight * 0.8f
        for (i in 0 until 3) {
            enemies.add(Ship(Random.nextFloat() * screenWidth, 100f, view = this))
            blocks.add(Block(Random.nextFloat() * screenWidth, 200f, view = this))
            fuelTanks.add(FuelTank(Random.nextFloat() * screenWidth, 300f, view = this))
        }
    }
    fun updatePositions(elapsedTimeMS: Double) {
        val interval = elapsedTimeMS / 1000.0
        if (System.currentTimeMillis() - lastMissileShotTime >= 200 && shootPressed) {
            missiles.add(Missile(player.entitiesX, player.entitiesY, view = this))
            lastMissileShotTime = System.currentTimeMillis()
        }
        for (missile in missiles) {
            missile.update()
        }
        for (enemy in enemies) {
            enemy.update(interval)
        }
        for (block in blocks) {
            block.update(interval)
        }
        for (fuel in fuelTanks){
            fuel.update(interval)
        }
        for (i in ){
            for (j <= i){

            }
        }
        player.move(moveLeftPressed, moveRightPressed)
    }

    fun draw() {
        if (holder.surface.isValid) {
            canvas = holder.lockCanvas()
            canvas.drawRect(0f, 0f, canvas.width.toFloat(),
                canvas.height.toFloat(), backgroundPaint)
            for (missile in missiles) {
                missile.draw(canvas)
            }
            for (enemy in enemies) {
                enemy.draw(canvas)
            }
            for (block in blocks) {
                block.draw(canvas)
            }
            for (fuel in fuelTanks){
                fuel.draw(canvas)
            }
            player.draw(canvas)
            holder.unlockCanvasAndPost(canvas)
        }
    }
    fun handleInput(event: MotionEvent) {
        // Handle input events and update the input states
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

