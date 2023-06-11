package com.example.tpraktikum6;

import android.view.LayoutInflater;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.tpraktikum6.databinding.ItemCardBinding;

import java.util.LinkedList;

public class PostAdapter extends RecyclerView.Adapter<PostAdapter.PostViewHolder>{

    private final LinkedList<Post> posts;

    public PostAdapter(LinkedList<Post> posts) {this.posts = posts;}

    @NonNull
    @Override
    public PostAdapter.PostViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        ItemCardBinding binding = ItemCardBinding.inflate(LayoutInflater.from(parent.getContext()), parent, false);
        return new PostViewHolder(binding);
    }

    @Override
    public void onBindViewHolder(@NonNull PostAdapter.PostViewHolder holder, int position) {
        holder.onBind(posts.get(position));
    }

    @Override
    public int getItemCount() {
        return this.posts.size();
    }

    public class PostViewHolder extends RecyclerView.ViewHolder {
        private ItemCardBinding binding;

        public PostViewHolder(@NonNull ItemCardBinding itemView) {
            super(itemView.getRoot());
            this.binding = itemView;
        }

        public void onBind(Post post) {
            binding.imageView.setImageURI(post.getImageUri());
            binding.caption.setText(post.getCaption());
        }
    }
}


