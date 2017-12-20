package ml.elvismogaka.teachermate;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.view.MenuItem;
import android.widget.FrameLayout;
import android.widget.TextView;

import ml.elvismogaka.teachermate.database.DataBaseHelper;
import ml.elvismogaka.teachermate.ui.ClassesFragment;
import ml.elvismogaka.teachermate.ui.TimetableFragment;

public class MainActivity extends AppCompatActivity {
    DataBaseHelper db;

    private TextView mTextMessage;
    public Fragment selectedFragment;

    private BottomNavigationView.OnNavigationItemSelectedListener mOnNavigationItemSelectedListener
            = new BottomNavigationView.OnNavigationItemSelectedListener() {

        @Override
        public boolean onNavigationItemSelected(@NonNull MenuItem item) {
            selectedFragment=null;
            switch (item.getItemId()) {

                case R.id.navigation_home:
                        selectedFragment=ClassesFragment.newInstance();

                    break;
                case R.id.navigation_dashboard:
                    selectedFragment= TimetableFragment.newInstance();

                    break;
                case R.id.navigation_notifications:

                    break;
            }
            FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
            transaction.replace(R.id.fragment, selectedFragment);
            transaction.commit();
            return true;
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        db=new DataBaseHelper(this);

        mTextMessage = (TextView) findViewById(R.id.message);

        BottomNavigationView navigation = (BottomNavigationView) findViewById(R.id.navigation);
        navigation.setOnNavigationItemSelectedListener(mOnNavigationItemSelectedListener);

        FragmentTransaction transaction = getSupportFragmentManager().
                beginTransaction();
        transaction.replace(R.id.fragment, ClassesFragment.newInstance());
        transaction.commit();

    }

}
