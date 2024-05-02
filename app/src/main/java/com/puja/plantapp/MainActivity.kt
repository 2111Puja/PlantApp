@file:Suppress("UNREACHABLE_CODE")

package com.puja.plantapp

import android.annotation.SuppressLint
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.provider.SyncStateContract.Helpers.update
import android.view.View
import android.view.animation.AnimationUtils
import android.widget.ImageView
import android.widget.TextView
import android.widget.Button as Button1

class MainActivity: AppCompatActivity() {
    //variables
    private lateinit var imageViewPlant: ImageView
    private var health = 100
    private var water = 0
    private var sunlight = 100


    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        imageViewPlant = findViewById(R.id.imageViewPlant)

        val buttonWater = findViewById<Button1>(R.id.buttonWater)
        val buttonFertilize = findViewById<Button1>( R.id.buttonFertilize)
        val buttonSun = findViewById<Button1>(R.id.buttonSun)

        val waterAnimation = AnimationUtils.loadAnimation(this, R.anim.plant_water)
        val fertilizeAnimation = AnimationUtils.loadAnimation(this, R.anim.plant_fertilize)
        val sunAnimation = AnimationUtils.loadAnimation(this, R.anim.plant_sun)

        buttonWater.setOnClickListener {
            imageViewPlant.startAnimation(waterAnimation)
            waterPlant()
            updateUI()
        }

        buttonFertilize.setOnClickListener {
            imageViewPlant.startAnimation(fertilizeAnimation)
            fertilizePlant()
            updateUI()
        }

        buttonSun.setOnClickListener {
            imageViewPlant.startAnimation(sunAnimation)
            putPlantInSun()
            updateUI()
        }
    }

    private fun waterPlant() {
        water += 10
        if (water > 100) water = 100
        sunlight -= 5
        if (sunlight < 0) sunlight = 0
    }

    private fun fertilizePlant() {
        health += 10
        if (health > 100) health = 100
    }

    private fun putPlantInSun() {
        sunlight += 10
        if (sunlight > 100) sunlight = 100
        water -= 5
        if (water < 0) water = 0
    }

    private fun updateUI() {
        val textViewHealth = findViewById<TextView>(R.id.textViewHealth)
        val textViewWater = findViewById<TextView>(R.id.textViewWater)
        val textViewSunlight = findViewById<TextView>(R.id.textViewSunlight)

        textViewHealth.text = "Health: $health"
        textViewWater.text = "Water: $water"
        textViewSunlight.text = "Sunlight: $sunlight"
    }
}