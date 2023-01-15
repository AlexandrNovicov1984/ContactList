package com.example.contactlist.data

import com.example.contactlist.domain.ContactItem
import com.example.contactlist.domain.ContactListRepository

object ContactListRepositoryImpl : ContactListRepository {


    private val contactList = mutableListOf<ContactItem>()

    private var autoIncrementId = 0

    override fun addContactItem(contactItem: ContactItem) {
        if (contactItem.id == ContactItem.UNDEFINED_ID) {
            contactItem.id = autoIncrementId++
        }

        contactList.add(contactItem)
    }

    override fun deleteContactItem(contactItem: ContactItem) {
        contactList.remove(contactItem)
    }

    override fun editContactItem(contactItem: ContactItem) {
        val oldElement = getContactItem(contactItem.id)
        contactList.remove(oldElement)
        addContactItem(contactItem)
    }

    override fun getContactItem(contactItemId: Int): ContactItem {
        return contactList.find { it.id == contactItemId }
            ?: throw RuntimeException("Element with id $contactItemId not found")
    }

    override fun getContactList(): List<ContactItem> {
        return contactList.toList()
    }
}