package id.nadiar.android.aboutme

import android.content.Context
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.view.inputmethod.InputMethodManager
import androidx.databinding.DataBindingUtil
import id.nadiar.android.aboutme.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    private val myName: MyName = MyName("Aleks Haecky")

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_main)
        binding.myName = this.myName
        // setContentView(R.layout.activity_main)
        // findViewById<Button>(R.id.done_button).setOnClickListener { addNickname(it) }

        binding.doneButton.setOnClickListener { addNickname(it) }
    }

    fun addNickname(addButton: View) {
        // val editText = findViewById<EditText>(R.id.nickname_edit)
        // val nickNameText = findViewById<TextView>(R.id.nickname_text)

        // val editText = binding.nicknameEdit
        // val nickNameText = binding.nicknameText

        binding.apply {
            myName?.nickname = nicknameEdit.text.toString()
            invalidateAll()
            nicknameEdit.visibility = View.GONE
            doneButton.visibility = View.GONE
            nicknameText.visibility = View.VISIBLE
        }

        val imm = getSystemService(Context.INPUT_METHOD_SERVICE) as InputMethodManager
        imm.hideSoftInputFromWindow(addButton.windowToken, 0)
    }
}

data class MyName(var name: String = "", var nickname: String = "")