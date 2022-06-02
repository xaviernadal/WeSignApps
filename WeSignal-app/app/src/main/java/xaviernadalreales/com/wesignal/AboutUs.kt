package xaviernadalreales.com.wesignal

import android.os.Bundle
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import xaviernadalreales.com.wesignal.databinding.FragmentAboutUsBinding

class AboutUs : AppCompatActivity() {
    private lateinit var viewBinding: FragmentAboutUsBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        viewBinding = FragmentAboutUsBinding.inflate(layoutInflater)
        setContentView(viewBinding.root)
        findViewById<TextView>(R.id.backText).setOnClickListener {
            finish()
        }
    }

}