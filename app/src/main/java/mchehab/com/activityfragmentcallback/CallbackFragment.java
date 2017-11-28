package mchehab.com.activityfragmentcallback;

import android.content.Context;
import android.os.Bundle;
import android.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

public class CallbackFragment extends Fragment {

    private FragmentListener fragmentCallback;

    public CallbackFragment() {
        // Required empty public constructor
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_callback, container, false);
        view.findViewById(R.id.button).setOnClickListener(e -> {
            fragmentCallback.answerFragment("Button Fragment Clicked");
        });
        return view;
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        if(context instanceof FragmentListener){
            fragmentCallback = (FragmentListener)context;
            fragmentCallback.answerFragment("Fragment Attached and Callback initialized");
        }
    }

    @Override
    public void onDetach() {
        super.onDetach();
        fragmentCallback.answerFragment("Fragment is about to detach!");
    }
}