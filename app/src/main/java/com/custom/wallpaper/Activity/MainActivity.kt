package com.custom.wallpaper.Activity

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.custom.wallpaper.Adapter.FragmentAdapter
import com.custom.wallpaper.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    var category = arrayOf("Neon","Anime","Vehicle","Flower","Animal","Music","Cartoon","Material","Baby","Festival")

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val viewpager = FragmentAdapter(supportFragmentManager,category)
        binding.viewPager.adapter = viewpager

        binding.tabLayout.setupWithViewPager(binding.viewPager)
    }
}