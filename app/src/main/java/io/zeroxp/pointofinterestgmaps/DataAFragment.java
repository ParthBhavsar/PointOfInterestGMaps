package io.zeroxp.pointofinterestgmaps;


import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;


public class DataAFragment extends Fragment {


    public DataAFragment() {
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
        View view = inflater.inflate(R.layout.fragment_data_a, container, false);

        TextView textView = (TextView) view.findViewById(R.id.textView_data_a);
        textView.setText("TAB A");
        return view;
    }


    @Override
    public void onAttach(Context context) {
        super.onAttach(context);

        setRetainInstance(true);
    }



}
