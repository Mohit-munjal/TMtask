package com.dev.mohitmunjal

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.AdapterView
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.LinearLayoutManager
import com.dev.mohitmunjal.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var activityMainBinding: ActivityMainBinding
    var rooms=ArrayList<Room>()
    lateinit var roomAdapter: RoomAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        activityMainBinding= DataBindingUtil.setContentView(this, R.layout.activity_main)
        activityMainBinding.activity=this
        setUpRoomAdapter()
        setUpSpinner()
    }
    private fun setUpRoomAdapter(){
        roomAdapter= RoomAdapter(this, arrayListOf())
        activityMainBinding.rvRooms.apply {
            layoutManager=LinearLayoutManager(context,LinearLayoutManager.VERTICAL,false)
            adapter=roomAdapter
        }
    }

    private fun setUpSpinner(){
        activityMainBinding.spinnerRooms?.onItemSelectedListener = object : AdapterView.OnItemSelectedListener{
            override fun onNothingSelected(parent: AdapterView<*>?) {

            }

            override fun onItemSelected(parent: AdapterView<*>?, view: View?, position: Int, id: Long) {
                if(position!=0)
                {
                  var room=Room(position.toString())
                    rooms.add(room)
                    roomAdapter.apply {
                        addRooms(rooms)
                        notifyDataSetChanged()
                    }
                }

            }

        }    }
    fun onSubmit(){
        roomsList=rooms
        roomsList.forEach {
            Log.d("mohit", "onSubmit: ${it.toString()}")
        }
      var intent=Intent(this,RoomListActivity::class.java)
        startActivity(intent)
        finish()
    }
}