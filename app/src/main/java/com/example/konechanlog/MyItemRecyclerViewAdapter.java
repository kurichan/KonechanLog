package com.example.konechanlog;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.konechanlog.placeholder.PlaceholderContent.PlaceholderItem;

import java.util.List;

/**
 * {@link RecyclerView.Adapter} that can display a {@link PlaceholderItem}.
 * TODO: Replace the implementation with code for your data type.
 */
public class MyItemRecyclerViewAdapter extends RecyclerView.Adapter<MyItemRecyclerViewAdapter.ViewHolder> {


    private List<PlaceholderItem> placeholderItemList;  // 表示すべきデータ全体

    public MyItemRecyclerViewAdapter(List<PlaceholderItem> items) {

        placeholderItemList = items;
    }


    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.fragment_item, parent, false);
        return new ViewHolder(view);

    }

    @Override
    public void onBindViewHolder(final ViewHolder holder, int position) {

        PlaceholderItem placeholderItem = placeholderItemList.get(position);

        int x = position + 1;

        holder.mRenban.setText(Integer.toString(x));

        holder.mKoneORotto.setText(placeholderItem.getKoneORottoBySymbl());
        holder.mHizuke.setText(placeholderItem.getHizukeBySymbol());
        holder.mJikoku.setText(placeholderItem.getJikokuBySymbol());
        holder.mDare.setText(placeholderItem.getDareBySymbol());
        holder.mNani.setText(placeholderItem.getNaniBySymbol());
        holder.mShurui.setText(placeholderItem.getShuruiBySymbol());
        holder.mHosoku.setText(placeholderItem.getHosokuBySymbol());

    }

    @Override
    public int getItemCount() {

        return placeholderItemList.size();
    }

    // *****************************************************
    //            inner class ViewHolder
    // *****************************************************
    public class ViewHolder extends RecyclerView.ViewHolder {

        public TextView mRenban;  // 連番
        public TextView mKoneORotto;  // こね　
        public TextView mHizuke;  //日付
        public TextView mJikoku;  // 時刻
        public TextView mDare;  // 誰
        public TextView mNani;  // 何
        public TextView mShurui;  // 種類
        public TextView mHosoku;  // 補足


        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            mRenban = itemView.findViewById(R.id.renban);
            mKoneORotto = itemView.findViewById(R.id.koneORotto);  // こね　おっとと　その他
            mHizuke = itemView.findViewById(R.id.hizuke);  //日付
            mJikoku = itemView.findViewById(R.id.jikoku);  // 時刻
            mDare = itemView.findViewById(R.id.dare);  // 誰
            mNani = itemView.findViewById(R.id.nani);  // 何
            mShurui = itemView.findViewById(R.id.shurui);  // 種類
            mHosoku = itemView.findViewById(R.id.hosoku);  // 種類

        }
    }
}