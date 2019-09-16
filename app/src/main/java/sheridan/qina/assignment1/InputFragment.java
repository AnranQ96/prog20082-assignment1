package sheridan.qina.assignment1;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.RadioGroup;

public class InputFragment extends Fragment {

    public interface InputListener {
        void updateMessage(String text);
    }

    private RadioGroup mChoiceGroup;

    private InputListener mInputListener;

    public InputFragment() {
        // Required empty public constructor
    }

    public static InputFragment newInstance(){
        return new InputFragment();
    }

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_input, container, false);

        mChoiceGroup = view.findViewById(R.id.radioGroup);

        Button sendButton = view.findViewById(R.id.playButton);
        sendButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                showOutput();
            }
        });

        return view;
    }

    private void showOutput() {
        if(mInputListener != null){
            // get the selected message
            String message;
            switch (mChoiceGroup.getCheckedRadioButtonId()) {
                case R.id.paperRadioButton:
                    message = getString(R.string.paperChoice);
                    break;
                case R.id.rockRadioButton:
                    message = getString(R.string.rockChoice);
                    break;
                case R.id.scissorRadioButton:
                    message = getString(R.string.scissorChoice);
                    break;
                default:
                    message = getString(R.string.undefined);
            }
            mInputListener.updateMessage(message);
        }
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        try {
            mInputListener = (InputListener) context;
        } catch (ClassCastException e) {
            throw new ClassCastException(context.toString()  + " must implement InputListener");
        }
    }

    @Override
    public void onDetach() {
        super.onDetach();
        mInputListener = null;
    }
}
