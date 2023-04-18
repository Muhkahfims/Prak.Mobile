package com.example.praktikum4;


import android.view.LayoutInflater;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.praktikum4.databinding.ItemChatBinding;

import java.util.ArrayList;

public class ChatAdapter extends RecyclerView.Adapter<ChatAdapter.ViewHolder> {

    private ArrayList<Chat> chats;
    private ClickListener clickListener;

    public void setClickListener(ClickListener clickListener) {
        this.clickListener = clickListener;
    }

    public ChatAdapter(ArrayList<Chat> chats){
        this.chats = chats;
    }



    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        ItemChatBinding binding = ItemChatBinding.inflate(
                LayoutInflater.from(parent.getContext()), parent, false
        );
        return new ViewHolder(binding);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        holder.onBind(chats.get(position));
    }

    @Override
    public int getItemCount() {
        return chats.size();
    }

    class ViewHolder extends RecyclerView.ViewHolder {
        private ItemChatBinding binding;
        public ViewHolder(@NonNull ItemChatBinding binding) {
            super(binding.getRoot());
            this.binding = binding;
        }

        public void onBind(Chat chat){
            binding.getRoot().setOnClickListener(view -> {
                clickListener.onChatClicked(chat);
            });

            binding.tvNama.setText(chat.getNama());
            binding.tvIsiChat.setText(chat.getChat());
            binding.tvWaktu.setText(chat.getWaktu());
        }
    }

    interface ClickListener{
        void onChatClicked(Chat chat);
    }
}