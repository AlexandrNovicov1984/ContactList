package com.example.contactlist.domain

import androidx.lifecycle.LiveData

interface ContactListRepository {
    fun addContactItem(contactItem: ContactItem)

    fun deleteContactItem(contactItem: ContactItem)

    fun editContactItem(contactItem: ContactItem)

    fun getContactItem(contactItemId: Int): ContactItem

    fun getContactList(): LiveData<List<ContactItem>>


}