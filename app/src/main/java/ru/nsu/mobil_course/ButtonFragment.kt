package ru.nsu.mobil_course

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import kotlinx.android.synthetic.main.button.view.*


class ButtonFragment : Fragment() {
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.button, container, false)
        view.goButton.text = arguments?.getString("label") ?: "not found"
        view.goButton.setOnClickListener { arguments?.getString("text")?.let { it1 ->
            showFragment(
                it1
            )
        } }
        return view
    }

    fun showFragment(text: String){
        val fragment = TextFragment()
        fragment.arguments = Bundle().also{
            it.putString("text", text)
        }
        activity?.supportFragmentManager
            ?.beginTransaction()
            ?.replace(R.id.frame, fragment)
            ?.addToBackStack("Text")
            ?.commit()

    }
}