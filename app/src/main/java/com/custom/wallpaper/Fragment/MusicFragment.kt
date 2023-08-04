package com.custom.wallpaper.Fragment

import android.os.Bundle
import android.os.Handler
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.recyclerview.widget.StaggeredGridLayoutManager
import com.custom.wallpaper.Adapter.PhotosAdapter
import com.custom.wallpaper.ModelClass.ModelClass
import com.custom.wallpaper.R
import com.custom.wallpaper.databinding.FragmentAnimalBinding
import com.custom.wallpaper.databinding.FragmentAnimeBinding
import com.custom.wallpaper.databinding.FragmentFlowerBinding
import com.custom.wallpaper.databinding.FragmentMusicBinding
import com.custom.wallpaper.databinding.FragmentVehicleBinding
import com.google.firebase.database.DataSnapshot
import com.google.firebase.database.DatabaseError
import com.google.firebase.database.DatabaseReference
import com.google.firebase.database.FirebaseDatabase
import com.google.firebase.database.ValueEventListener


class MusicFragment : Fragment() {

    private lateinit var binding: FragmentMusicBinding
    private lateinit var adapter: PhotosAdapter
    private lateinit var dbRef: DatabaseReference
    private lateinit var key: String
    private lateinit var model: ModelClass

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentMusicBinding.inflate(layoutInflater)



        dbRef = FirebaseDatabase.getInstance().reference
        adapter = PhotosAdapter()

        binding.neonRecyler.layoutManager =StaggeredGridLayoutManager(2, StaggeredGridLayoutManager.VERTICAL)
        binding.neonRecyler.adapter = adapter

        key = dbRef.push().key!!
        dbRef.root.child("Image").child("Music").addValueEventListener(object :
            ValueEventListener {
            override fun onDataChange(snapshot: DataSnapshot) {

                var list = ArrayList<ModelClass>()

                for (snap in snapshot.children) {

                    model = ModelClass(snap.getValue().toString())
                    list.add(model!!)

                }

                binding.neonRecyler.visibility = View.INVISIBLE
                adapter.UpdateData(list)

                Handler().postDelayed(object : Runnable {
                    override fun run() {

                        binding.neonRecyler.visibility = View.VISIBLE
                        adapter.UpdateData(list)

                    }

                }, 1000)

            }

            override fun onCancelled(error: DatabaseError) {
                Toast.makeText(context, error.message, Toast.LENGTH_SHORT).show()
            }

        })

        return binding.root
    }

}

