package com.example.contactlist.domain

interface ContactListRepository {
    fun addContactItem(contactItem: ContactItem)

    fun deleteContactItem(contactItem: ContactItem)

    fun editContactItem(contactItem: ContactItem)

    fun getContactItem(contactItemId: Int): ContactItem

    fun getContactList(): List<ContactItem>


}