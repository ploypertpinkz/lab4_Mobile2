package buu.informatics.s59160587.aboutme

import android.app.Activity
import android.content.Context
import android.databinding.DataBindingUtil
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.view.inputmethod.InputMethodManager
import android.widget.ActionMenuView
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import buu.informatics.s59160587.aboutme.databinding.ActivityMainBinding
import kotlinx.android.synthetic.main.activity_main.*


class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    private val myName: MyName = MyName("Ploy Jearawong")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        //Binding Data
        binding = DataBindingUtil.setContentView(this, R.layout.activity_main)

        binding.apply {
            doneButton.setOnClickListener {
                addNickname(it)
            }

            nicknameText.setOnClickListener {
                updateNickname(it)
            }
            this.binding.myName = this@MainActivity.myName
        }


    }

    private fun updateNickname(view: View) {
        binding.apply {
            nicknameText.text = nicknamEdit.text
            nicknamEdit.visibility = View.VISIBLE
            nicknameText.visibility = View.GONE

            doneButton.visibility = View.VISIBLE

           nicknamEdit.requestFocus()
            //show keyboard
            val inm = getSystemService(Context.INPUT_METHOD_SERVICE) as InputMethodManager
            inm.showSoftInput(nicknamEdit, 0)
        }
    }

    private fun addNickname(view: View) {
        binding.apply {
            nicknameText.text = nicknamEdit.text
            nicknamEdit.visibility = View.GONE
            nicknameText.visibility = View.VISIBLE

            //hide button done
           doneButton.visibility = View.GONE

            //hide keyboard
            val inputMethodManger = getSystemService(Context.INPUT_METHOD_SERVICE) as InputMethodManager
            inputMethodManger.hideSoftInputFromWindow(view.windowToken, 0)
        }
    }
}
