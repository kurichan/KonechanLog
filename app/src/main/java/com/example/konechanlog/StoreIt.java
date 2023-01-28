package com.example.konechanlog;

import android.os.Bundle;
import android.util.Log;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentResultListener;

import com.example.konechanlog.common.DataAccessHelper;
import com.example.konechanlog.databinding.FragmentWordinBinding;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link StoreIt#newInstance} factory method to
 * create an instance of this fragment.
 */
public class StoreIt extends Fragment {

    // 2022.12.08 add
    private FragmentWordinBinding binding;
    // end


    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    // 2023.01.11 code correction start
    private TextView tv1;
    private TextView tv2;
    private TextView tv3;
    private TextView tv4;

    private String sel1;
    private String sel2;
    private String sel3;
    private String sel4;

    private TextView tdate;
    private TextView ttime;

    // end
    public StoreIt() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment StoreIt.
     */
    // TODO: Rename and change types and number of parameters
    public static StoreIt newInstance(String param1, String param2) {
        StoreIt fragment = new StoreIt();
        Bundle args = new Bundle();
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_store_it, container, false);
    }

    // 2022.12.10 add
    @Override
    public void onViewCreated(@NonNull View view, Bundle savedInstanceState) {


        tdate = view.findViewById(R.id.editTextDate);

        ttime = view.findViewById(R.id.editTextTime);

        //時刻表示するコードを追加
        LocalDateTime now = LocalDateTime.now();

        tdate.setText(now.toLocalDate().toString());
        ttime.setText(now.toLocalTime().format(DateTimeFormatter.ofPattern("HH:mm:ss")).toString());

        /* 表示エリア　設定 */

        tv1 = view.findViewById(R.id.textView3);
        tv2 = view.findViewById(R.id.textView7);
        tv3 = view.findViewById(R.id.textView10);
        tv4 = view.findViewById(R.id.textView11);

        /* by safeArgs received case begins */
        String message = StoreItArgs.fromBundle(getArguments()).getMess();
        /* by safeArgs received case end */


        /* by fragmentResult received case begins */

        // We set the listener on the child fragmentManager
        getParentFragmentManager().setFragmentResultListener("requestKey", this, new FragmentResultListener() {
            @Override
            public void onFragmentResult(@NonNull String key, @NonNull Bundle bundle) {

                sel1 = null;
                sel2 = null;
                sel3 = null;
                sel4 = null;

                sel1 = bundle.getString("sel1");
                sel2 = bundle.getString("sel2");
                sel3 = bundle.getString("sel3");
                sel4 = bundle.getString("sel4");

                // Do something with the result..
                tv1.setText(sel1);
                tv2.setText(sel2);
                tv3.setText(sel3);
                tv4.setText(sel4);
            }
        });
        /* by fragmentResult received case end */

        // store button push start
        final Button button3 = view.findViewById(R.id.button3);
        // lambda式
        button3.setOnClickListener(v -> {

            // date & time exchange to string

            // write out  here
           // String outData = tdate.toString() + "," + ttime.toString() + "," +
            String outData = "2023.01.17" + "," + "22:00:00" + "," +
                    sel1 + "," + sel2 + "," + sel3 + "," + sel4 + "," +"\n";

            DataAccessHelper helper = new DataAccessHelper(getView().getContext());

            try {
                helper.kakidashi("text.dat", outData);
                toastMake("outData=" + outData, 0, 500);
            } catch (Exception e) {
                e.printStackTrace();
            }

            Log.d("debug", outData);

        });
        // end

        // date exchanged start
        EditText exitText = view.findViewById(R.id.editTextTextPersonName);

        exitText.setOnClickListener(v -> {

            // call datepicker
            Log.d("debug", "button, Perform action on click");
        });
        // end

        // time exchanged start
        EditText exitText1 = view.findViewById(R.id.editTextTextPersonName2);

        exitText1.setOnClickListener(v -> {

            // call timepicker
            Log.d("debug", "button, Perform action on click");

        });
        // end
    }
    // end


    // いつものトースト表示
    private void toastMake(String message, int x, int y) {
        Toast toast = Toast.makeText(getActivity(), message, Toast.LENGTH_LONG);
        // 位置調整
        toast.setGravity(Gravity.CENTER, x, y);
        toast.show();
    }


}