package android.example.com.elviera_1202152335_modul3;

import android.content.res.TypedArray;
import android.example.com.elviera_1202152335_modul3.MerkAir;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.helper.ItemTouchHelper;

import java.util.ArrayList;
import java.util.Collections;

/**
 * Created by elviera on 2/25/2018.
 */

public class DaftarAir extends AppCompatActivity {

    //member variables
    private RecyclerView mRecyclerView;
    private ArrayList<MerkAir> data;
    private MerkAdapter mAdapter;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_daftar_air);

        //membuat tampilan layout menjadi satu baris
        int gridColumnCOunt = getResources().getInteger(R.integer.grid_column_count);

        //initialize the RecyclerView
        mRecyclerView = (RecyclerView)findViewById(R.id.RecyclerView);

        //set the layout manager
        mRecyclerView.setLayoutManager(new GridLayoutManager(this, gridColumnCOunt));

        //initialize the ArrayList that will contain the data
        data = new ArrayList<>();

        //initialize the adapter and set it on the RecyclerView
        mAdapter = new MerkAdapter(this, data);
        mRecyclerView.setAdapter(mAdapter);

        //get the data
        initializeData();
    }

    //method for initializing the sorts data from resource
    private void initializeData() {
        TypedArray MerkAirImageResources = getResources().obtainTypedArray(R.array.air_image);

        //Get the resource from the XML file
        String[] MerkList = getResources().getStringArray(R.array.air_titles);
        String[] MerkInfo = getResources().getStringArray(R.array.air_info);

        //clear the exixting data ( to avoid duplication)
        data.clear();

        //create the ArrayLits of Sport objects with the titles and information about eah merk air minum
        for (int i = 0; i < MerkList.length; i++){
            data.add(new MerkAir(MerkList[i], MerkInfo[i], MerkAirImageResources.getResourceId(i, 0) ));
        }
        MerkAirImageResources.recycle();

        //notify the adapter of the change
        mAdapter.notifyDataSetChanged();
    }
}
