package com.dev.mohitmunjal

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.LinearLayoutManager
import com.dev.mohitmunjal.databinding.ActivityMainBinding
import com.dev.mohitmunjal.databinding.ActivityRoomListBinding

class RoomListActivity : AppCompatActivity() {
    private lateinit var roomListBinding: ActivityRoomListBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        roomListBinding=DataBindingUtil.setContentView(this,R.layout.activity_room_list)
        populateRooms()
    }
    private  fun populateRooms(){
        var roomListAdapter=RoomListAdapter(this, roomsList)
        roomListBinding.rvRooms.apply {
            layoutManager=LinearLayoutManager(context,LinearLayoutManager.VERTICAL,false)
            adapter=roomListAdapter
        }

    }
}