package com.example.contactlist.domain

data class ContactItem(
    val id: Int, val name: String, val lastName: String, val birthday: String, val enable: Boolean
) {
}