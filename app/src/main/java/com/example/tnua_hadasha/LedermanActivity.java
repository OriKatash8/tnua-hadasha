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

import com.firebase.ui.firestore.FirestoreRecyclerAdapter;
import com.firebase.ui.firestore.FirestoreRecyclerOptions;
import com.google.firebase.firestore.CollectionReference;
import com.google.firebase.firestore.DocumentReference;
import com.google.firebase.firestore.FieldValue;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.Query;

public class LedermanActivity extends AppCompatActivity {

    private FirebaseFirestore db = FirebaseFirestore.getInstance();
    private CollectionReference productRef = db.collection("Products");

    private static final String TAG = "DocSnippets";
    private FirebaseFirestore firebaseFirestore;
    private RecyclerView mFirestireList;
    private FirestoreRecyclerAdapter adapter;


    //   private ProductsModel adapter;

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
                holder.list_amount.setText(model.getAmount() + "");


                holder.btnPlus.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        String pid  = productRef.getId();
                        DocumentReference documentReference = firebaseFirestore.collection("Products").document(pid);
                        documentReference.update("amount", FieldValue.increment(1));
                        holder.list_amount.setText(Integer.parseInt(holder.list_amount.getText().toString())+1+"");

                    }
                });
                holder.btnMinus.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        String pid= productRef.getId();
                        DocumentReference documentReference = firebaseFirestore.collection("Products").document(pid);
                        documentReference.update("amount",FieldValue.increment(-1));
                        holder.list_amount.setText(Integer.parseInt(holder.list_amount.getText().toString())-1+"");
                    }
                });

                //set amount option - risk!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!


               /* holder.btnMinus.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                   //     Objects.requireNonNull(model).setAmount((int) (model.getAmount()-1));
                    }
                });*/


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
            btnMinus= itemView.findViewById(R.id.btnMinusR);
            btnPlus=itemView.findViewById(R.id.btnPlusR);

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




//
//        Map<String, Object> map = new HashMap<>();
//        documentReference.update(map).addOnSuccessListener(new OnSuccessListener<Void>() {
//            @Override
//            public void onSuccess(Void aVoid) {
//                map.put("amount", +1);
//            }
    //   });


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


