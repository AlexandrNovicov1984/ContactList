package com.example.contactlist.data

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.example.contactlist.domain.ContactItem
import com.example.contactlist.domain.ContactListRepository

object ContactListRepositoryImpl : ContactListRepository {

    private val contactListLD = MutableLiveData<List<ContactItem>>()
    private val contactList = sortedSetOf<ContactItem>({o1, o2 -> o1.id compareTo o2.id})


    private var autoIncrementId = 0

    init {
        for (i in 0 until 10){
            val item = ContactItem("Name $i", "LastName $i",
                "BirthDay $i", true)
            addContactItem(item)
        }
    }

    override fun addContactItem(contactItem: ContactItem) {
        if (contactItem.id == ContactItem.UNDEFINED_ID) {
            contactItem.id = autoIncrementId++
        }

        contactList.add(contactItem)
        updateList()
    }

    override fun deleteContactItem(contactItem: ContactItem) {
        contactList.remove(contactItem)
        updateList()
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

    override fun getContactList(): LiveData<List<ContactItem>> {
        return contactListLD
    }

    private fun updateList(){
        contactListLD.value = contactList.toList()
    }
}