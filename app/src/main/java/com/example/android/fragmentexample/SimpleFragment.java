package com.example.android.fragmentexample;


import android.os.Bundle;
import android.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RadioGroup;
import android.widget.RatingBar;
import android.widget.TextView;
import android.widget.Toast;


/**
 * A simple {@link Fragment} subclass.
 */
public class SimpleFragment extends Fragment {

    public static final int YES = 1;
    public static final int NO= 0;
    public SimpleFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(final LayoutInflater inflater, final ViewGroup container,
                             Bundle savedInstanceState) {
        final View rootview = inflater.inflate(R.layout.fragment_simple,container,false);

        final RadioGroup radiogroup = (RadioGroup) rootview.findViewById(R.id.radio_group);

        radiogroup.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                View radiotoon= radiogroup.findViewById(checkedId);
                int index = radiogroup.indexOfChild(radiotoon);
                TextView textView = rootview.findViewById(R.id.fragment_header);

                if(index==1){
                    textView.setText(R.string.yes_message);
                }
                else {
                    textView.setText(R.string.no_message);
                }
            }
        });
        final RatingBar ratingBar = rootview.findViewById(R.id.song_ratingbar);
        ratingBar.setOnRatingBarChangeListener(new RatingBar.OnRatingBarChangeListener() {
            @Override
            public void onRatingChanged(RatingBar ratingBar, float rating, boolean fromUser) {
                Toast.makeText(rootview.getContext(), Float.toString(rating), Toast.LENGTH_SHORT).show();
            }
        });
        // Inflate the layout for this fragment
        return  rootview;

    }

}
