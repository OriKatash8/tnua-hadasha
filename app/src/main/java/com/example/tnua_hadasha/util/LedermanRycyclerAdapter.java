package com.example.tnua_hadasha.util;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.tnua_hadasha.ProductsModel;
import com.example.tnua_hadasha.R;
import com.firebase.ui.firestore.FirestoreRecyclerAdapter;
import com.firebase.ui.firestore.FirestoreRecyclerOptions;

public class LedermanRycyclerAdapter extends FirestoreRecyclerAdapter<ProductsModel,ProductsViewHolder> {


    /**
     * Create a new RecyclerView adapter that listens to a Firestore Query.  See {@link
     * FirestoreRecyclerOptions} for configuration options.
     *
     * @param options
     */
    public LedermanRycyclerAdapter(@NonNull FirestoreRecyclerOptions<ProductsModel> options) {
        super(options);
    }

    @Override
    protected void onBindViewHolder(@NonNull ProductsViewHolder holder, int position, @NonNull ProductsModel model) {
        holder.list_name.setText(model.getName());
        holder.list_amount.setText(model.getAmount()+"");

    }

    @NonNull
    @Override
    public ProductsViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.list_item_single, parent, false);

        return new ProductsViewHolder(view);
    }
}
    class ProductsViewHolder extends RecyclerView.ViewHolder {

     TextView list_name;
     TextView list_amount;

    public ProductsViewHolder(@NonNull View itemView) {
        super(itemView);

        list_name = itemView.findViewById(R.id.list_name);
        list_amount = itemView.findViewById(R.id.list_amount);
    }
}