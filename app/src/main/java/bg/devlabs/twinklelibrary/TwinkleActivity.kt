package bg.devlabs.twinklelibrary

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.util.Log
import bg.devlabs.twinkle.Twinkle
import bg.devlabs.twinkle.twinkle
import kotlinx.android.synthetic.main.activity_twinkle.*

class TwinkleActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_twinkle)

        val t: Twinkle = twinkle_text.twinkle()
        delay(1000) {
            t.stop()
        }
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
