package com.omelenko.crud2.contact;

import android.annotation.SuppressLint;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.omelenko.crud2.MainActivity;
import com.omelenko.crud2.R;

import javax.inject.Inject;

public class ContactAdapter extends RecyclerView.Adapter<ContactAdapter.ContactViewHolder> {
    @Inject
    ContactRepository contactRepository;
    private final LayoutInflater inflater;

    public ContactAdapter(Context context) {
        this.inflater = LayoutInflater.from(context);
    }

    public static class ContactViewHolder extends RecyclerView.ViewHolder {
        TextView name;
        TextView one;
        TextView phone;
        TextView two;
        Button editButton;
        Button removeButton;

        @SuppressLint("NotifyDataSetChanged")
        public ContactViewHolder(@NonNull View itemView) {
            super(itemView);
            name = itemView.findViewById(R.id.text_view_name);
            one = itemView.findViewById(R.id.text_view_one);
            phone = itemView.findViewById(R.id.text_view_phone);
            two = itemView.findViewById(R.id.text_view_two);
            editButton = itemView.findViewById(R.id.edit_button);
            removeButton = itemView.findViewById(R.id.remove_button);
        }
    }

    @NonNull
    @Override
    public ContactViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = inflater.inflate(R.layout.contact_list_view, parent, false);
        return new ContactViewHolder(view);
    }

    @SuppressLint("NotifyDataSetChanged")
    @Override
    public void onBindViewHolder(@NonNull ContactViewHolder holder, int position) {
        Contact contact = contactRepository.getContacts().get(position);
        holder.one.setText(contact.getName());
        holder.two.setText(contact.getPhone());
        holder.editButton.setOnClickListener(view -> {
            MainActivity.editCall(position);
            notifyDataSetChanged();
        });
        holder.removeButton.setOnClickListener(view -> {
            contactRepository.removeContact(position);
            notifyDataSetChanged();
        });
    }

    @Override
    public int getItemCount() {
        return contactRepository.getContacts().size();
    }
}
