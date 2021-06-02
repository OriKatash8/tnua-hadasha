package com.example.tnua_hadasha;

import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.firebase.ui.firestore.FirestoreRecyclerOptions;

public class ProductsModel extends RecyclerView.Adapter {
    private String name;
    private int amount;

    public ProductsModel(FirestoreRecyclerOptions<ProductsModel> options) {
    }

    public ProductsModel(String name, int amount) {
        this.name = name;
        this.amount = amount;

    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAmount() {
        return amount;
    }

    public void setAmount(int amount) {
        this.amount = amount;
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return null;
    }

    @NonNull
    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {

    }

    @Override
    public int getItemCount() {
        return 0;
    }

    public void startListening() {
    }

    public void stopListening() {
    }
}
