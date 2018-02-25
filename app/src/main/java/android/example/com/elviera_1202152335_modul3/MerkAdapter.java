package android.example.com.elviera_1202152335_modul3;

import android.content.Context;
import android.content.Intent;
import android.graphics.drawable.GradientDrawable;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;

import java.util.ArrayList;

/**
 * Created by elviera on 2/25/2018.
 */

public class MerkAdapter extends RecyclerView.Adapter<MerkAdapter.ViewHolder>  {

    //Member variables
    private ArrayList<MerkAir> mdata;
    private Context mContext;

    //menyediakan hak akses untuk memgambil arraylist
    MerkAdapter(Context context, ArrayList<MerkAir> data){
        this.mdata = data;
        this.mContext = context;

    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        return new ViewHolder(mContext, LayoutInflater.from(mContext).inflate(R.layout.activity_list_item_air, parent, false));
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        //get curront merkair
        MerkAir currentMerkAir = mdata.get(position);
        //populate the textviews with data
        holder.bindTo(currentMerkAir);

        Glide.with(mContext).load(currentMerkAir.getImageResource()).into(holder.mMerkImage);
    }

    //Required method for determining the size of the data set.
    // * @return Size of the data set.
    @Override
    public int getItemCount() {
        return mdata.size();
    }

    /**
     * ViewHolder class that represents each row of data in the RecyclerView
     */
    class ViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {

        //member variables for the textviews, gambar, dan context
       private TextView mTitleText;
       private TextView mInfoText;
       private ImageView mMerkImage;
       private Context mContext;
       private MerkAir mCurrentMerkAir;


        /**
         * Constructor for the ViewHolder, used in onCreateViewHolder().
         * @param itemView The rootview of the activity_list_item_Air.xml layout file
         */

        ViewHolder(Context context, View itemView){
            super(itemView);

            //initialize the views
            mTitleText = (TextView)itemView.findViewById(R.id.daftarItem_air);
            mInfoText = (TextView) itemView.findViewById(R.id.daftarItem_deskripsi);
            mMerkImage = (ImageView)itemView.findViewById(R.id.gambar_air);
            mContext = context;

            itemView.setOnClickListener(this);

        }

        //mengisi textview dengan data
        void bindTo(MerkAir currentMerkAir) {
            mTitleText.setText(currentMerkAir.getTitle());
            mInfoText.setText(currentMerkAir.getInfo());

            mCurrentMerkAir = currentMerkAir;

            // LOAD URL DARI LOKAL DRAWABLE
            Glide.with(mContext).load(mCurrentMerkAir.getImageResource()).into(mMerkImage);
        }


       @Override
       //dipanggil saat pengguna memilih item
       public void onClick(View v) {
            //meneruskan untuk mendapatkan title, dan gambar
           Intent detail = MerkAir.starter(mContext, mCurrentMerkAir.getTitle(), mCurrentMerkAir.getImageResource());
           mContext.startActivity(detail);
       }
   }
}
