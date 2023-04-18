package com.example.praktikum4;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.LinearLayoutManager;

import android.os.Bundle;
import android.widget.Toast;

import com.example.praktikum4.databinding.ActivityMainBinding;

public class MainActivity extends AppCompatActivity {
    private ActivityMainBinding binding;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());


        binding.rvChat.setLayoutManager(new LinearLayoutManager(this));
        binding.rvChat.addItemDecoration(
                new DividerItemDecoration(binding.rvChat.getContext(), DividerItemDecoration.VERTICAL)
        );

        ChatAdapter adapter = new ChatAdapter(DataSource.chats);
        adapter.setClickListener(new ChatAdapter.ClickListener() {
            @Override
            public void onChatClicked(Chat chat) {
                Toast.makeText(MainActivity.this, chat.getNama(), Toast.LENGTH_SHORT).show();
                System.out.println(chat.getNama());
            }
        });
        binding.rvChat.setAdapter(adapter);
    }
}