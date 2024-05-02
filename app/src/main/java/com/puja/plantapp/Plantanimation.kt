package com.puja.plantapp

import android.animation.ObjectAnimator
import android.annotation.SuppressLint
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.view.animation.AccelerateDecelerateInterpolator

class Plantanimation : AppCompatActivity() {

    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_animation)

        val imageViewPlant = findViewById<View>(R.id.imageViewPlant)



        // Create an ObjectAnimator for translation animation on the Y-axis
        val animator = ObjectAnimator.ofFloat(imageViewPlant, "translationY", 0f, 200f)
        animator.duration = 1000 // Set duration in milliseconds
        animator.interpolator = AccelerateDecelerateInterpolator() // Set interpolator
        animator.repeatCount = ObjectAnimator.INFINITE // Repeat animation infinitely
        animator.repeatMode = ObjectAnimator.REVERSE // Reverse animation on each iteration

        // Start the animation
        animator.start()
    }
}