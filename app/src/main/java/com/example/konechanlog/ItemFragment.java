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

    /**
     * Mandatory empty constructor for the fragment manager to instantiate the
     * fragment (e.g. upon screen orientation changes).
     */
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

 /*   //2023.07.11 add start
    private View.OnClickListener globalListener = new View.OnClickListener() {
        @Override
        public void onClick(View view) {
            // 画面全体のリスナーの処理
            Toast.makeText(getContext(), "画面がクリックされました", Toast.LENGTH_SHORT).show();
        }
    };
*/
//    private OnItemClickListener itemClickListener = new OnItemClickListener() {
//        @Override
//        public void onItemClick(int position) {
//            // 特定のアイテムのリスナーの処理
//            Item item = itemList.get(position);
//            Toast.makeText(getContext(), "アイテムがクリックされました: " + item.getName(), Toast.LENGTH_SHORT).show();
//        }
//    };

    // end

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

//        recyclerView = findViewById(R.id.list);

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

        // 2023.07011 start
//        return inflater.inflate(R.layout.fragment_item_list, container, false);


        View view = inflater.inflate(R.layout.fragment_item_list, container, false);
        return view;
    }

    @Override
    public void onViewCreated(View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        // RecyclerViewの設定
        recyclerView = view.findViewById(R.id.list);
        recyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));
//        adapter = new MyItemRecyclerViewAdapter();
//        RecyclerView recyclerView = (RecyclerView) view;
       // recyclerView.setAdapter(new MyItemRecyclerViewAdapter(PlaceholderContent.ITEMS));
       PlaceholderContent.PlaceholderContent(retList);
        recyclerView.setAdapter(new MyItemRecyclerViewAdapter(ITEMS));

        // 画面全体のクリックリスナー
//        view.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                // 画面全体のクリックイベント処理
//            }
//        });


//        // Set the adapter
//        if (view instanceof RecyclerView) {
//            Context context = view.getContext();
//            RecyclerView recyclerView = (RecyclerView) view;
//            if (mColumnCount <= 1) {
//                recyclerView.setLayoutManager(new LinearLayoutManager(context));
//            } else {
//                //    recyclerView.setLayoutManager(new GridLayoutManager(context, mColumnCount));
//                recyclerView.setLayoutManager(new LinearLayoutManager(context));
//            }
//
//            DATALIST = retList;
//            PlaceholderContent.PlaceholderContent(DATALIST);
//            recyclerView.setAdapter(new MyItemRecyclerViewAdapter(PlaceholderContent.ITEMS));
////           recyclerView.setAdapter(new MyItemRecyclerViewAdapter(retList));
//        }
//
//        return view;
    }

}