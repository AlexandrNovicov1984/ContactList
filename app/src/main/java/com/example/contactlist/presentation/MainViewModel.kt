package com.example.contactlist.presentation



import androidx.lifecycle.ViewModel
import com.example.contactlist.data.ContactListRepositoryImpl // :(
import com.example.contactlist.domain.ContactItem
import com.example.contactlist.domain.DeleteContactItemUseCase
import com.example.contactlist.domain.EditContactItemUseCase
import com.example.contactlist.domain.GetContactListUseCase

class MainViewModel: ViewModel() {
    private val repository = ContactListRepositoryImpl

    private val getContactListUseCase = GetContactListUseCase(repository)
    private val deleteContactItemUseCase = DeleteContactItemUseCase(repository)
    private val editContactItemUseCase = EditContactItemUseCase(repository)

    val contactList = getContactListUseCase.getContactList()



    fun deleteContactItem(contactItem: ContactItem){
        deleteContactItemUseCase.deleteContactItem(contactItem)

    }
    fun changeEnableState(contactItem: ContactItem){
        val newItem = contactItem.copy(enable = !contactItem.enable)
        editContactItemUseCase.editContactItem(newItem)

    }
}