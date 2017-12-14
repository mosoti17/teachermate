package ml.elvismogaka.teachermate.ui;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import ml.elvismogaka.teachermate.R;

/**
 * A simple {@link Fragment} subclass.
 */
public class TimetableFragment extends Fragment {

    public static  TimetableFragment newInstance(){
        TimetableFragment timetableFragment= new TimetableFragment();
        return timetableFragment;

    }


    public TimetableFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_timetable, container, false);
    }

}
