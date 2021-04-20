package me.san.contatcslist.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import me.san.contatcslist.ClickItemContactListener
import me.san.contatcslist.R
import me.san.contatcslist.model.Contact

class ContactAdapter(var listener: ClickItemContactListener) : RecyclerView.Adapter<ContactAdapter.ContactAdapterViewHolder>(){

    private val list: MutableList<Contact> = mutableListOf()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ContactAdapterViewHolder {
        var view = LayoutInflater.from(parent.context).inflate(R.layout.contact_item, parent, false)
        return ContactAdapterViewHolder(view, list, listener)
    }

    override fun getItemCount(): Int {
        return list.size
    }

    override fun onBindViewHolder(holder: ContactAdapterViewHolder, position: Int) {
        holder.bind(list[position])
    }

    fun updateList(list: List<Contact>) {
        this.list.clear()
        this.list.addAll(list)
        notifyDataSetChanged()
    }

    class ContactAdapterViewHolder(itemView: View, list: List<Contact>, var listener: ClickItemContactListener) : RecyclerView.ViewHolder(itemView) {

        private val tvName :TextView = itemView.findViewById(R.id.tv_name)
        private val tvPhone :TextView = itemView.findViewById(R.id.tv_phone)
        private val ivPhotogh :ImageView = itemView.findViewById(R.id.img_photogragh)

        init {
            itemView.setOnClickListener {
                listener.clickItemContact(list[adapterPosition])
            }
        }

        fun bind(contact: Contact) {
            tvName.text = contact.name
            tvPhone.text = contact.phone
            //ivPhotogh.setImageBitmap()
        }
    }

}