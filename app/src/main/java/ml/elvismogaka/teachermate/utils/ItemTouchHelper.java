package ml.elvismogaka.teachermate.utils;

import android.support.v7.widget.RecyclerView;

/**
 * Created by mosoti on 1/3/18.
 */

public class ItemTouchHelper extends android.support.v7.widget.helper.ItemTouchHelper.Callback {
    @Override
    public int getMovementFlags(RecyclerView recyclerView, RecyclerView.ViewHolder viewHolder) {
        return 0;
    }

    @Override
    public boolean onMove(RecyclerView recyclerView, RecyclerView.ViewHolder viewHolder, RecyclerView.ViewHolder target) {
        return false;
    }

    @Override
    public void onSwiped(RecyclerView.ViewHolder viewHolder, int direction) {

    }
}
