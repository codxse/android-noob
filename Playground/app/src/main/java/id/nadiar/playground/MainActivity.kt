package id.nadiar.playground

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.method.ScrollingMovementMethod
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.util.Log
import kotlinx.android.synthetic.main.activity_main.*

private const val _TAG_ = "MAIN ACTIVITY"
private const val _SAVE_ = "SAVE"

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        Log.d(_TAG_, "onCreate: called")
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val userInput: EditText = findViewById<EditText>(R.id.textEdit)
        val button: Button = findViewById<Button>(R.id.actionButton)
        val textArea: TextView = findViewById<TextView>(R.id.textArea)
        textArea.text = ""
        textArea.movementMethod = ScrollingMovementMethod()

        button.setOnClickListener(object: View.OnClickListener {
            override fun onClick(p0: View?) {
                Log.d(_TAG_, "onClick: called")
                textArea.append(userInput.text)
                textArea.append("\n")
                userInput.text.clear()
            }
        })
    }

    override fun onStart() {
        super.onStart()
        Log.d(_TAG_, "onStart: called")
    }

    override fun onSaveInstanceState(outState: Bundle) {
        Log.d(_TAG_, "onSaveInstanceState: called")
        super.onSaveInstanceState(outState)
        outState.putString(_SAVE_, textArea?.text.toString())
    }

    override fun onRestoreInstanceState(savedInstanceState: Bundle) {
        super.onRestoreInstanceState(savedInstanceState)
        Log.d(_TAG_, "onRestoreInstanceState: called")
        val savedString = savedInstanceState.getString(_SAVE_)
        textArea.text = savedString
    }

    override fun onResume() {
        Log.d(_TAG_, "onResume: called")
        super.onResume()
    }

    override fun onPause() {
        Log.d(_TAG_, "onPause: called")
        super.onPause()
    }

    override fun onRestart() {
        Log.d(_TAG_, "onRestart: called")
        super.onRestart()
    }

    override fun onStop() {
        Log.d(_TAG_, "onStop: called")
        super.onStop()
    }

    override fun onDestroy() {
        Log.d(_TAG_, "onDestroy: called")
        super.onDestroy()
    }
}