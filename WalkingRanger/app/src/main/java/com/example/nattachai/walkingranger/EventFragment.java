package com.example.nattachai.walkingranger;


import android.location.Location;
import android.location.LocationListener;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseExpandableListAdapter;
import android.widget.ExpandableListView;
import android.widget.TextView;
import android.widget.Toast;


<<<<<<< HEAD
=======
import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.location.LocationRequest;
import com.google.android.gms.location.LocationServices;

>>>>>>> origin/test
public class EventFragment extends Fragment {

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_event, null);
        ExpandableListView elv = (ExpandableListView) v.findViewById(R.id.eventlist);
        elv.setAdapter(new SavedTabsListAdapter());
        return v;
    }

    public class SavedTabsListAdapter extends BaseExpandableListAdapter implements
            GoogleApiClient.ConnectionCallbacks, GoogleApiClient.OnConnectionFailedListener, LocationListener {
        protected GoogleApiClient mGoogleApiClient;
        protected Location mCurrentLocation;
        protected LocationRequest mLocationRequest;
        @Override
        public void onLocationChanged(Location location) {
            mCurrentLocation = location;
            Toast.makeText(getActivity(), location.toString() + "", Toast.LENGTH_SHORT).show();
        }
        @Override
        public void onStatusChanged(String provider, int status, Bundle extras) {

        }
        @Override
        public void onProviderEnabled(String provider) {

        }

        @Override
        public void onProviderDisabled(String provider) {

        }

        @Override
        public void onLocationChanged(Location location) {
            mCurrentLocation = location;
    //        mLastUpdateTime = DateFormat.getDateFormat(getActivity()).format(new Date());
            Toast.makeText(getActivity(), location.toString() + "", Toast.LENGTH_SHORT).show();
        }

        @Override
        public void onConnected(Bundle connectionHint) {

        }

        @Override
        public void onConnectionFailed(ConnectionResult result) {
            Log.i("LocationFragment", "Connection failed: ConnectionResult.getErrorCode() " + result.getErrorCode());
        }

        @Override
        public void onConnectionSuspended(int cause) {
            Log.i("LocationFragment", "Connection suspended");
            mGoogleApiClient.connect();
        }

        private String[] groups = { "  Event 1", "  Event 2", "  Event 3", "  Event 4" };

       /* private String[][] children = {
                { "Arnold", "Barry", "Chuck", "David" },
                { "Ace", "Bandit", "Cha-Cha", "Deuce" },
                { "Fluffy", "Snuggles" },
                { "Goldy", "Bubbles" }
        };*/

        private String[][] children = {
                { "         Test1\n\n\n\n\n\n" },
                { "         Test2\n\n\n\n\n\n" },
                { "         Test3\n\n\n\n\n\n" },
                { "         Test4\n\n\n\n\n\n" }
        };

        @Override
        public int getGroupCount() {
            return groups.length;
        }

        @Override
        public int getChildrenCount(int i) {
            return children[i].length;
        }

        @Override
        public Object getGroup(int i) {
            return groups[i];
        }

        @Override
        public Object getChild(int i, int i1) {
            return children[i][i1];
        }

        @Override
        public long getGroupId(int i) {
            return i;
        }

        @Override
        public long getChildId(int i, int i1) {
            return i1;
        }

        @Override
        public boolean hasStableIds() {
            return true;
        }

        @Override
        public View getGroupView(int i, boolean b, View view, ViewGroup viewGroup) {
            TextView textView = new TextView(EventFragment.this.getActivity());
            textView.setText(getGroup(i).toString());
            textView.setTextSize(30);
            return textView;
        }

        @Override
        public View getChildView(int i, int i1, boolean b, View view, ViewGroup viewGroup) {
            TextView textView = new TextView(EventFragment.this.getActivity());
            textView.setText(getChild(i, i1).toString());
            textView.setTextSize(20);
            return textView;
        }

        @Override
        public boolean isChildSelectable(int i, int i1) {
            return true;
        }

    }

}