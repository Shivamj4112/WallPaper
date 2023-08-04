package com.custom.wallpaper.Adapter

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentPagerAdapter
import com.custom.wallpaper.Fragment.AnimalFragment
import com.custom.wallpaper.Fragment.AnimeFragment
import com.custom.wallpaper.Fragment.BabyFragment
import com.custom.wallpaper.Fragment.CartoonFragment
import com.custom.wallpaper.Fragment.FestivalFragment
import com.custom.wallpaper.Fragment.FlowerFragment
import com.custom.wallpaper.Fragment.MaterialFragment
import com.custom.wallpaper.Fragment.MusicFragment
import com.custom.wallpaper.Fragment.NeonFragment
import com.custom.wallpaper.Fragment.VehicleFragment

class FragmentAdapter(fm: FragmentManager,var category: Array<String>) : FragmentPagerAdapter(fm) {
    override fun getCount(): Int {
        return category.size
    }

    override fun getItem(position: Int): Fragment {

        return when(position){

            0-> return NeonFragment()

            1-> return AnimeFragment()

            2-> return VehicleFragment()

            3-> return FlowerFragment()

            4-> return AnimalFragment()

            5-> return MusicFragment()

            6-> return CartoonFragment()

            7-> return MaterialFragment()

            8-> return BabyFragment()

            9-> return FestivalFragment()



            else->return NeonFragment()
        }
    }

    override fun getPageTitle(position: Int): CharSequence? {

        return category[position]
    }
}