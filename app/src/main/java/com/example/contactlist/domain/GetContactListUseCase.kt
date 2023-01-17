package com.example.contactlist.domain

import androidx.lifecycle.LiveData

class GetContactListUseCase(private val contactListRepository: ContactListRepository) {

    fun getContactList(): LiveData<List<ContactItem>> {
       return contactListRepository.getContactList()
    }
}