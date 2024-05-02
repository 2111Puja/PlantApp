import android.animation.ObjectAnimator
import android.os.Bundle
import android.view.View
import android.view.animation.AccelerateDecelerateInterpolator
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val imageView = findViewById<View>(R.id.imageView)

        // Create an ObjectAnimator for translation animation on the Y-axis
        val animator = ObjectAnimator.ofFloat(imageView, "translationY", 0f, 200f)
        animator.duration = 1000 // Set duration in milliseconds
        animator.interpolator = AccelerateDecelerateInterpolator() // Set interpolator
        animator.repeatCount = ObjectAnimator.INFINITE // Repeat animation infinitely
        animator.repeatMode = ObjectAnimator.REVERSE // Reverse animation on each iteration

        // Start the animation
        animator.start()
    }
}
