package com.example.contactlist.domain

class GetContactListUseCase(private val contactListRepository: ContactListRepository) {

    fun getContactList(): List<ContactItem>{
       return contactListRepository.getContactList()
    }
}