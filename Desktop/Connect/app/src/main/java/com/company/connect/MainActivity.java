package com.company.connect;

import android.bluetooth.BluetoothAdapter;
import android.content.Intent;
import android.os.Bundle;
import android.widget.ImageView;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {
    ImageView on, off, devices, history;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        on = findViewById(R.id.on);
        off = findViewById(R.id.off);
        devices = findViewById(R.id.devices);
        history = findViewById(R.id.history);

        on.setOnClickListener(e -> setBluetooth(true));
        off.setOnClickListener(e -> setBluetooth(false));

        devices = findViewById(R.id.devices);

        devices.setOnClickListener(e -> startActivity(new Intent(this, DeviceList.class)));

        history.setOnClickListener(e -> startActivity(new Intent(this, HistoryActivity.class)));

    }

    public static void setBluetooth(boolean enable) {
        BluetoothAdapter bluetoothAdapter = BluetoothAdapter.getDefaultAdapter();
        boolean isEnabled = bluetoothAdapter.isEnabled();
        if (enable && !isEnabled) {
            bluetoothAdapter.enable();
        }
        else if(!enable && isEnabled) {
            bluetoothAdapter.disable();
        }
    }

}