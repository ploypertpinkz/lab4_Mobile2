package buu.informatics.s59160587.aboutme

import android.content.Context
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.view.inputmethod.InputMethodManager
import android.widget.Button
import android.widget.EditText
import android.widget.TextView

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        findViewById<Button>(R.id.done_button).setOnClickListener {
            addNickname(it)
        }
    }

    private fun addNickname(view: View) {
        val editText = findViewById<EditText>(R.id.nicknam_edit)
        val nicknameTextView = findViewById<TextView>(R.id.nickname_text)
        nicknameTextView.text = editText.text
        editText.visibility = View.GONE
        nicknameTextView.visibility = View.VISIBLE

        val doneButton = findViewById<Button>(R.id.done_button)
        doneButton.visibility = View.GONE

        val inputMethodManger = getSystemService(Context.INPUT_METHOD_SERVICE) as InputMethodManager
        inputMethodManger.hideSoftInputFromWindow(view.windowToken, 0)
    }

}
