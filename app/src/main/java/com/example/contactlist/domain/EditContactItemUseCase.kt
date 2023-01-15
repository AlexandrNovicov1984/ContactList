package com.example.contactlist.domain

class EditContactItemUseCase(private val contactListRepository: ContactListRepository) {
    fun editContactItem(contactItem: ContactItem){
        contactListRepository.editContactItem(contactItem)

    }
}