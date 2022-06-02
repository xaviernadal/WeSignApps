package xaviernadalreales.com.wesignal

import android.content.Intent
import android.os.Bundle
import android.widget.LinearLayout
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import com.google.android.material.bottomnavigation.BottomNavigationView
import com.google.android.material.bottomsheet.BottomSheetBehavior
import xaviernadalreales.com.wesignal.databinding.TextTranslatorLayoutBinding

class TextTranslator : AppCompatActivity() {

    private lateinit var viewBinding: TextTranslatorLayoutBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        viewBinding = TextTranslatorLayoutBinding.inflate(layoutInflater)
        setContentView(viewBinding.root)

        initBottomMenu()
        initOptionsMenu()
    }
    private fun initBottomMenu() {
        val bottomMenu = findViewById<BottomNavigationView>(R.id.bottom_navigation)
        bottomMenu.setOnItemSelectedListener { item ->
            when (item.itemId) {
                R.id.signToText -> {
                    val intent = Intent(this, MainActivity::class.java)
                    startActivity(intent)
                }
                R.id.TextToText -> {
                    val intent = Intent(this, TextToTextTranslator::class.java)
                    startActivity(intent)
                }
            }
            return@setOnItemSelectedListener true
        }
    }
    private fun initOptionsMenu() {
        val optionsMenu: LinearLayout = findViewById(R.id.layout_options)
        val bottomSheetBehavior: BottomSheetBehavior<LinearLayout> =
            BottomSheetBehavior.from(optionsMenu)

        optionsMenu.findViewById<TextView>(R.id.options_menu_handle).setOnClickListener {
            if (bottomSheetBehavior.state != BottomSheetBehavior.STATE_EXPANDED) {
                bottomSheetBehavior.state = BottomSheetBehavior.STATE_EXPANDED
            } else {
                bottomSheetBehavior.state = BottomSheetBehavior.STATE_COLLAPSED
            }
        }

        optionsMenu.findViewById<LinearLayout>(R.id.uploadVideo).setOnClickListener {
            val intent = Intent(this, UploadVideo::class.java)
            startActivity(intent)
        }
        optionsMenu.findViewById<LinearLayout>(R.id.aboutUs).setOnClickListener {
            val intent = Intent(this, AboutUs::class.java)
            startActivity(intent)
        }

    }
}