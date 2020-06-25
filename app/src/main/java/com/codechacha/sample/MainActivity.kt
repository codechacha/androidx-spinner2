package com.codechacha.sample

import android.content.Intent
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.AdapterView
import androidx.recyclerview.widget.DividerItemDecoration
import kotlinx.android.synthetic.main.activity_main.*
import android.widget.ArrayAdapter
import android.widget.Spinner



class MainActivity : AppCompatActivity() {

    private lateinit var adapter: RecyclerAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val list = ArrayList<YoutubeItem>()
        adapter = RecyclerAdapter(list)
        recyclerView.adapter = adapter
        recyclerView.addItemDecoration(
            DividerItemDecoration(this, DividerItemDecoration.VERTICAL))

        spinner.onItemSelectedListener = object: AdapterView.OnItemSelectedListener {
            override fun onNothingSelected(parent: AdapterView<*>?) {
            }

            override fun onItemSelected(parent: AdapterView<*>?, view: View?, position: Int, id: Long) {
                Log.d("MainActivity",
                    "onItemSelected : $position, ${spinner.getItemAtPosition(position)}")
                when (spinner.getItemAtPosition(position)) {
                    "Android Dev Summit" -> {
                        updateAndroidSubmit()
                    }
                    "Android I/O" -> {
                        updateGoogleIO()
                    }
                    else -> {
                        updateAndroidSubmit()
                    }
                }
            }
        }
    }

    fun updateAndroidSubmit() {
        val list = ArrayList<YoutubeItem>()
        list.add(YoutubeItem(getDrawable(R.drawable.image01)!!,
            getString(R.string.title01),
            getString(R.string.url01)))
        list.add(YoutubeItem(getDrawable(R.drawable.image02)!!,
            getString(R.string.title02),
            getString(R.string.url02)))
        list.add(YoutubeItem(getDrawable(R.drawable.image03)!!,
            getString(R.string.title03),
            getString(R.string.url03)))
        list.add(YoutubeItem(getDrawable(R.drawable.image04)!!,
            getString(R.string.title04),
            getString(R.string.url04)))
        list.add(YoutubeItem(getDrawable(R.drawable.image05)!!,
            getString(R.string.title05),
            getString(R.string.url05)))
        list.add(YoutubeItem(getDrawable(R.drawable.image06)!!,
            getString(R.string.title06),
            getString(R.string.url06)))
        list.add(YoutubeItem(getDrawable(R.drawable.image07)!!,
            getString(R.string.title07),
            getString(R.string.url07)))
        list.add(YoutubeItem(getDrawable(R.drawable.image08)!!,
            getString(R.string.title08),
            getString(R.string.url08)))
        list.add(YoutubeItem(getDrawable(R.drawable.image09)!!,
            getString(R.string.title09),
            getString(R.string.url09)))
        list.add(YoutubeItem(getDrawable(R.drawable.image10)!!,
            getString(R.string.title10),
            getString(R.string.url10)))
        adapter.items = list
        adapter.notifyDataSetChanged()
    }

    fun updateGoogleIO() {
        val list = ArrayList<YoutubeItem>()
        list.add(YoutubeItem(getDrawable(R.drawable.googleio01)!!,
            getString(R.string.io_title01),
            getString(R.string.io_url01)))
        list.add(YoutubeItem(getDrawable(R.drawable.googleio02)!!,
            getString(R.string.io_title02),
            getString(R.string.io_url02)))
        list.add(YoutubeItem(getDrawable(R.drawable.googleio03)!!,
            getString(R.string.io_title03),
            getString(R.string.io_url03)))
        adapter.items = list
        adapter.notifyDataSetChanged()
    }
}
