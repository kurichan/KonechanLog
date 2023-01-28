package com.example.konechanlog;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.Spinner;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.navigation.Navigation;

import com.example.konechanlog.databinding.FragmentWordinBinding;
import com.example.konechanlog.util.SpinnerCase;
import com.example.konechanlog.util.SpinnerCase1;
import com.example.konechanlog.util.SpinnerCase2;
import com.example.konechanlog.util.SpinnerCase3;
import com.example.konechanlog.util.SpinnerCaseWith;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link Wordin#newInstance} factory method to
 * create an instance of this fragment.
 */
public class Wordin extends Fragment {

    // 2022.12.08 add
    private FragmentWordinBinding binding;
    // end

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    /*
    own area for spinner input
     */
    private SpinnerCase spinnerCase1;
    private SpinnerCase spinnerCase2;
    private SpinnerCase spinnerCase3;
    private SpinnerCaseWith spinnerCase4;

    public Wordin() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @return A new instance of fragment Wordin.
     */
    // TODO: Rename and change types and number of parameters
    public static Wordin newInstance(String param1, String param2) {
        Wordin fragment = new Wordin();
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {


        binding = FragmentWordinBinding.inflate(inflater, container, false);

        // 初期設定
        spinnerCase1 = new SpinnerCase1();
        spinnerCase1.setSpinner(binding.spinner);

        spinnerCase2 = new SpinnerCase2();
        spinnerCase2.setSpinner(binding.spinner2);

        spinnerCase3 = new SpinnerCase3();
        spinnerCase3.setSpinner(binding.spinner3);

        spinnerCase4 = new SpinnerCaseWith();

        // at first

        spinnerCase1.setEnabled(true);
        spinnerCase1.setFocusable(true);
        spinnerCase1.setSignals(true);


        spinnerCase2.setFocusable(false);
        spinnerCase2.setEnabled(false);
        spinnerCase2.setSignals(false);

        spinnerCase3.setFocusable(false);
        spinnerCase3.setEnabled(false);
        spinnerCase3.setSignals(false);

        // 行為者は誰？
        // 最初の選択肢を設定
        spinnerCase1.setActivity(this.getActivity());
        spinnerCase2.setActivity(this.getActivity());
        spinnerCase3.setActivity(this.getActivity());
        spinnerCase4.setActivity(this.getActivity());

        //　最初の選択肢を設定
        spinnerCase1.setAdapter();

        // first spinner listener setting
        spinnerCase1.getSpinner().setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                // 初回はパス
                if (spinnerCase2.isSignals() == false) {
                    spinnerCase2.setSignals(true);
                    return;
                }

                //　2回目以降は設定する
                Spinner spinner = (Spinner) parent;
                // 選択されたアイテムのテキストを取得
                spinnerCase1.setSel(spinner.getSelectedItem().toString());

                spinnerCase2.setEnabled(true);
                spinnerCase2.setAdapter();


            }

            public void onNothingSelected(AdapterView<?> parent) {
            }
        });

        // 何を
        spinnerCase2.getSpinner().setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                // 初回はパス
                if (spinnerCase3.isSignals() == false) {
                    spinnerCase3.setSignals(true);
                    return;
                }

                // アイテムが選択された時の動作
                // Spinner を取得
                Spinner spinner2 = (Spinner) parent;
                // 選択されたアイテムのテキストを取得
                spinnerCase2.setSel(spinner2.getSelectedItem().toString());

                spinnerCase3.setEnabled(true);
                spinnerCase3.setAdapter();
            }

            public void onNothingSelected(AdapterView<?> parent) {
            }
        });

        // 種類
        spinnerCase3.getSpinner().setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                // 初回はパス
                if (spinnerCase3.isSignals() == false) {
                    spinnerCase3.setSignals(true);
                    return;
                }

                // アイテムが選択された時の動作
                // Spinner を取得
                Spinner spinner3 = (Spinner) parent;
                // 選択されたアイテムのテキストを取得
                spinnerCase3.setSel(spinner3.getSelectedItem().toString());

            }

            public void onNothingSelected(AdapterView<?> parent) {
            }
        });

        // 補足

        return binding.getRoot();

    }

    // 2022.12.08 add
    // 確認ボタン押下
    public void onViewCreated(@NonNull View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);


        // store call
        binding.button4.setOnClickListener(new View.OnClickListener() {
            @Override

            public void onClick(View view) {

                /* result try case begins */
                Bundle result = new Bundle();
                result.putString("bundleKey", "result");
                result.putString("sel1", spinnerCase1.getSel());
                result.putString("sel2", spinnerCase2.getSel());
                result.putString("sel3", spinnerCase3.getSel());

                // 補足
                //Editable sel4 = binding.editTextTextMultiLine.getText();
                String sel4 = (binding.editTextTextMultiLine.equals(null) ? "" : binding.editTextTextMultiLine.toString());
                result.putString("sel4", sel4.toString());

                // The child fragment needs to still set the result on its parent fragment manager
                getParentFragmentManager().setFragmentResult("requestKey", result);

                /*  result try case end*/


                /* safeArgs case begins */
                WordinDirections.ActionWordinToStoreIt action =
                        WordinDirections.actionWordinToStoreIt("Hello1");
                Navigation.findNavController(view).navigate(action);

                /* sageArgs case end */

            }
        });
    }

}