package sheridan.qina.assignment1;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;


public class OutputFragment extends Fragment {

    interface OutputListener{
        void showInput();
    }

    private OutputFragment mOutputListener;

    private String playerChoice, computerChoice, gameResult;
    private TextView pText, cText, rText;

    public OutputFragment() {
        // Required empty public constructor
    }

}
