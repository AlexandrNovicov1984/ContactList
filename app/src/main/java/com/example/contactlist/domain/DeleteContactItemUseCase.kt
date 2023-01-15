package com.example.contactlist.domain

class DeleteContactItemUseCase(private val contactListRepository: ContactListRepository) {
    fun deleteContactItem(contactItem: ContactItem){
        contactListRepository.deleteContactItem(contactItem)

    }
}