package com.example.contactlist.domain

class AddContactItemUseCase(private val contactListRepository: ContactListRepository) {
    fun addContactItem(contactItem: ContactItem){
        contactListRepository.addContactItem(contactItem)

    }
}