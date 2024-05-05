package com.example.ba2_info_projectriverraid

import android.content.Context
import android.graphics.Canvas
import android.os.Bundle
import android.view.SurfaceHolder
import android.view.SurfaceView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.ba2_info_projectriverraid.map.Boundary
import com.example.ba2_info_projectriverraid.map.Map

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
    }
}

class Main {

    // Properties
    var score: Double = 0.0
    /*val enemy_list: MutableList<Enemy> = mutableListOf()
    val missile_list: MutableList<Missile> = mutableListOf()
    val block_list: MutableList<Block> = mutableListOf()
    val fuel_tank_list: MutableList<FuelTank> = mutableListOf()
    */

    // Methods
    fun update_y() {
        // Update the y-coordinates of all entities
    }

    /*fun create_map() {
        // Create a new map instance and initialize it with some map data
        val map = Map()
        map.build_map() // Empty method body for now
    }
    */


    fun end_condition() {
        // Check if the game should end
    }

    fun create_entity() {
        // Create a new entity and add it to the appropriate list
    }
}