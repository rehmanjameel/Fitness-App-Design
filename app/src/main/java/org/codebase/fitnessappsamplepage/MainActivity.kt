package org.codebase.fitnessappsamplepage

import android.graphics.Color
import android.os.Build
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.fragment.app.Fragment
import com.example.horizontalcalendar.DateItemClickListener
import com.google.android.material.bottomnavigation.BottomNavigationView
import kotlinx.android.synthetic.main.activity_main.*
import org.codebase.fitnessappsamplepage.fragments.*
import java.util.Date

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
            window.statusBarColor = Color.BLACK
        }

        replaceFragment(Fragment1())
        bottomNavId.setOnItemSelectedListener {item ->
            // By using switch we can easily get the
            // selected fragment by using there id
            when (item.itemId) {
                R.id.done -> replaceFragment(Fragment1())
                R.id.calendar -> replaceFragment(Fragment2())
                R.id.file-> replaceFragment(Fragment3())
                R.id.call_act -> replaceFragment(Fragment4())
                R.id.profile -> replaceFragment(Fragment5())
                else -> {

                }
            }
            // It will help to replace the
            // one fragment to other.
            true
        }
    }

    private fun replaceFragment(fragment: Fragment) {
        val fragmentManager = supportFragmentManager
        val fragmentTransaction = fragmentManager.beginTransaction()
        fragmentTransaction.replace(R.id.fragment_container, fragment)
        fragmentTransaction.addToBackStack(null)
        fragmentTransaction.commit()
    }


    override fun onBackPressed() {
        if (bottomNavId.selectedItemId == R.id.done) {
            super.onBackPressed()
            finish()
        } else {
            bottomNavId.selectedItemId = R.id.done
        }
    }

}