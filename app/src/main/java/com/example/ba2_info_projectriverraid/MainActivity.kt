package com.example.ba2_info_projectriverraid


import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.ba2_info.projectriverraid.GameView
import com.example.ba2_info_projectriverraid.utils.DifficultyAndData

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
lateinit var gameView: GameView
    object DifficultyDataManager {
        private var _difficulty: DifficultyAndData = DifficultyAndData.EASY
        fun setDifficulty(difficultyAndData: DifficultyAndData) {
            _difficulty = difficultyAndData
        }
        public fun getData(): DifficultyAndData {
            return _difficulty
        }
    }
