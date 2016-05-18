package layout;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.Toast;

import com.example.bigedo.task_3_sign_in.MainActivity;
import com.example.bigedo.task_3_sign_in.R;

public class RegisterFragment extends Fragment implements View.OnClickListener{

    View view;

    Button home_navigation_button;

    //create fragment manager
    FragmentManager fm;

    //create fragment transaction
    FragmentTransaction ft;

    //create fragment object
    Fragment homeFragment, registerFragment, signinFragment, userFragment;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        view = inflater.inflate(R.layout.register_fragment, container, false);

        initFragment();

        return view;
    }

    @Override
    public void onClick(View v) {
        switch(v.getId()){
            case R.id.nav_home_button:
                Toast.makeText(getActivity(), "Test", Toast.LENGTH_SHORT).show();
                swapFragment("home");
                break;
        }

    }

    private void initFragment(){
        //init button
        home_navigation_button = (Button)view.findViewById(R.id.nav_home_button);

        //add listener
        home_navigation_button.setOnClickListener(this);
    }

    private void swapFragment(String id){
        homeFragment = new HomeFragment();
        registerFragment = new RegisterFragment();
        signinFragment = new SignInFragment();
        userFragment = new UserFragment();

        fm = getFragmentManager();
        ft = fm.beginTransaction();

        if(id.equals("home")){
            ft.replace(R.id.fragment_place, homeFragment);
        }
        ft.commit();
    }

}
