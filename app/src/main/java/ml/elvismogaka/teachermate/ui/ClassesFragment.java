package ml.elvismogaka.teachermate.ui;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.Toast;

import ml.elvismogaka.teachermate.R;

/**
 * A simple {@link Fragment} subclass.
 */
public class ClassesFragment extends Fragment {
    Button addclass;

    public static ClassesFragment newInstance(){
        ClassesFragment classesFragment= new ClassesFragment();
        return classesFragment;
    }


    public ClassesFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view= inflater.inflate(R.layout.fragment_classes, container, false);
        addclass=view.findViewById(R.id.addclass);
        addclass.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                FragmentManager fm=getFragmentManager();
                AddClassFragment addClassFragment=new AddClassFragment();
                addClassFragment.show(fm,"dialog");


            }
        });
        return view;
    }

}
