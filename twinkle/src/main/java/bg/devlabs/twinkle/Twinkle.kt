package bg.devlabs.twinkle

import android.app.Activity
import android.os.Handler
import android.util.Log
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import java.util.*

/**
 * Created by Radoslav Yankov on 20.07.2018
 * Dev Labs
 * radoslavyankov@gmail.com
 */

/**
 * @param drawableRes The drawable resource for the twinkle effect. Star by default
 * @param duration The duration of each particle animation. 600ms by default
 * @param sparsity The period between particle generation. Larger number -> less particles.
 * @param size The size of each particle in pixels. 80 pixels by default
 */
fun View.twinkle(drawableRes: Int = R.drawable.twinkle, duration: Int = 600, sparsity: Int = 120, size: Int = 80): Twinkle {
    return Twinkle(this, drawableRes, duration, sparsity, size)
}

/**
 * Main Twinkle class
 */
class Twinkle(var view: View, var drawableRes: Int, var duration: Int, private var sparsity: Int, var size: Int) {
    private var isRunning = true

    init {
        start()
    }

    fun start() {
        isRunning = true
        val rInt = Random()
        loop(rInt.nextInt(sparsity * 2) + (sparsity / 2L)) {
            //creating the ImageView. Not the most optimal way of showing graphics, but it's easy
            var image: ImageView? = ImageView(view.context)
            image?.apply {
                layoutParams = ViewGroup.LayoutParams(size, size)
                setBackgroundResource(drawableRes)
                try {
                    x = (rInt.nextInt((view.width / 1.1).toInt()) + view.x + view.width * 0.1f) - (layoutParams.width / 2)
                    y = (rInt.nextInt((view.height / 1.1).toInt()) + view.y + view.height * 0.1f) - (layoutParams.height / 2)
                } catch (e: Exception) {
                    return@apply
                }
                (view.context as? Activity)?.window?.decorView?.findViewById<ViewGroup>(android.R.id.content)?.addView(this)
                alpha = 0f
                scaleX = 0.7f
                scaleY = 0.7f
                animate().alpha(0.5f).duration = duration / 3L
                animate().scaleX(1f).duration = duration / 3L
                animate().scaleY(1f).duration = duration / 3L
                loop(150) {
                    //                    alpha = 0.5f
                    animate().alpha(0.5f).duration = 70
                    delay(80) {
                        animate().alpha(0.4f).duration = 30
//                        alpha = 0.4f
                    }
                }
                //animation
                delay(duration / 3L) {
                    animate().rotation(-10f).duration = duration / 6L
                    delay(duration / 6L) {
                        animate().rotation(10f).duration = duration / 6L * 2
                        delay(duration / 6L * 2) {
                            animate().rotation(0f).duration = duration / 6L
                        }
                    }
                    delay(duration / 3L) {
                        animate().alpha(0f).duration = duration / 3L
                        animate().scaleX(0.7f).duration = duration / 3L
                        animate().scaleY(0.7f).duration = duration / 3L
                    }
                }
            }
            delay(duration.toLong()) {
                (view.context as? Activity)?.window?.decorView?.findViewById<ViewGroup>(android.R.id.content)?.removeView(image)
                image = null
            }
        }
    }


    fun stop(){
        isRunning = false
    }

    private fun loop(delay: Long, f: () -> Unit) {
        f()
        var handler: Handler? = Handler()
        val runnable = object : Runnable {
            override fun run() {
                if (!isRunning){
                    handler = null
                    return
                }
                try {
                    f()
                } catch (e: Exception) {
                    Log.d("Twinkle error", e.localizedMessage)
                }; handler?.postDelayed(this, delay)
            }
        }; handler?.postDelayed(runnable, delay)
    }

    private fun delay(delay: Long, func: () -> Unit) {
        val handler = Handler()
        handler.postDelayed({
            try {
                func()
            } catch (e: Exception) {
                Log.d("Twinkle error", e.localizedMessage)
            }
        }, delay)
    }

}