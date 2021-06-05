package com.example.tnua_hadasha;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;
import com.example.tnua_hadasha.util.LedermanRycyclerAdapter;
import com.firebase.ui.firestore.FirestoreRecyclerAdapter;
import com.firebase.ui.firestore.FirestoreRecyclerOptions;
import com.google.firebase.firestore.CollectionReference;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.Query;

import java.util.Objects;

public class LedermanActivity extends AppCompatActivity {
    private FirebaseFirestore db = FirebaseFirestore.getInstance();
    private CollectionReference productRef = db.collection("Products");


    private FirebaseFirestore firebaseFirestore;
    private RecyclerView mFirestireList;
    private FirestoreRecyclerAdapter adapter;

 //   private ProductsModel adapter;
   private Button btnPlus, btnMinus;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lederman);

        firebaseFirestore = FirebaseFirestore.getInstance();
        mFirestireList=findViewById(R.id.firestore_list);


        //Query
        Query query = firebaseFirestore.collection("Products");


        //RecyclerOptions

        FirestoreRecyclerOptions<ProductsModel>options = new FirestoreRecyclerOptions.Builder<ProductsModel>()
                .setQuery(query, ProductsModel.class).build();

         adapter = new FirestoreRecyclerAdapter<ProductsModel, ProductsViewHolder>(options) {
            @NonNull
            @Override
            public ProductsViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
                View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.list_item_single, parent, false);
                return new ProductsViewHolder(view);
            }

            @Override
            protected void onBindViewHolder(@NonNull ProductsViewHolder holder, int position, @NonNull ProductsModel model) {

            holder.list_name.setText(model.getName());
            holder.list_amount.setText(model.getAmount()+ "");

            //set amount option - risk!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!

            holder.btnPlus.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    
                }
            });
                holder.btnMinus.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Objects.requireNonNull(model).setAmount((int) (model.getAmount()-1));
                    }
                });


            }
        };
        //View Holder
        mFirestireList.setHasFixedSize(true);
        mFirestireList.setLayoutManager(new LinearLayoutManager(this));
        mFirestireList.setAdapter(adapter);
            }

    private class ProductsViewHolder  extends RecyclerView.ViewHolder{

        private TextView list_name;
        private TextView list_amount;
        private Button btnPlus;
        private Button btnMinus;


        public ProductsViewHolder(@NonNull View itemView) {
            super(itemView);

            list_name = itemView.findViewById(R.id.list_name);
            list_amount = itemView.findViewById(R.id.list_amount);
           btnMinus= findViewById(R.id.btnMinus);
            btnPlus=findViewById(R.id.btnPlus);
        }

    }
    @Override
    protected void onStart() {
        super.onStart();
        adapter.startListening();
    }

    @Override
    protected void onStop() {
        super.onStop();
        adapter.stopListening();
    }
}


/*


        //setUpRecyclerView();

      /*  btnPlus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                adapter.setAmount(adapter.getAmount()+1);
            }
        });
        btnMinus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                adapter.setAmount(adapter.getAmount()-1);
            }
        });*/



   /* private  void  setUpRecyclerView()
    {
        Query query = productRef.orderBy("name" , Query.Direction.DESCENDING);

        FirestoreRecyclerOptions<ProductsModel> options = new FirestoreRecyclerOptions.Builder<ProductsModel>().setQuery(query, ProductsModel.class).build();

        adapter = new ProductsModel(options);

        RecyclerView recyclerView = findViewById(R.id.firestore_list);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setAdapter(adapter);
    }
*/


