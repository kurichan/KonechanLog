package com.example.konechanlog;

import static android.app.Activity.RESULT_OK;

import android.content.Intent;
import android.os.Bundle;
import android.speech.RecognizerIntent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.navigation.Navigation;
import androidx.navigation.fragment.NavHostFragment;

import com.example.konechanlog.databinding.FragmentSecondBinding;

import java.util.ArrayList;

public class SecondFragment extends Fragment {

    private FragmentSecondBinding binding;

    private static final int REQUEST_CODE = 1234;
    private TextView textView;

    private View tview;


    @Override
    public View onCreateView(
            LayoutInflater inflater, ViewGroup container,
            Bundle savedInstanceState
    ) {

        binding = FragmentSecondBinding.inflate(inflater, container, false);
        return binding.getRoot();

    }

    public void onViewCreated(@NonNull View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        tview = view;
        // 音声認識 start
        {
            // setContentView(R.layout.activity_main);

            textView = view.findViewById(R.id.textView);

            Intent intent = new Intent(RecognizerIntent.ACTION_RECOGNIZE_SPEECH);
            intent.putExtra(RecognizerIntent.EXTRA_LANGUAGE_MODEL, RecognizerIntent.LANGUAGE_MODEL_FREE_FORM);
            intent.putExtra(RecognizerIntent.EXTRA_PROMPT, "音声を入力してください");

            startActivityForResult(intent, REQUEST_CODE);

        }
        // end

        binding.buttonSecond.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                NavHostFragment.findNavController(SecondFragment.this)
                        .navigate(R.id.action_SecondFragment_to_FirstFragment);
            }
        });

    }

    // 音声認識
    @Override
    public void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if (requestCode == REQUEST_CODE && resultCode == RESULT_OK && data != null) {
            ArrayList<String> result = data.getStringArrayListExtra(RecognizerIntent.EXTRA_RESULTS);
            //textView.setText(result.get(0));
            // 音声認識が終わると自動的に格納画面に行く　start
            {
                /* result try case begins */
                Bundle retvalue = new Bundle();
                retvalue.putString("bundleKey", "result");
                retvalue.putString("sel1","その他１");
                retvalue.putString("sel2", "その他２");
                retvalue.putString("sel3", "その他３");

                // 補足
                retvalue.putString("sel4", result.get(0));

                // The child fragment needs to still set the result on its parent fragment manager
                getParentFragmentManager().setFragmentResult("requestKey", retvalue);

                /*  result try case end*/

                /* safeArgs case begins */

                SecondFragmentDirections.ActionSecondFragmentToStoreIt action =
                        SecondFragmentDirections.actionSecondFragmentToStoreIt("Hello1");
                Navigation.findNavController(tview).navigate(action);

                /* sageArgs case end */

            }
            // end

        }
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }

}