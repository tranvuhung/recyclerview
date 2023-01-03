package com.vuhungtran.recyclerview

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.vuhungtran.recyclerview.databinding.ItemContactBinding

// Create the basic adapter extending from RecyclerView.Adapter
// Note that we specify the custom ViewHolder which gives us access to our views
class ContactsAdapter(private val mContacts: List<Contact>) : RecyclerView.Adapter<ContactsAdapter.MainViewHolder>() {
    // Provide a direct reference to each of the views within a data item
    // Used to cache the views within the item layout for fast access
    inner class MainViewHolder(private val itemBinding: ItemContactBinding) : RecyclerView.ViewHolder(itemBinding.root) {
        fun bindItem(contact: Contact){
            itemBinding.contactName.text = contact.name
            itemBinding.messageButton.text = if (contact.isOnline) "Message" else "Offline"
            itemBinding.messageButton.isEnabled = contact.isOnline
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MainViewHolder {
        return MainViewHolder(ItemContactBinding.inflate(LayoutInflater.from(parent.context), parent, false))
    }

    override fun onBindViewHolder(holder: MainViewHolder, position: Int) {
        // Get the data model based on position
        val contact: Contact = mContacts.get(position)
        // Set item views based on your views and data model
        holder.bindItem(contact)
    }

    override fun getItemCount(): Int {
        return mContacts.size
    }
}