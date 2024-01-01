package com.example.konechanlog;

import static com.example.konechanlog.placeholder.PlaceholderContent.ITEMS;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.konechanlog.common.DataAccessHelper;
import com.example.konechanlog.placeholder.PlaceholderContent;

import java.util.List;

/**
 * A fragment representing a list of Items.
 */
public class ItemFragment extends Fragment {

    // 2023.07.17 add
    private RecyclerView recyclerView;
    // end
    public List retList;

    private DataAccessHelper dataAccessHelper;

    // TODO: Customize parameter argument names
    private static final String ARG_COLUMN_COUNT = "column-count";
    // TODO: Customize parameters
    private int mColumnCount = 4;

    public ItemFragment() {
    }

    // TODO: Customize parameter initialization
    @SuppressWarnings("unused")
    public static ItemFragment newInstance(int columnCount) {
        ItemFragment fragment = new ItemFragment();
        Bundle args = new Bundle();
        args.putInt(ARG_COLUMN_COUNT, columnCount);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        dataAccessHelper = new DataAccessHelper(getContext());
        try {
            retList = dataAccessHelper.yomikomi("text.dat");
        } catch (Exception e) {
            e.printStackTrace();
        }

        if (getArguments() != null) {
            mColumnCount = getArguments().getInt(ARG_COLUMN_COUNT);
        }


    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_item_list, container, false);
        return view;
    }

    @Override
    public void onViewCreated(View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        // RecyclerViewの設定
        recyclerView = view.findViewById(R.id.list);
        recyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));
        PlaceholderContent.PlaceholderContent(retList);
        recyclerView.setAdapter(new MyItemRecyclerViewAdapter(ITEMS));

    }

}