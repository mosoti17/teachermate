package ml.elvismogaka.teachermate.ui;


import android.database.Cursor;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import java.util.ArrayList;

import ml.elvismogaka.teachermate.R;
import ml.elvismogaka.teachermate.adapters.ClassListAdapter;
import ml.elvismogaka.teachermate.database.DataBaseHelper;
import ml.elvismogaka.teachermate.models.Class;

/**
 * A simple {@link Fragment} subclass.
 */
public class ClassesFragment extends Fragment {
    Button addclass;
    DataBaseHelper myDb;
     RecyclerView classesRecycler;
     ClassListAdapter classesAdapter;

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
        myDb = new DataBaseHelper(getContext());
        addclass=view.findViewById(R.id.addclass);
        classesRecycler=view.findViewById(R.id.recyclerView);

        addclass.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                FragmentManager fm=getFragmentManager();
                AddClassFragment addClassFragment=new AddClassFragment();
                Bundle bundle = new Bundle();
                bundle.putString("source","add");
                addClassFragment.setArguments(bundle);
                addClassFragment.show(fm,"dialog");


            }
        });


        showClasses();
        return view;
    }
    public void showClasses(){
        Cursor result=myDb.getClasses();
        ArrayList<Class> classes= new ArrayList<>();
        while (result.moveToNext()){
            Class entry= new Class(Integer.parseInt(result.getString(0)),result.getString(1),result.getString(2));
            classes.add(entry);

        }
        Log.v("class",String.valueOf(classes.size()));


        classesAdapter = new ClassListAdapter(classes,getActivity());
        classesRecycler.setAdapter(classesAdapter);
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(getActivity());
        classesRecycler.setLayoutManager(layoutManager);
        classesRecycler.setHasFixedSize(false);



    }

}
