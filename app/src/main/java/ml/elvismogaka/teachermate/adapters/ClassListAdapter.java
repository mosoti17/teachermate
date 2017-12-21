package ml.elvismogaka.teachermate.adapters;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.ArrayList;

import butterknife.BindView;
import butterknife.ButterKnife;
import ml.elvismogaka.teachermate.R;
import ml.elvismogaka.teachermate.models.Class;

/**
 * Created by mosoti on 12/21/17.
 */

public class ClassListAdapter extends RecyclerView.Adapter<ClassListAdapter.ClassViewHolder> {
    private ArrayList<Class> mClasses= new ArrayList<>();
    private Context mContext;

    public ClassListAdapter(ArrayList<Class> classes,Context context){
        mClasses=classes;
        mContext=context;

    }

    @Override
    public ClassViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view= LayoutInflater.from(parent.getContext()).inflate(R.layout.classlistitem,parent,false);
        ClassViewHolder viewHolder= new ClassViewHolder(view);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(ClassViewHolder holder, int position) {
        holder.bindClass(mClasses.get(position));

    }

    @Override
    public int getItemCount() {
        return mClasses.size();

    }

    public class ClassViewHolder extends RecyclerView.ViewHolder{
        @BindView(R.id.classname1) TextView mClassName;
        @BindView(R.id.classtech) TextView mClassTech;
        private Context mContext1;
        public ClassViewHolder(View itemView){
            super(itemView);
            ButterKnife.bind(this,itemView);
            mContext1=itemView.getContext();
        }
        public void bindClass(Class class2){
            mClassName.setText(class2.getName());
            mClassTech.setText(class2.getClassteacher());
        }

    }

}
