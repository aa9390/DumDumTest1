package org.androidtown.dumdumtest1;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.Button;
import android.widget.ImageView;

import com.bumptech.glide.Glide;

import butterknife.BindView;
import butterknife.ButterKnife;

public class WriteAcivity extends AppCompatActivity {

    @BindView(R.id.button)
    Button button;
    @BindView(R.id.im)
    ImageView im;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate( savedInstanceState );
        setContentView( R.layout.activity_write );
        ButterKnife.bind( this );

        Glide.with( this ).load( "R.drawble.soyeon" ).into( im );
    }

}
