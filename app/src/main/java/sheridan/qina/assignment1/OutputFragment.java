package sheridan.qina.assignment1;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.FragmentManager;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;


public class OutputFragment extends Fragment {

    interface OutputListener{
        void showInput();
    }

    private OutputListener mOutputListener;
    private int mPlayerChoice;
    private static final String PLAYERCHOICE = "playerChoice";
    private PaperRockGame game = new PaperRockGame();


    private String playerChoice, computerChoice, gameResult;
    private TextView pText, cText, rText;

    public OutputFragment() {
        // Required empty public constructor
    }

    public static OutputFragment newInstance(@NonNull int playerChoice){
        OutputFragment outputFragment = new OutputFragment();
        Bundle arguments = new Bundle();
        arguments.putInt(PLAYERCHOICE, playerChoice);
        outputFragment.setArguments(arguments);
        return outputFragment;
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        if(savedInstanceState == null){
            Bundle arguments = getArguments();
            assert arguments != null;
            mPlayerChoice = arguments.getInt(PLAYERCHOICE);
        }else{
            mPlayerChoice = savedInstanceState.getInt(PLAYERCHOICE);
        }
        //store player choice from input fragment
        game.setUserChoice(mPlayerChoice);
    }

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_output, container, false);

        pText = view.findViewById(R.id.playerText);
        pText.setText(game.getUserChoiceName());
        cText = view.findViewById(R.id.computerText);
        cText.setText(game.getComputerChoiceName());
        rText = view.findViewById(R.id.resultText);
        rText.setText(game.getWinnerName());

        Button closeButton = view.findViewById(R.id.backButton);
        closeButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mOutputListener.showInput();
            }
        });

        return view;
    }

    @Override
    public void onSaveInstanceState(@NonNull Bundle outState) {
        super.onSaveInstanceState(outState);
        outState.putInt(PLAYERCHOICE, mPlayerChoice);
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        try {
            mOutputListener = (OutputListener) context;
        } catch (ClassCastException e) {
            throw new ClassCastException(context.toString()
                    + " must implement OutputListener");
        }
    }

    @Override
    public void onDetach() {
        super.onDetach();
        mOutputListener = null;
    }
}
