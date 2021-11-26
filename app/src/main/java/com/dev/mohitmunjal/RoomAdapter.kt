package com.dev.mohitmunjal

import android.util.Log
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.dev.mohitmunjal.databinding.ItemRoomBinding

private const val TAG = "mohit"
class RoomAdapter(private val activity:MainActivity,private val rooms: ArrayList<Room>) : RecyclerView.Adapter<RoomAdapter.RoomViewHolder>() {



    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RoomViewHolder {
        var itemRoomBinding= ItemRoomBinding.inflate(LayoutInflater.from(activity),parent,false)
        return RoomViewHolder(itemRoomBinding)

    }


    override fun getItemCount(): Int = rooms.size

    override fun onBindViewHolder(holder: RoomViewHolder, position: Int) {
        var room=rooms[position]
        holder.itemRoomBinding.tvType.text="Room ${room.number}"
        var memberAdapter=MemberAdapter(activity, room.members)
        holder.itemRoomBinding.rvMembers.apply {
            layoutManager=LinearLayoutManager(activity,LinearLayoutManager.VERTICAL,false)
            adapter=memberAdapter
        }
        holder.itemRoomBinding.btnAdd.setOnClickListener {
            var adult=holder.itemRoomBinding.etAdult.text.toString()
            var child=holder.itemRoomBinding.etChild.text.toString()
            if(adult.isNullOrEmpty())
            {
                holder.itemRoomBinding.etAdult.error="Field cant be empty!"
                holder.itemRoomBinding.etAdult.requestFocus()
                return@setOnClickListener
            }
            if(child.isNullOrEmpty())
            {
                holder.itemRoomBinding.etChild.error="Field cant be empty!"
                holder.itemRoomBinding.etChild.requestFocus()
                return@setOnClickListener
            }
            var numbAdult=adult.toInt()
            var numbChild=child.toInt()
            room.adult=adult
            room.child=child
            for(i in 1..numbAdult)
            {
                var member=Member("Adult")
                room.members.add(member)
            }
            for(i in 1..numbChild)
            {
                var member=Member("Child")
                room.members.add(member)
            }
            room.members.forEach {
                Log.d(TAG, "onBindViewHolder: member "+it.toString())
            }
//            memberAdapter.apply {
//                addMembers(room.members)
//                notifyDataSetChanged()
//            }
            notifyDataSetChanged()

        }



    }

    fun addRooms(rooms: ArrayList<Room>) {
        this.rooms.apply {
            clear()
            addAll(rooms)
        }

    }
    class RoomViewHolder(var itemRoomBinding: ItemRoomBinding) : RecyclerView.ViewHolder(itemRoomBinding.root)



}
