package com.example.contactlist.domain

data class ContactItem(
     val name: String,
     val lastName: String,
     val birthday: String,
     val enable: Boolean,
     var id: Int = UNDEFINED_ID
) {
    companion object{
        const val UNDEFINED_ID = -1
    }
}