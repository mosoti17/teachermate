package ml.elvismogaka.teachermate.ui;


import android.os.Bundle;
import android.support.v4.app.DialogFragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import ml.elvismogaka.teachermate.R;
import ml.elvismogaka.teachermate.database.DataBaseHelper;



public class AddClassFragment extends DialogFragment {
    EditText className;
    EditText classTeacher;
    Button addClass;
    DataBaseHelper myDb;


    public AddClassFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view= inflater.inflate(R.layout.fragment_add_class, container, false);
        myDb = new DataBaseHelper(getContext());
        className=view.findViewById(R.id.classname);
        classTeacher=view.findViewById(R.id.classteachername);
        addClass=view.findViewById(R.id.addclassbutton);

        addClass.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
               boolean inserted= myDb.insertClass(className.getText().toString(),classTeacher.getText().toString());
               if(inserted){

                   Toast.makeText(getContext(),"Class Added",Toast.LENGTH_LONG).show();

               }else{

                   Toast.makeText(getContext(),"Class Added",Toast.LENGTH_LONG).show();
               }

                ClassesFragment.newInstance();

                dismiss();
            }
        });

        return view;
    }

}
