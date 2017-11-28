package mchehab.com.activityfragmentcallback;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements FragmentListener {

    private CallbackFragment callbackFragment = new CallbackFragment();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        findViewById(R.id.buttonAttach).setOnClickListener(e -> attachFragment());
        findViewById(R.id.buttonDetach).setOnClickListener(e -> detachFragment());
    }

    private void attachFragment(){
        getFragmentManager().beginTransaction().add(R.id.frameLayout, callbackFragment).commit();
    }

    private void detachFragment(){
        getFragmentManager().beginTransaction().remove(callbackFragment).commit();
    }

    @Override
    public void answerFragment(String message) {
        Toast.makeText(this, message, Toast.LENGTH_SHORT).show();
    }
}