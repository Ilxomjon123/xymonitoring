package com.example.hack

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.MenuItem

import androidx.navigation.findNavController
import com.example.hack.Fragment.Home_fragment
import com.example.hack.Fragment.Monitoring
import com.example.hack.Fragment.Help_fragment
import com.example.hack.Fragment.Video
import com.example.hack.Fragment.Graphic

import com.google.android.material.bottomnavigation.BottomNavigationView
import kotlinx.android.synthetic.main.activity_main.*
import android.widget.Toast

import android.content.Intent
import android.net.Uri
import java.lang.Exception
import java.security.AccessController.getContext


class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        supportFragmentManager
        val fragment = Home_fragment()
        supportFragmentManager
            .beginTransaction()
            .replace(R.id.container, fragment)
            .commit()
        bottom_navigation.setSelectedItemId(R.id.home1)
        bottom_navigation.isItemHorizontalTranslationEnabled
        bottom_navigation.setOnNavigationItemSelectedListener(object :
            BottomNavigationView.OnNavigationItemSelectedListener {
            override fun onNavigationItemSelected(item: MenuItem): Boolean {
                val itemId: Int = item.getItemId()
                when (itemId) {
                    R.id.home1 -> {
                        val fragment1 = Home_fragment()
                        supportFragmentManager
                            .beginTransaction()
                            .replace(R.id.container, fragment1)
                            .commit()
                    }
                    R.id.home2 -> {
                        val fragment2 = Monitoring()
                        supportFragmentManager
                            .beginTransaction()
                            .replace(R.id.container, fragment2)
                            .commit()

                    }
                    R.id.home3 -> {
                        val fragment3 = Graphic()
                        supportFragmentManager
                            .beginTransaction()
                            .replace(R.id.container, fragment3)
                            .commit()

                    }
                    R.id.home4->{
                        val fragment4 = Video()
                        supportFragmentManager
                            .beginTransaction()
                            .replace(R.id.container, fragment4)
                            .commit()
                    }
                    R.id.home5->{
                    val fragment5 = Help_fragment()
                    supportFragmentManager
                        .beginTransaction()
                        .replace(R.id.container, fragment5)
                        .commit()
                }
                    R.id.telegram->{
                        try {
                            val telegram =
                                Intent(Intent.ACTION_VIEW, Uri.parse("https://t.me/astrum_hackathon"))
                            telegram.setPackage("org.telegram.messenger")
                            startActivity(telegram)
                        } catch (e: Exception) {
                            Toast.makeText(this@MainActivity, "Нет телеграм", Toast.LENGTH_SHORT).show()
                        }



                    }
                }
                return true
            }

        })


    }


    override fun onSupportNavigateUp(): Boolean {
        return findNavController(R.id.navi_host).navigateUp()
    }

    override fun onBackPressed() {
        super.onBackPressed()
        if (getSupportFragmentManager().getBackStackEntryCount() == 0) {
            finish();
        }
    }



}