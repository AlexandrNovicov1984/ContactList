package com.example.contactlist.presentation

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.widget.ImageView
import android.widget.LinearLayout
import android.widget.TextView
import androidx.lifecycle.ViewModelProvider
import com.example.contactlist.R
import com.example.contactlist.domain.ContactItem

class MainActivity : AppCompatActivity() {

    private lateinit var viewModel: MainViewModel
    private lateinit var llContactList: LinearLayout

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        llContactList = findViewById(R.id.ll_contact_list)
        viewModel = ViewModelProvider(this)[MainViewModel::class.java]
        viewModel.contactList.observe(this) {
            showList(it)

        }
    }

    private fun showList(list: List<ContactItem>) {
        llContactList.removeAllViews()
        for (contactItem in list) {
            val layoutId = if (contactItem.enable) {
                R.layout.item_contact_enabled
            } else {
                R.layout.item_contact_disabled

            }

            val view = LayoutInflater.from(this).inflate(layoutId, llContactList, false)

            val tvName = view.findViewById<TextView>(R.id.tv_name)
            val tvLastName = view.findViewById<TextView>(R.id.tv_lastname)
            val tvBirthday = view.findViewById<TextView>(R.id.tv_birthday)
           // val ivIcon = view.findViewById<ImageView>(R.id.iv_icon)

            tvName.text = contactItem.name
            tvLastName.text = contactItem.lastName
            tvBirthday.text = contactItem.birthday

            view.setOnLongClickListener{
                viewModel.changeEnableState(contactItem)
                true
            }







            llContactList.addView(view)
        }

    }

}


