package com.company.connect;

import static android.content.ContentValues.TAG;

import android.annotation.SuppressLint;
import android.bluetooth.BluetoothAdapter;
import android.os.Build;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.PopupMenu;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.RequiresApi;
import androidx.recyclerview.widget.RecyclerView;

import com.google.android.gms.tasks.OnFailureListener;
import com.google.firebase.firestore.FirebaseFirestore;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class CourseAdapter extends RecyclerView.Adapter<CourseAdapter.Viewholder> {

    private final ArrayList<CourseModel> courseModelArrayList;

    // Constructor
    public CourseAdapter(ArrayList<CourseModel> courseModelArrayList) {
        this.courseModelArrayList = courseModelArrayList;
    }

    @NonNull
    @Override
    public CourseAdapter.Viewholder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        // to inflate the layout for each item of recycler view.
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.card_layout, parent, false);
        return new Viewholder(view);
    }

    @SuppressLint("SetTextI18n")
    @Override
    public void onBindViewHolder(@NonNull CourseAdapter.Viewholder holder, int position) {
        // to set data to textview and imageview of each card layout
        CourseModel model = courseModelArrayList.get(position);
        holder.courseNameTV.setText(model.getCourse_name());
        holder.courseRatingTV.setText("" + model.getCourse_rating());
        holder.courseIV.setImageResource(model.getCourse_image());

        holder.courseIV.setOnClickListener(e -> {
            PopupMenu popup = new PopupMenu(e.getContext(), holder.courseIV);
            popup.getMenuInflater().inflate(R.menu.popup_menu, popup.getMenu());
            popup.setOnMenuItemClickListener(new PopupMenu.OnMenuItemClickListener() {
                @RequiresApi(api = Build.VERSION_CODES.O)
                @Override
                public boolean onMenuItemClick(MenuItem item) {
                    Toast.makeText(e.getContext(), holder.courseNameTV.getText().toString() + " " + item.getTitle() + "ing", Toast.LENGTH_SHORT).show();
                    functionality(item.getTitle().toString(), holder.courseNameTV.getText().toString(), holder.courseRatingTV.getText().toString());
                    return true;
                }
            });
            popup.show();
        });
        holder.courseNameTV.setOnClickListener(e -> {
            PopupMenu popup = new PopupMenu(e.getContext(), holder.courseNameTV);
            popup.getMenuInflater().inflate(R.menu.popup_menu, popup.getMenu());
            popup.setOnMenuItemClickListener(new PopupMenu.OnMenuItemClickListener() {
                @RequiresApi(api = Build.VERSION_CODES.O)
                @Override
                public boolean onMenuItemClick(MenuItem item) {
                    Toast.makeText(e.getContext(), holder.courseNameTV.getText().toString() + " " + item.getTitle() + "ing", Toast.LENGTH_SHORT).show();
                    functionality(item.getTitle().toString(), holder.courseNameTV.getText().toString(), holder.courseRatingTV.getText().toString());
                    return true;
                }
            });
            popup.show();
        });
        holder.courseRatingTV.setOnClickListener(e -> {
            PopupMenu popup = new PopupMenu(e.getContext(), holder.courseRatingTV);
            popup.getMenuInflater().inflate(R.menu.popup_menu, popup.getMenu());
            popup.setOnMenuItemClickListener(new PopupMenu.OnMenuItemClickListener() {
                @RequiresApi(api = Build.VERSION_CODES.O)
                @Override
                public boolean onMenuItemClick(MenuItem item) {
                    Toast.makeText(e.getContext(), holder.courseNameTV.getText().toString() + " " + item.getTitle() + "ing", Toast.LENGTH_SHORT).show();
                    functionality(item.getTitle().toString(), holder.courseNameTV.getText().toString(), holder.courseRatingTV.getText().toString());
                    return true;
                }
            });
            popup.show();
        });
    }

    @RequiresApi(api = Build.VERSION_CODES.O)
    private void functionality(String s, String name, String address) {
        BluetoothAdapter bluetoothAdapter = BluetoothAdapter.getDefaultAdapter();
        LocalDate date = LocalDate.now();
        LocalTime time = LocalTime.now();
        String date_time = date.toString().concat(" " ).concat(time.toString());
        if (s.equals("pair")) {
            add_to_db(name, date_time, address, "pair");
        } else if (s.equals("connect")) {
            add_to_db(name, date_time, address, "connect");
        } else {
            add_to_db(name, date_time, address, "disconnect");
        }
    }

    private void add_to_db(String name, String date_time, String address, String status) {
        FirebaseFirestore db = FirebaseFirestore.getInstance();
        // Create a new user with a first and last name
        Map<String, Object> user = new HashMap<>();
        user.put("date_time", date_time);
        user.put("mac_address", address);
        user.put("name", name);
        user.put("status", status);
        db.collection("users")
                .add(user)
                .addOnSuccessListener(documentReference -> {
                    Log.d(TAG, "DocumentSnapshot added with ID: " + documentReference.getId());
                })
                .addOnFailureListener(new OnFailureListener() {
                    @Override
                    public void onFailure(@NonNull Exception e) {
                        Log.w(TAG, "Error adding document", e);
                    }
                });
    }


    @Override
    public int getItemCount() {
        return courseModelArrayList.size();
    }

    // View holder class for initializing of
    // your views such as TextView and Imageview.
    static class Viewholder extends RecyclerView.ViewHolder {
        private final ImageView courseIV;
        private final TextView courseNameTV;
        private final TextView courseRatingTV;

        public Viewholder(@NonNull View itemView) {
            super(itemView);
            courseIV = itemView.findViewById(R.id.idIVDeviceImage);
            courseNameTV = itemView.findViewById(R.id.idTVDeviceName);
            courseRatingTV = itemView.findViewById(R.id.idTVMacAddress);
        }
    }
}
