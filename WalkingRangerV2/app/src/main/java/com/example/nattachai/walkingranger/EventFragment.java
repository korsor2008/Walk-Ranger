package com.example.nattachai.walkingranger;
import android.content.DialogInterface;
import android.content.Intent;
import android.location.Location;
import android.os.Bundle;
import android.support.v4.app.ListFragment;
import android.support.v7.app.AlertDialog;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.Toast;

import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.location.LocationServices;

import java.util.ArrayList;
public class EventFragment extends ListFragment implements GoogleApiClient.ConnectionCallbacks, GoogleApiClient.OnConnectionFailedListener {
    ArrayList<String> listEvent = new ArrayList<>();
    private GoogleApiClient mGoogleApiClient;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        listEvent.add("kkkk1");
        listEvent.add("kkkk2");
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(
                inflater.getContext(), android.R.layout.simple_list_item_1,
                listEvent);
        setListAdapter(adapter);
        return super.onCreateView(inflater, container, savedInstanceState);
        
    }


    @Override
    public void onListItemClick(ListView l, View v, int position, long id) {

        mGoogleApiClient = new GoogleApiClient.Builder(getActivity())
                .addApi(LocationServices.API)
                .addConnectionCallbacks(this)
                .addOnConnectionFailedListener(this)
                .build();
        ImageView image = new ImageView(this.getActivity());
        image.setImageResource(R.drawable.ic_person_black_24dp);
        AlertDialog.Builder builder =
                new AlertDialog.Builder(this.getActivity());
        builder.setMessage("รับขนมจีบซาลาเปาเพิ่มมั้ยครับ?\n\n\n");
        builder.setView(image);
        builder.setPositiveButton("รับ", new DialogInterface.OnClickListener() {
            public void onClick(DialogInterface dialog, int id) {

                mGoogleApiClient.connect();//ไปคำสั่ง onConnected

            }
        });
        builder.setNegativeButton("ไม่รับ", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                //dialog.dismiss();
            }
        });
        builder.show();
    }

    @Override
    public void onConnected(Bundle bundle) {

        Location lastLocation = LocationServices.FusedLocationApi.getLastLocation(mGoogleApiClient);
        if (lastLocation != null) {
            //ส่ง lastLocation.getLatitude() กับ lastLocation.getLongitude() ไปเซิพเวอร์
            Toast.makeText(getActivity(),String.valueOf(lastLocation.getLatitude()) , Toast.LENGTH_LONG).show();

            mGoogleApiClient.disconnect();
        } else {

        }
    }

    @Override
    public void onConnectionSuspended(int i) {
        mGoogleApiClient.connect();
    }

    @Override
    public void onConnectionFailed(ConnectionResult connectionResult) {

    }
}