package com.example.android.myapplication;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.net.wifi.p2p.WifiP2pManager;
import android.widget.Toast;

/**
 * Created by SOFIA on 8/27/2017.
 */

public class WiFiDirectBroadcastReceiver extends BroadcastReceiver {
    WifiP2pManager mWifiP2pManager;
    WifiP2pManager.Channel mChannel;
    MainActivity mMainActivity;
    public WiFiDirectBroadcastReceiver(WifiP2pManager manager, WifiP2pManager.Channel channel,
                                      MainActivity mMainActivity) {
        super();
        this.mWifiP2pManager = manager;
        this.mChannel = channel;
        this.mMainActivity = mMainActivity;
    }

    @Override
    public void onReceive(Context context, Intent intent) {
        String action = intent.getAction();

        if (WifiP2pManager.WIFI_P2P_STATE_CHANGED_ACTION.equals(action)) {
            // Check to see if Wi-Fi is enabled and notify appropriate activity
            Toast.makeText(context,"WIFI Enabled",Toast.LENGTH_SHORT).show();
        } else if (WifiP2pManager.WIFI_P2P_PEERS_CHANGED_ACTION.equals(action)) {
            // Call WifiP2pManager.requestPeers() to get a list of current peers
            Toast.makeText(context,"LIST OF CURRENT PEERS",Toast.LENGTH_SHORT).show();
        } else if (WifiP2pManager.WIFI_P2P_CONNECTION_CHANGED_ACTION.equals(action)) {
            // Respond to new connection or disconnections
            Toast.makeText(context,"NEW CONNECTION",Toast.LENGTH_SHORT).show();
        } else if (WifiP2pManager.WIFI_P2P_THIS_DEVICE_CHANGED_ACTION.equals(action)) {
            // Respond to this device's wifi state changing
            Toast.makeText(context,"WIFI STATE CHANGING",Toast.LENGTH_SHORT).show();
        }
        if (WifiP2pManager.WIFI_P2P_STATE_CHANGED_ACTION.equals(action)) {
            int state = intent.getIntExtra(WifiP2pManager.EXTRA_WIFI_STATE, -1);
            if (state == WifiP2pManager.WIFI_P2P_STATE_ENABLED) {
                Toast.makeText(context,"WIFI Enabled",Toast.LENGTH_SHORT).show();
            } else {
                Toast.makeText(context,"WIFI not Enabled",Toast.LENGTH_SHORT).show();
            }
        }
    }
}

