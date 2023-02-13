package org.codebase.fitnessappsamplepage.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import android.widget.Toast
import com.example.horizontalcalendar.DateItemClickListener
import kotlinx.android.synthetic.main.fragment_1.*
import kotlinx.android.synthetic.main.fragment_1.view.*
import org.codebase.fitnessappsamplepage.R

class Fragment1 : Fragment(), DateItemClickListener {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val view = inflater.inflate(R.layout.fragment_1, container, false)

        view.horizontal_calendar.initialize(this)
        val text = view.findViewById<TextView>(R.id.seekTextId3)
        text.text = getString(R.string.text3)
        return view
    }

    override fun onDateClick(date: String) {
        Toast.makeText(requireContext(), "Date $date", Toast.LENGTH_SHORT).show()
    }

}