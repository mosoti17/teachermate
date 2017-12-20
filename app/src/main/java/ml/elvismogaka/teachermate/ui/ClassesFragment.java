package ml.elvismogaka.teachermate.ui;


import android.database.Cursor;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.SimpleAdapter;
import android.widget.Toast;

import java.util.ArrayList;

import ml.elvismogaka.teachermate.R;
import ml.elvismogaka.teachermate.database.DataBaseHelper;
import ml.elvismogaka.teachermate.models.Class;

/**
 * A simple {@link Fragment} subclass.
 */
public class ClassesFragment extends Fragment {
    Button addclass;
    DataBaseHelper myDb;
    ListView classes;

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
        classes= view.findViewById(R.id.list_view);
        addclass.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                FragmentManager fm=getFragmentManager();
                AddClassFragment addClassFragment=new AddClassFragment();
                addClassFragment.show(fm,"dialog");


            }
        });
        showClasses();
        return view;
    }
    public void showClasses(){
        Cursor result=myDb.getClasses();
        ArrayList<String> name=new ArrayList<>();
        ArrayList<String> classteacher=new ArrayList<>();
        while (result.moveToNext()){
            Log.v("id",result.getString(0));
            name.add(result.getString(1));
            Log.v("name",result.getString(1));
            classteacher.add(result.getString(2));
            Log.v("ct",result.getString(2));
            String[] stockArr = new String[name.size()];




        }
    }

}
