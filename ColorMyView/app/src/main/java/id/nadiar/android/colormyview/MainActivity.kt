package id.nadiar.android.colormyview

import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import androidx.databinding.DataBindingUtil
import id.nadiar.android.colormyview.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        this.binding = DataBindingUtil.setContentView(this, R.layout.activity_main)
        this.setListeners()
    }

    private fun setListeners() {
        val clickableViews = listOf<View>(binding.boxOmeText, binding.boxTwoText, binding.boxThreeText,
            binding.boxFourText, binding.boxFiveText, binding.greenButton, binding.redButton, binding.yellowButton)
        for (view in clickableViews) {
            view.setOnClickListener { this.makeColored(it) }
        }
    }

    private fun makeColored(view: View) {
        when (view.id) {
            R.id.boxOme_text -> view.setBackgroundColor(Color.DKGRAY)
            R.id.boxTwo_text -> view.setBackgroundColor(Color.GRAY)
            R.id.boxThree_text -> view.setBackgroundResource(android.R.color.holo_green_light)
            R.id.boxFour_text -> view.setBackgroundResource(android.R.color.holo_green_dark)
            R.id.boxFive_text -> view.setBackgroundResource(android.R.color.holo_green_light)
            R.id.green_button -> binding.boxThreeText.setBackgroundResource(R.color.my_green)
            R.id.red_button -> binding.boxFourText.setBackgroundResource(R.color.my_red)
            R.id.yellow_button -> binding.boxFiveText.setBackgroundResource(R.color.my_yellow)
            else -> view.setBackgroundColor(Color.LTGRAY)
        }
    }
}