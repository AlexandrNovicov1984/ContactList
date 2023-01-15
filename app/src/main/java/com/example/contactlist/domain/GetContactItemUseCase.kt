package com.example.contactlist.domain

class GetContactItemUseCase(private val contactListRepository: ContactListRepository) {

    fun getContactItem(contactItemId: Int): ContactItem {
      return  contactListRepository.getContactItem(contactItemId)

    }
}