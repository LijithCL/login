package com.example.mvplogin.AdapterClass

import android.content.Context
import android.content.Intent
import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.Toast
import androidx.core.content.ContextCompat.startActivity
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.mvplogin.DataClass.DataX
import com.example.mvplogin.MainActivity
import com.example.mvplogin.MainActivity3
import com.example.mvplogin.databinding.UserItemBinding

class UserDataAdapter (private var context: Context,
private val users: List<DataX>
) : RecyclerView.Adapter<UserDataAdapter.MainHolder>() {

    class MainHolder(private val binding: UserItemBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun bindData(users: List<DataX>, position: Int) {
            binding.txtLotNumber.text = users[position].lot_number
            binding.txtWeight.text = "Weight: "+users[position].weight.toString()+"Kg"
            binding.txtStatus.text = "Section: "+users[position].status
            binding.txtLotType.text = "Lot Type: "+users[position].lot_type
//            binding.txtCost.text = users[position].cost.toString()




        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MainHolder {
        val itemBinding = UserItemBinding.inflate(LayoutInflater.from(context), parent, false)
        return MainHolder(itemBinding)
    }

    override fun onBindViewHolder(holder: MainHolder, position: Int) {
        holder.bindData(users, position)

        holder.itemView.setOnClickListener {
            val data = users[position]
            Toast.makeText(context, data.lot_number, Toast.LENGTH_SHORT)
                .show()
            val intent = Intent(context, MainActivity3::class.java)
            context.startActivity(intent)
        }
    }



    override fun getItemCount(): Int = users.size
}