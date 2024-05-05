package com.example.ba2_info_projectriverraid

import GameThread
import android.content.Context
import android.graphics.Canvas
import android.util.AttributeSet
import android.view.SurfaceHolder
import android.view.SurfaceView

class GameView @JvmOverloads constructor(
    context: Context,
    attrs: AttributeSet? = null,
    defStyleAttr: Int = 0
) : SurfaceView(context, attrs, defStyleAttr), SurfaceHolder.Callback {

    // Initialize any necessary variables or objects for the GameView
    private val thread: GameThread

    init {
        // Get the SurfaceHolder and add the callback
        holder.addCallback(this)

        // Create the GameThread
        thread = GameThread(holder, this)
    }

    // Implement SurfaceHolder.Callback methods
    override fun surfaceCreated(holder: SurfaceHolder) {
        // Start the GameThread
        thread.running = true
        thread.start()
    }

    override fun surfaceChanged(holder: SurfaceHolder, format: Int, width: Int, height: Int) {
        // Update the GameView's dimensions
    }

    override fun surfaceDestroyed(holder: SurfaceHolder) {
        // Stop the GameThread
        thread.running = false
        thread.join()
    }

    // Override the onDraw() method to draw the game
    override fun onDraw(canvas: Canvas) {
        super.onDraw(canvas)

        // Draw the game objects on the canvas
    }
}