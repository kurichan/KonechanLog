package com.example.konechanlog.placeholder;


import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 * Helper class for providing sample content for user interfaces created by
 * Android template wizards.
 * <p>
 * TODO: Replace all uses of this class before publishing your app.
 */
public class PlaceholderContent {


    /* PlaceholderItem　変換　Before */
    public static List DATALIST = new ArrayList();

    /**
     * An array of sample (placeholder) items.
     */
    public static List<PlaceholderItem> ITEMS = new ArrayList<PlaceholderItem>();

    public static void PlaceholderContent(List list) {

        DATALIST = new ArrayList(list);

        // Add some sample items.
        for (int i = 0; i < DATALIST.size(); i++) {
            /*  文字列としてファイルから読み込んだデータをItemにして */
            PlaceholderItem x = createPlaceholderItem(i);
            /* 　Staticのエリアに設定する*/
            addItem(x);
        }

    }

    private static void addItem(PlaceholderItem item) {
        ITEMS.add(item);
    }

    private static PlaceholderItem createPlaceholderItem(int position) {

        return new PlaceholderItem(position);
    }
    /*
     * ******************************************************
     * A placeholder item representing a piece of content ***
     * (inner class)
     * *****************************************************
     */
    public static class PlaceholderItem implements Serializable {

        public final String renban; // 連番　格納順の発番番号

        public final String koneORotto; // 対象（コネ　夫　その他）
        public final String hizuke; // 日付
        public final String jikoku; // 時刻
        public final String dare; // 誰
        public final String nani; // 何
        public final String shurui; // 種類
        public final String hosoku; // 補足

        private PlaceholderItem(int position) {

            // リストから項目1行を取り出す
            String temp = DATALIST.get(position).toString();
            String[] strArr = temp.split("\\s*,\\s*");

            // 番号設定
            this.renban = "" + position;

            // 個別に値を取り出す
            this.koneORotto = (strArr[0] == null ? "" : strArr[0]);// 対象
            this.hizuke = (strArr[1] == null ? "" : strArr[1]);// 日付
            this.jikoku = (strArr[2] == null ? "" : strArr[2]); // 時刻
            this.dare = (strArr[3] == null ? "" : strArr[0]);// 誰
            this.nani = (strArr[4] == null ? "" : strArr[4]);// 何

            this.shurui = ""; //(strArr[5] == null ? "" : strArr[5]); // 種類
            this.hosoku = "";  //(strArr[6] == null ? "" : strArr[6]); // 補足

        }

        // ************************************************
        // getter
        // ************************************************
        // 対象
        public String getKoneORottoBySymbl() {
            return this.koneORotto;
            /*return (this.koneORotto == "夫" ? "△" : "▲"); */
        }

        // 日付
        public String getHizukeBySymbol() {
            return hizuke;
        }

        // 時刻
        public String getJikokuBySymbol() {
            return jikoku;
        }

        // 誰
        public String getDareBySymbol() {
            return this.dare;
//            return (this.dare == "夫" ? "○" : "コネ");
        }

        // 何
        public String getNaniBySymbol() {
            return this.nani;
//            return (this.nani == "食事" ? "○" : "●");
        }

        // 種類
        public String getShuruiBySymbol() {
            return this.shurui;
//            return (this.shurui == "夫" ? "★" : "☆");
        }

        // 補足
        public String getHosokuBySymbol() {
            return this.hosoku;
//            return (this.hosoku == "夫" ? "○" : "●");
        }

        @Override
        public String toString() {
            return renban + koneORotto + hizuke + jikoku + dare + nani + shurui + hosoku;
        }
    }

}