package com.company.connect;

import static android.content.ContentValues.TAG;

import android.os.Bundle;
import android.util.Log;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;

import com.google.android.gms.tasks.Task;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.QueryDocumentSnapshot;
import com.google.firebase.firestore.QuerySnapshot;

import java.util.ArrayList;
import java.util.Map;
import java.util.Objects;

public class HistoryActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_history);
        FirebaseFirestore db = FirebaseFirestore.getInstance();
        RecyclerView idRVHistoryList = findViewById(R.id.idRVHistoryList);
        ArrayList<HistoryModel> historyModelArrayList = new ArrayList<>();

        idRVHistoryList.setAdapter(new HistoryAdapter(historyModelArrayList));
    }
}