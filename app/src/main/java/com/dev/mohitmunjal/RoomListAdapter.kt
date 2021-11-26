package com.dev.mohitmunjal

import android.util.Log
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.dev.mohitmunjal.databinding.ItemEntryBinding
import com.dev.mohitmunjal.databinding.ItemRoomBinding

private const val TAG = "mohit"
class RoomListAdapter (private val activity:RoomListActivity,private val rooms: ArrayList<Room>) : RecyclerView.Adapter<RoomListAdapter.RoomViewHolder>() {



    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RoomViewHolder {
        var itemRoomBinding= ItemEntryBinding.inflate(LayoutInflater.from(activity),parent,false)
        return RoomViewHolder(itemRoomBinding)

    }


    override fun getItemCount(): Int = rooms.size

    override fun onBindViewHolder(holder: RoomViewHolder, position: Int) {
        var room=rooms[position]
        holder.itemRoomBinding.room=room
        var membersListAdapter=MembersListAdapter(activity,room.members)
        holder.itemRoomBinding.rvMembers.apply {
            layoutManager=LinearLayoutManager(activity,LinearLayoutManager.VERTICAL,false)
            adapter=membersListAdapter
        }




    }


    class RoomViewHolder(var itemRoomBinding: ItemEntryBinding) : RecyclerView.ViewHolder(itemRoomBinding.root)



}
