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

    // 2023.07.10 add start
    private RecyclerViewClickListener itemClickListener;
    // end

    private List<PlaceholderItem> mValues;  // 表示すべきデータ全体

    public MyItemRecyclerViewAdapter(List<PlaceholderItem> items) {

        mValues = items;
    }

    // 2023.07.17 add
    public void setItems(List<PlaceholderItem> items) {
        this.mValues = items;
//        notifyDataSetChanged();
    }

    public void setOnItemClickListener(RecyclerViewClickListener listener) {
        this.itemClickListener = listener;
    }
    // end

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.fragment_item, parent, false);
        return new ViewHolder(view);

//        return new ViewHolder(FragmentItemBinding.inflate(LayoutInflater.from(parent.getContext()), parent, false));


    }

    @Override
    public void onBindViewHolder(final ViewHolder holder, int position) {


        PlaceholderItem t = mValues.get(position);

        int x = position + 1;
        holder.mRenban.setText(Integer.toString(x));

        holder.mKoneORotto.setText(t.getKoneORottoBySymbl());
        holder.mHizuke.setText(t.getHizukeBySymbol());
        holder.mJikoku.setText(t.getJikokuBySymbol());
        holder.mDare.setText(t.getDareBySymbol());
        holder.mNani.setText(t.getNaniBySymbol());
        holder.mShurui.setText(t.getShuruiBySymbol());
        holder.mHosoku.setText(t.getHosokuBySymbol());

//        TextView myTextView = findViewById(R.id.my_text_view);
//        myTextView.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                Toast.makeText(, "TextViewがクリックされました！", Toast.LENGTH_SHORT).show();
//            }
//        });


    }

    @Override
    public int getItemCount() {
        return mValues.size();
    }

    // *****************************************************
    // inner class ViewHolder
    //
    //
    // *****************************************************
    public class ViewHolder extends RecyclerView.ViewHolder
            implements View.OnClickListener   {

        /* */
        // 2023.07.10 add
        public TextView myTextView;

        //end

        //        public final TextView mRenban;  // 連番
//        public final TextView mKoneORotto;  // こね　おっとと　その他
//        public final TextView mHizuke;  //日付
//        public final TextView mJikoku;  // 時刻
//        public final TextView mDare;  // 誰
//        public final TextView mNani;  // 何
//        public final TextView mShurui;  // 種類
//        public final TextView mHosoku;  // 補足
        public TextView mRenban;  // 連番
        public TextView mKoneORotto;  // こね　おっとと　その他
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

            // 2023.07.10 add
            myTextView = itemView.findViewById(R.id.my_text_view);
            itemView.setOnClickListener(this);
            // リスナー設定


//            public void bind(String item) {
//                textView.setText(item);
//            }
//
//
            // end

        }

        /*public TextView getmDare() {


        }*/

        @Override
        public void onClick(View v) {
//                wordItemView.setText ("Clicked! "+ wordItemView.getText());/**/
        }
//        public ViewHolder(FragmentItemBinding binding) {
////            super(binding.getRoot());
//
//
//            // レイアウトの要素を取り出す
//            mRenban = binding.renban;
//            mKoneORotto = binding.koneORotto;
//            mHizuke = binding.hizuke;
//            mJikoku = binding.jikoku;
//            mDare = binding.dare;
//            mNani = binding.nani;
//            mShurui = binding.shurui;
////            mHosoku = binding.hosoku;
//
//        }

//        @Override
//        public String toString() {
//            //
//            StringBuffer ret = new StringBuffer();
//            //
//            ret.append(mRenban.toString());
//            //
//            ret.append((mLoneORotto ? ))
//            return super.toString() + " '" + mContentView.getText() + "'";
//        }

    }
}