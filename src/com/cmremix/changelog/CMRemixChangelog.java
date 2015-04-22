package com.cmremix.changelog;

import android.os.AsyncTask;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.cmremix.ota.R;

public class CMRemixChangelog extends Fragment {

    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.cmremix_changelog, container, false);
        return view;
    }

    @Override
    public void onActivityCreated(Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);

        ReadChangelog rc = new ReadChangelog() {
            @Override
            public void onResponseReceived(String result) {
                final TextView changelogTextView = (TextView) getView().findViewById(R.id.tv_changelog);
                if (changelogTextView == null) {
                    return;
                }
                changelogTextView.setText(result);
            }
        };
        rc.execute(getActivity());
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public void onResume() {
        super.onResume();
    }
}
