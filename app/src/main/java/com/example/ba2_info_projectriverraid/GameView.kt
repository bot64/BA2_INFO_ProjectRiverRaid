package com.example.ba2_info_projectriverraid

import android.content.Context
import android.graphics.Canvas
import android.graphics.Color
import android.graphics.Paint
import android.util.AttributeSet
import android.view.MotionEvent
import android.view.SurfaceHolder
import android.view.SurfaceView
import com.example.ba2_info_projectriverraid.CreationUtils.EntityType
import com.example.ba2_info_projectriverraid.entities.Entities
import com.example.ba2_info_projectriverraid.entities.Block
import com.example.ba2_info_projectriverraid.entities.FuelTank
import com.example.ba2_info_projectriverraid.entities.Missile
import com.example.ba2_info_projectriverraid.entities.Player
import com.example.ba2_info_projectriverraid.entities.enemies.Ship
//import com.example.ba2_info_projectriverraid.entities.FuelTank
class GameView @JvmOverloads constructor (context: Context,
                                          attributes: AttributeSet? = null,
                                          defStyleAttr: Int = 0)
    : SurfaceView(context, attributes, defStyleAttr), SurfaceHolder.Callback{
    lateinit var canvas: Canvas
    val backgroundPaint = Paint()
    var screenWidth = 0f; var screenHeight = 0f
    var moveLeftPressed = false; var moveRightPressed = false
    var shootPressed = false
    lateinit var thread: Thread
    val player = Player(
        0f, 0f,
        view = this,
        moveRightPressed = moveRightPressed,
        moveLeftPressed = moveLeftPressed,
        shootPressed = shootPressed
    )
    val missiles = mutableListOf<Missile>()
    val entities = mutableListOf<Entities>()
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
    fun draw() {
        if (holder.surface.isValid) {
            canvas = holder.lockCanvas()
            canvas.drawRect(0f, 0f, canvas.width.toFloat(),
                canvas.height.toFloat(), backgroundPaint)
            for (missile in missiles) {
                missile.draw(canvas)
            }
            for (entity in entities){
                when(entity){
                    is Ship -> entity.draw(canvas)
                    is Block -> entity.draw(canvas)
                    is FuelTank -> entity.draw(canvas)
                }
            }
            player.draw(canvas)
            holder.unlockCanvasAndPost(canvas)
        }
    }
    fun handleInput(event: MotionEvent) {
        // Handle input events and update the input states
    }
    override fun surfaceChanged(holder: SurfaceHolder, format: Int, screenWidth: Int, screenHeight: Int) {}
    override fun surfaceCreated(holder: SurfaceHolder) {}
    override fun surfaceDestroyed(holder: SurfaceHolder) {}
    override fun onSizeChanged(w: Int, h: Int, oldw: Int, oldh: Int){
        super.onSizeChanged(w, h, oldw, oldh)
        screenWidth = w.toFloat()
        screenHeight = h.toFloat()
        player.entitiesX = screenWidth/ 2f
        player.entitiesY = screenHeight * 0.8f
        CreationUtils.createEntities(3, entities, screenWidth, screenHeight, EntityType.Enemy, this)
        CreationUtils.createEntities(3, entities, screenWidth, screenHeight, EntityType.Block, this)
        CreationUtils.createEntities(3, entities, screenWidth, screenHeight, EntityType.FuelTank, this)
    }
}