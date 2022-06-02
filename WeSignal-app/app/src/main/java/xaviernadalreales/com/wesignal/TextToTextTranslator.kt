package xaviernadalreales.com.wesignal

import android.content.Intent
import android.os.Bundle
import android.widget.LinearLayout
import android.widget.PopupMenu
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import com.google.android.material.bottomnavigation.BottomNavigationView
import com.google.android.material.bottomsheet.BottomSheetBehavior
import com.google.android.material.textfield.MaterialAutoCompleteTextView
import xaviernadalreales.com.wesignal.databinding.TextToTextTranslatorLayoutBinding

class TextToTextTranslator : AppCompatActivity() {

    private lateinit var viewBinding: TextToTextTranslatorLayoutBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        viewBinding = TextToTextTranslatorLayoutBinding.inflate(layoutInflater)
        setContentView(viewBinding.root)

        initBottomMenu()
        initOptionsMenu()
        languagesMenus()

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

    private fun initBottomMenu() {
        val bottomMenu = findViewById<BottomNavigationView>(R.id.bottom_navigation)
        bottomMenu.setOnItemSelectedListener { item ->
            when (item.itemId) {
                R.id.TextToSign -> {
                    val intent = Intent(this, TextTranslator::class.java)
                    startActivity(intent)
                }
                R.id.signToText -> {
                    val intent = Intent(this, TextTranslator::class.java)
                    startActivity(intent)
                }
            }
            return@setOnItemSelectedListener true
        }
    }
    private fun languagesMenus(){
        val leftMenu = viewBinding.leftLanguage
        leftMenu.setOnClickListener {
            PopupMenu(applicationContext!!, leftMenu).apply {
                menuInflater.inflate(R.menu.language_selection, menu)
                setOnMenuItemClickListener { item ->
                    leftMenu.setText(item.title)
                    true
                }
                show()
            }
        }
        val rightMenu = viewBinding.rightLanguage
        leftMenu.setOnClickListener {
            PopupMenu(applicationContext!!, rightMenu).apply {
                menuInflater.inflate(R.menu.language_selection, menu)
                setOnMenuItemClickListener { item ->
                    rightMenu.setText(item.title)
                    true
                }
                show()
            }
        }
    }
}