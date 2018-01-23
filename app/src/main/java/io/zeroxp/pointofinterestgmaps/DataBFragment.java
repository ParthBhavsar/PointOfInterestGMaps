package io.zeroxp.pointofinterestgmaps;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;


public class DataBFragment extends Fragment {



    public DataBFragment() {
        // Required empty public constructor
    }


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_data_b, container, false);

        TextView textView = (TextView) view.findViewById(R.id.textView_data_b);
        textView.setText("TAB B");
        return view;
    }


    @Override
    public void onAttach(Context context) {
        super.onAttach(context);

        setRetainInstance(true);
    }


}
