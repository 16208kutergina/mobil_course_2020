package ru.nsu.mobil_course

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.FragmentManager
import kotlinx.android.synthetic.main.menu.*


class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        if(savedInstanceState == null){
            showFragment("start", "start text")
        }
        button1.setOnClickListener { showFragment("label_1", "text_1")  }
        button2.setOnClickListener { showFragment("label_2", "text_2") }
        button3.setOnClickListener { showFragment("label_3", "text_3") }
    }

    fun showFragment(label: String, text: String){
        val fragment = ButtonFragment()
        fragment.arguments = Bundle().also{
            it.putString("label", label)
            it.putString("text", text)
        }

        supportFragmentManager.also { it.popBackStack("Text", FragmentManager.POP_BACK_STACK_INCLUSIVE) }
            .beginTransaction()
            .replace(R.id.frame, fragment)
            .commit()
    }
}
