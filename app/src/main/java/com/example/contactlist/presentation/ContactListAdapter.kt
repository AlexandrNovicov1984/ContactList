package com.example.contactlist.presentation

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.contactlist.R
import com.example.contactlist.domain.ContactItem

class ContactListAdapter : RecyclerView.Adapter<ContactListAdapter.ContactItemViewHolder>() {

    val list = listOf<ContactItem>()




    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ContactItemViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.item_contact_disabled, parent, false)
        return ContactItemViewHolder(view)

    }

    override fun getItemCount(): Int {
        return list.size
    }

    override fun onBindViewHolder(viewHolder: ContactItemViewHolder, position: Int) {
        val contactItem = list[position]

        viewHolder.tvName.text = contactItem.name
        viewHolder.tvLastName.text = contactItem.lastName
        viewHolder.tvBirthday.text = contactItem.birthday

        viewHolder.view.setOnLongClickListener {

            true
        }
    }

    class ContactItemViewHolder(val view: View) : RecyclerView.ViewHolder(view){
        val tvName = view.findViewById<TextView>(R.id.tv_name)
        val tvLastName = view.findViewById<TextView>(R.id.tv_lastname)
        val tvBirthday = view.findViewById<TextView>(R.id.tv_birthday)
    }
}