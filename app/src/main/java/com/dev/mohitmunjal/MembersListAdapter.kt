package com.dev.mohitmunjal

import android.text.Editable
import android.text.TextWatcher
import android.util.Log
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.dev.mohitmunjal.databinding.ItemMemberBinding
import com.dev.mohitmunjal.databinding.ItemMemberDetailsBinding

private const val TAG = "mohit"
class MembersListAdapter(private val activity:RoomListActivity,private val members: ArrayList<Member>) : RecyclerView.Adapter<MembersListAdapter.MemberViewHolder>() {



    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MemberViewHolder {
        var itemRoomBinding= ItemMemberDetailsBinding.inflate(LayoutInflater.from(activity),parent,false)
        return MemberViewHolder(itemRoomBinding)

    }


    override fun getItemCount(): Int = members.size

    override fun onBindViewHolder(holder: MemberViewHolder, position: Int) {
        var member=members[position]
        holder.itemRoomBinding.member=member
        holder.itemRoomBinding.tvSerialNumber.text=position.toString()




    }


    class MemberViewHolder(var itemRoomBinding: ItemMemberDetailsBinding) : RecyclerView.ViewHolder(itemRoomBinding.root)



}
