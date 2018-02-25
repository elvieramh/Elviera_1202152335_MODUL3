package android.example.com.elviera_1202152335_modul3;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import org.w3c.dom.Text;

public class DetailActivity extends AppCompatActivity {

    //deklarasi variable
    private Button mbtnAdd;
    private Button mbtnRemove;
    private ImageView mlogo;
    private ImageView mindicator;
    private TextView mdetail;
    private TextView mtitle;
    private TextView mindicatorlbl;
    private int level = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);

        //find resource xml detail logo
        mlogo = findViewById(R.id.detailLogo);
        //find resource xml title
        mtitle = findViewById(R.id.detailTitle);
        //find resource xml desc.
        mdetail = findViewById(R.id.detailDesc);
        //find resource xml indicator image
        mindicator = findViewById(R.id.bttlIndicator);
        //find resource xml tombol remove
        mbtnRemove = findViewById(R.id.btnRemove);
        //find resource xml tombol tambah
        mbtnAdd = findViewById(R.id.btnAdd);
        //find resource xml nomor indikator
        mindicatorlbl = findViewById(R.id.nmbrIndicator);

        //getIntent
        Intent detail = getIntent();
        String title = detail.getStringExtra("Title");
        int imgIntent = detail.getIntExtra("Image Resource", 0);

        //mengatur judul pada setText dan image pada setImage
        mtitle.setText(title);
        mlogo.setImageResource(imgIntent);

        //memeberikan aksi saat button add di klik
        mbtnAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                tambahAir();}
        });
        //memberikan aksi saat button remove di klik
        mbtnRemove.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view) {
                kurangAir();
            }

        });
    }

    private void tambahAir() {
        status();
        if(level==6){
            Toast.makeText(this,"Air Penuh",Toast.LENGTH_SHORT).show();return;}
        mindicator.setImageLevel(++level);
    }

    private void kurangAir() {
        status();
        if(level==0){Toast.makeText(this,"Air Kosong",Toast.LENGTH_SHORT).show();return;}
        mindicator.setImageLevel(--level);
    }

    public void status(){
        mindicatorlbl.setText(""+level+"L");
    }


}
