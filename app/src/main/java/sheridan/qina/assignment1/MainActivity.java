package sheridan.qina.assignment1;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentManager;
import android.os.Bundle;

public class MainActivity extends AppCompatActivity implements InputFragment.InputListener, OutputFragment.OutputListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        if (savedInstanceState == null) {
            InputFragment inputFragment = InputFragment.newInstance();
            FragmentManager fragmentManager = getSupportFragmentManager();
            fragmentManager.beginTransaction().replace(R.id.fragment_placeholder, inputFragment).commit();
        }

    }

    @Override
    public void updateMessage(String message) {
        OutputFragment outputFragment = OutputFragment.newInstance(Integer.parseInt(message));
        FragmentManager fragmentManager = getSupportFragmentManager();
        fragmentManager.beginTransaction().replace(R.id.fragment_placeholder,outputFragment).addToBackStack(null).commit();

    }

    @Override
    public void showInput() {
        getSupportFragmentManager().popBackStack();
    }
}
