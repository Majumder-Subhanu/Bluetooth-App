package com.company.connect;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class HistoryAdapter extends RecyclerView.Adapter<HistoryAdapter.ViewHolder> {
    private final ArrayList<HistoryModel> historyModelArrayList;

    public HistoryAdapter(ArrayList<HistoryModel> historyModelArrayList) {
        this.historyModelArrayList = historyModelArrayList;
    }

    @NonNull
    @Override
    public HistoryAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.history_item_list, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull HistoryAdapter.ViewHolder holder, int position) {
        HistoryModel model = historyModelArrayList.get(position);
        holder.idTVDeviceName.setText(model.getDevice_name());
        holder.idTVMacAddress.setText("" + model.getMac_address());
        holder.idTVStatus.setText(model.getStatus());
        holder.idTVDateTime.setText(model.getDate_time());
        holder.idIVDeviceImage.setImageResource(model.getImageView());
    }

    @Override
    public int getItemCount() {
        return historyModelArrayList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        private TextView idTVDeviceName, idTVMacAddress, idTVDateTime, idTVStatus;
        private ImageView idIVDeviceImage;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            idIVDeviceImage = itemView.findViewById(R.id.idIVDeviceImage);
            idTVDeviceName = itemView.findViewById(R.id.idTVDeviceName);
            idTVMacAddress = itemView.findViewById(R.id.idTVMacAddress);
            idTVDateTime = itemView.findViewById(R.id.idTVDateTime);
            idTVStatus = itemView.findViewById(R.id.idTVStatus);
        }
    }
}
