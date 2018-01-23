package io.zeroxp.pointofinterestgmaps;

import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;


public class InnerFragment extends Fragment {


    private int pageNumber;
    private TextView innerTextView;

    public InnerFragment() {
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
        View view = inflater.inflate(R.layout.fragment_inner, container, false);

        innerTextView = (TextView) view.findViewById(R.id.textView_inner);
        innerTextView.setText(pageNumber+"");
        return view;
    }

    public void setPageNumber(int pageNumber) {
        this.pageNumber = pageNumber;

    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);

        setRetainInstance(true);
    }
}
