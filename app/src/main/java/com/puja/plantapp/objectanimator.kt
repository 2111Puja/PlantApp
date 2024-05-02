package com.puja.plantapp

import android.animation.ObjectAnimator
import android.os.Bundle
import android.view.View
import com.google.android.material.snackbar.Snackbar
import androidx.appcompat.app.AppCompatActivity
import androidx.navigation.findNavController
import androidx.navigation.ui.AppBarConfiguration
import androidx.navigation.ui.navigateUp
import androidx.navigation.ui.setupActionBarWithNavController
import com.puja.plantapp.databinding.ActivityObjectanimatorBinding

class objectanimator : AppCompatActivity() {

    private lateinit var appBarConfiguration: AppBarConfiguration
    private lateinit var binding: ActivityObjectanimatorBinding
    private lateinit var imageViewPlant: View
    private lateinit var animator: ObjectAnimator

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityObjectanimatorBinding.inflate(layoutInflater)
        setContentView(binding.root)

        setSupportActionBar(binding.toolbar)

        imageViewPlant = findViewById<View>(R.id.imageViewPlant)

        // Create an ObjectAnimator for translation animation on the Y-axis
        animator = ObjectAnimator.ofFloat(imageViewPlant, "translationY", 0f, 200f)
        animator.duration = 1000 // Set duration in milliseconds
        animator.repeatCount = ObjectAnimator.INFINITE // Repeat animation infinitely
        animator.repeatMode = ObjectAnimator.REVERSE // Reverse animation on each iteration
        animator.interpolator = android.view.animation.AccelerateDecelerateInterpolator() // Set interpolator

        // Start the animation
        animator.start()

        val navController = findNavController(R.id.nav_host_fragment_content_objectanimator)
        appBarConfiguration = AppBarConfiguration(navController.graph)
        setupActionBarWithNavController(navController, appBarConfiguration)

        binding.fab.setOnClickListener { view ->
            Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                .setAction("Action", null).show()
        }
    }

    override fun onSupportNavigateUp(): Boolean {
        val navController = findNavController(R.id.nav_host_fragment_content_objectanimator)
        return navController.navigateUp(appBarConfiguration)
                || super.onSupportNavigateUp()
    }
}