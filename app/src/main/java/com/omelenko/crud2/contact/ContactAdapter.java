package com.omelenko.crud2.contact;

import android.annotation.SuppressLint;
import android.view.LayoutInflater;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.databinding.DataBindingUtil;
import androidx.recyclerview.widget.RecyclerView;

import com.omelenko.crud2.App;
import com.omelenko.crud2.R;
import com.omelenko.crud2.databinding.ContactListViewBinding;
import com.omelenko.crud2.viewmodel.ListViewModel;

public class ContactAdapter extends RecyclerView.Adapter<ContactAdapter.ContactViewHolder> {
    private ListViewModel viewModel;
    public ContactAdapter(ListViewModel listViewModel)
    {
        this.viewModel = listViewModel;
    }

    @NonNull
    @Override
    public ContactViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        ContactListViewBinding binding = DataBindingUtil.
                inflate(LayoutInflater.from(parent.getContext()),
                        R.layout.contact_list_view,
                        parent,
                        false);
        return new ContactViewHolder(binding);
    }

    @Override
    public void onAttachedToRecyclerView(@NonNull RecyclerView recyclerView) {
        super.onAttachedToRecyclerView(recyclerView);
        App.getComponent().injectsListViewModel(viewModel);
    }

    @Override
    public void onBindViewHolder(@NonNull ContactViewHolder holder, int position) {
        Contact contact = viewModel.getContact(position);
        holder.bind(contact);
    }

    @Override
    public int getItemCount() {
        return viewModel.getContacts().size();
    }

    public class ContactViewHolder extends RecyclerView.ViewHolder {
        private final ContactListViewBinding binding;
        public ContactViewHolder(ContactListViewBinding binding) {
            super(binding.getRoot());
            this.binding = binding;
        }
        public void bind(Contact contact) {
            binding.setContact(contact);
            binding.setViewModel(viewModel);
            binding.executePendingBindings();
        }
    }


}