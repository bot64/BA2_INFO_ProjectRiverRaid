package com.example.ba2_info_projectriverraid

import android.content.Context
import android.graphics.Canvas
import android.graphics.Color
import android.graphics.Paint
import android.util.AttributeSet
import android.view.MotionEvent
import android.view.SurfaceHolder
import android.view.SurfaceView
import android.widget.Button
import com.example.ba2_info_projectriverraid.entities.Missile
import com.example.ba2_info_projectriverraid.entities.Player
import com.google.android.material.floatingactionbutton.FloatingActionButton

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
    lateinit var thread : Thread
    val player = Player(
        0f,
        0f,
        view = this,
        moveRightPressed = moveRightPressed,
        moveLeftPressed = moveLeftPressed,
        shootPressed = shootPressed)
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
        player.entitiesX = screenWidth/2f
        player.entitiesY = screenHeight*0.8f
        val leftButton = findViewById<FloatingActionButton>(R.id.leftbutton)
        val rightButton = findViewById<FloatingActionButton>(R.id.rightbutton)
        val shootButton = findViewById<Button>(R.id.shoot)
        leftButton.setOnTouchListener { _, event ->
            when (event.action) {
                MotionEvent.ACTION_DOWN -> {
                    moveLeftPressed = true
                    true
                }
                MotionEvent.ACTION_UP -> {
                    moveLeftPressed = false
                    true
                }
                else -> false
            }
        }
        rightButton.setOnTouchListener { _, event ->
            when (event.action) {
                MotionEvent.ACTION_DOWN -> {
                    moveRightPressed = true
                    true
                }
                MotionEvent.ACTION_UP -> {
                    moveRightPressed = false
                    true
                }
                else -> false
            }
        }
        shootButton.setOnTouchListener { _, event ->
            when (event.action) {
                MotionEvent.ACTION_DOWN -> {
                    shootPressed = true
                    true
                }
                MotionEvent.ACTION_UP -> {
                    shootPressed = false
                    true
                }
                else -> false
            }
        }
    }
    fun updatePositions(elapsedTimeMS: Double) {
        val interval = elapsedTimeMS / 1000.0
        player.move()
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
    fun handleInput(event: MotionEvent) {
        // Handle input events and update the input states
        val leftButton = findViewById<FloatingActionButton>(R.id.leftbutton)
        val rightButton = findViewById<FloatingActionButton>(R.id.rightbutton)
        val shootButton = findViewById<Button>(R.id.shoot)

        if (leftButton.isPressed) {
            moveLeftPressed = true
        } else {
            moveLeftPressed = false
        }

        if (rightButton.isPressed) {
            moveRightPressed = true
        } else {
            moveRightPressed = false
        }

        if (shootButton.isPressed) {
            shootPressed = true
        } else {
            shootPressed = false
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

