package id.nadiar.playground

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.method.ScrollingMovementMethod
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.TextView

class MainActivity : AppCompatActivity() {
    private var _userInput: EditText? = null
    private var _button: Button? = null
    private var _textArea: TextView? = null
    private var _nClicked: Long = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        _userInput = findViewById<EditText>(R.id.textEdit)
        _button = findViewById<Button>(R.id.actionButton)
        _textArea = findViewById<TextView>(R.id.textArea)
        _textArea?.text = ""
        _textArea?.movementMethod = ScrollingMovementMethod()

        _button?.setOnClickListener(object: View.OnClickListener {
            override fun onClick(p0: View?) {
                _nClicked += 1
                _textArea?.append("\nThe Button Click $_nClicked time")
                if (_nClicked != 1L) {
                    _textArea?.append("s\n")
                    return
                }
                _textArea?.append("\n")
            }
        })
    }
}