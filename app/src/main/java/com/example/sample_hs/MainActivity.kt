package com.example.sample_hs

import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import com.example.sample_hs.databinding.ActivityMainBinding


external fun hsInit()

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        // Example of a call to a native method
        binding.editText.setText("Hello from Haskell!")
        binding.sampleText.text = stringFromJNI(binding.editText.text.toString())
    }

    /**
     * A native method that is implemented by the 'sample_hs' native library,
     * which is packaged with this application.
     */
    external fun stringFromJNI(value: String): String

    companion object {
        // Used to load the 'sample_hs' library on application startup.
        init {
            System.loadLibrary("sample_hs")
            // System.loadLibrary("foo")
            hsInit()
        }
    }

    private var value: Int = 0

    fun handleClick(view: View) {
        Thread {
            val result = stringFromJNI(binding.editText.text.toString())
            runOnUiThread {
                binding.sampleText.text = result
            }
        }.start()
    }
}