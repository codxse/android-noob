package id.nadiar.pengitung

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import kotlinx.android.synthetic.main.activity_main.*
import java.lang.NumberFormatException

class MainActivity : AppCompatActivity() {

    private lateinit var _result: EditText
    private lateinit var _newNumber: EditText
    private val _displayOperation by lazy(LazyThreadSafetyMode.NONE) { findViewById<TextView>(R.id.textView) }

    // Variables to hold the operands and type calculation
    private var _operand1: Double? = null
    private var _operand2: Double = 0.0
    private var _pendingOperation = "="

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        _result = findViewById(R.id.result_op)
        _newNumber = findViewById(R.id.operation)

        val button0: Button = findViewById(R.id.button_0)
        val button1: Button = findViewById(R.id.button_1)
        val button2: Button = findViewById(R.id.button_2)
        val button3: Button = findViewById(R.id.button_3)
        val button4: Button = findViewById(R.id.button_4)
        val button5: Button = findViewById(R.id.button_5)
        val button6: Button = findViewById(R.id.button_6)
        val button7: Button = findViewById(R.id.button_7)
        val button8: Button = findViewById(R.id.button_8)
        val button9: Button = findViewById(R.id.button_9)
        val buttonDot: Button = findViewById(R.id.floating_point)

        val buttonEquals = findViewById<Button>(R.id.equal)
        val buttonDivide = findViewById<Button>(R.id.devide_op)
        val buttonMultiply = findViewById<Button>(R.id.multiply_op)
        val buttonMinus = findViewById<Button>(R.id.minus)
        val buttonPlus = findViewById<Button>(R.id.plus)

        val listener = View.OnClickListener { v ->
            val b = v as Button
            _newNumber.append(b.text)
        }

        button0.setOnClickListener(listener)
        button1.setOnClickListener(listener)
        button2.setOnClickListener(listener)
        button3.setOnClickListener(listener)
        button4.setOnClickListener(listener)
        button5.setOnClickListener(listener)
        button6.setOnClickListener(listener)
        button7.setOnClickListener(listener)
        button8.setOnClickListener(listener)
        button9.setOnClickListener(listener)
        buttonDot.setOnClickListener(listener)

        val opListener = View.OnClickListener { v ->
            val op = (v as Button).text.toString()
            try {
                val value = _newNumber.text.toString().toDouble()
                _performOperation(value, op)
            } catch (e: NumberFormatException) {
                _newNumber.setText("")

            }
            _pendingOperation = op
            _displayOperation.text = _pendingOperation
        }

        buttonEquals.setOnClickListener(opListener)
        buttonMinus.setOnClickListener(opListener)
        buttonMultiply.setOnClickListener(opListener)
        buttonDivide.setOnClickListener(opListener)
        buttonPlus.setOnClickListener(opListener)

    }

    private fun _performOperation(value: Double, operation: String) {
        if (_operand1 == null) {
            _operand1 = value
        } else {
            _operand2 = value

            if (_pendingOperation == "=") {
                _pendingOperation = operation
            }

            when (_pendingOperation) {
                "=" -> _operand1 = _operand2
                "/" -> if (_operand2 == 0.0) {
                            _operand1 = Double.NaN
                        } else {
                            _operand1 = _operand1!! / _operand2
                        }
                "*" -> _operand1 = _operand1!! * _operand2
                "-" -> _operand1 = _operand1!! - _operand2
                "+" -> _operand1 = _operand1!! + _operand2
            }
        }

        _result.setText(_operand1.toString())
        _newNumber.setText("")
    }
}