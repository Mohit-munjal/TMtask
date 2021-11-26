package com.dev.mohitmunjal

import android.text.Editable
import android.text.TextWatcher
import android.util.Log
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.dev.mohitmunjal.databinding.ItemMemberBinding

private const val TAG = "mohit"
class MemberAdapter(private val activity:MainActivity,private val members: ArrayList<Member>) : RecyclerView.Adapter<MemberAdapter.MemberViewHolder>() {



    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MemberViewHolder {
        var itemRoomBinding= ItemMemberBinding.inflate(LayoutInflater.from(activity),parent,false)
        return MemberViewHolder(itemRoomBinding)

    }


    override fun getItemCount(): Int = members.size

    override fun onBindViewHolder(holder: MemberViewHolder, position: Int) {
        var member=members[position]
        Log.d(TAG, "onBindViewHolder: member "+member.toString())
        holder.itemRoomBinding.tvType.text=member.type
        holder.itemRoomBinding.etAge.setText(member.age.toString())
        holder.itemRoomBinding.etName.setText(member.name)

        holder.itemRoomBinding.etName.addTextChangedListener(object :TextWatcher{
            override fun beforeTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {

            }

            override fun onTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {
                p0?.let {
                    var name=it.toString()
                    member.name=name
                }
            }

            override fun afterTextChanged(p0: Editable?) {
            }

        })
        holder.itemRoomBinding.etAge.addTextChangedListener(object :TextWatcher{
            override fun beforeTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {

            }

            override fun onTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {
                p0?.let {

                    var text=it.toString()
                    if(!text.isNullOrEmpty())
                    {
                        var type=member.type
                        var age=text.toInt()
                        if(type.equals("Adult"))
                        {
                            if(age<18)
                            {
                                holder.itemRoomBinding.etAge.error="Age should be above 18"
                                holder.itemRoomBinding.etAge.requestFocus()

                            }
                            else
                            {
                                member.age=age.toString()
                            }
                        }
                        else
                        {
                            if(age>18)
                            {
                                holder.itemRoomBinding.etAge.error="Age should be below 18"
                                holder.itemRoomBinding.etAge.requestFocus()

                            }
                            else
                            {
                                member.age=age.toString()
                            }
                        }
                    }

                }
            }

            override fun afterTextChanged(p0: Editable?) {
            }

        })



    }

    fun addMembers(members: ArrayList<Member>) {
        this.members.apply {
            clear()
            addAll(members)
        }

    }
    class MemberViewHolder(var itemRoomBinding: ItemMemberBinding) : RecyclerView.ViewHolder(itemRoomBinding.root)



}
