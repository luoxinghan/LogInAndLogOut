package com.example.luo.loginandlogout.data.adapters;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.luo.loginandlogout.R;
import com.example.luo.loginandlogout.data.modules.FileUser;

import java.util.List;

public class ContactsAdapters extends RecyclerView.Adapter<ContactsAdapters.ContactViewHolder> {

    private final String TAG = "ContactAdaptersLogs";
    private List<FileUser> fileUsers;

    public ContactsAdapters(List<FileUser> fileUsers) {
        this.fileUsers = fileUsers;
    }

    @NonNull
    @Override
    public ContactViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.layout_contact, viewGroup,false);
        return new ContactViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ContactViewHolder contactViewHolder, int i) {
        Log.d(TAG, "onBindViewHolder: " + i);
        FileUser fileUser = fileUsers.get(i);

        contactViewHolder.mName.setText("Name: " + fileUser.getName());
        contactViewHolder.mPhone.setText("TEL: " + fileUser.getPhone());
    }

    @Override
    public int getItemCount() {
        return fileUsers.size();
    }

    public class ContactViewHolder extends RecyclerView.ViewHolder {
        private TextView mName;
        private TextView mPhone;

        public ContactViewHolder(@NonNull View itemView) {
            super(itemView);
            mName = itemView.findViewById(R.id.contact_text_view_name);
            mPhone = itemView.findViewById(R.id.contact_text_view_phone);
        }
    }
}
