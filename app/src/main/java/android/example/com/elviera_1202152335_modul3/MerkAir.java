package android.example.com.elviera_1202152335_modul3;

import android.content.Context;
import android.content.Intent;
import android.support.annotation.DrawableRes;

import static android.provider.MediaStore.Audio.AudioColumns.TITLE_KEY;

/**
 * Created by elviera on 2/25/2018.
 */

class MerkAir {

    //Member variables representing the title and information about the sport
    private String title;
    private String info;
    private int imageResource;

    static final String TITLE_KEY = "Title";
    static final String IMAGE_KEY = "Image Resource";

    //mendeskripsikan variable kepemilikan
    public MerkAir(String title, String info, int imageResource) {
        this.title = title;
        this.info = info;
        this.imageResource = imageResource;

    }

    public int getImageResource() {
        return imageResource;
    }

    /**
     * Gets the title of the merkair
     * @return The title of the merkair
     */
    String getTitle() {
        return title;
    }
    /**
     * Gets the info about the sport
     * @return The info about the sport.
     */
    String getInfo() {
        return info;
    }

    //menaruh title dan image pada detail intent
    public static Intent starter(Context context, String title, @DrawableRes int imageResId) {
        Intent detailIntent = new Intent(context, DetailActivity.class);
        detailIntent.putExtra(TITLE_KEY,title);
        detailIntent.putExtra(IMAGE_KEY,imageResId);
        return detailIntent;
    }
}
