package org.androidtown.dumdumtest1;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;

import com.gigamole.infinitecycleviewpager.VerticalInfiniteCycleViewPager;

import java.util.ArrayList;
import java.util.List;

import butterknife.ButterKnife;

public class MainActivity extends AppCompatActivity {

    Animation FabOpen, FabClose;
    Animation FRONT, BACK;
    FloatingActionButton fabMain, fabWrite, fabMypage;
    boolean isOpen = false;
    List<Integer> lstImages = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate( savedInstanceState );
        setContentView( R.layout.activity_main );
        ButterKnife.bind( this );
        //ButterKnife.bind( this );

        FabOpen = AnimationUtils.loadAnimation( this, R.anim.fab_open );
        FabClose = AnimationUtils.loadAnimation( this, R.anim.fab_close );

        FRONT = AnimationUtils.loadAnimation( this, R.anim.front );
        BACK = AnimationUtils.loadAnimation( this, R.anim.back );


        fabMain = findViewById( R.id.fabMain );
        fabWrite = findViewById( R.id.fabWrite );
        fabMypage = findViewById( R.id.fabMypage );

        fabMain.setOnClickListener( clickListener );
        fabWrite.setOnClickListener( clickListener );
        fabMypage.setOnClickListener( clickListener );


        initData();

        VerticalInfiniteCycleViewPager pager = (VerticalInfiniteCycleViewPager) findViewById( R.id.horizontal_cycle );
        InfiniteCycleViewAdapter adapter = new InfiniteCycleViewAdapter( lstImages, getBaseContext() );
        pager.setAdapter( adapter );

        //Glide.with(this).load("http://goo.gl/gEgYUd").into(imageView);
    }

    View.OnClickListener clickListener = new View.OnClickListener() {
        @Override
        public void onClick(View view) {
            switch (view.getId()) {
                case R.id.fabMain:
                    if (!isOpen) {
                        fabWrite.startAnimation( FabOpen );
                        fabMypage.startAnimation( FabOpen );
                        isOpen = true;
                    } else {
                        fabWrite.startAnimation( FabClose );
                        fabMypage.startAnimation( FabClose );
                        isOpen = false;
                    }
                    break;

            }
        }
    };

    public void initData() {
        lstImages.add( R.drawable.ghost1 );
        lstImages.add( R.drawable.ghost2 );
        lstImages.add( R.drawable.ghost3 );
        //lstImages.add( R.drawable.soyeon );


    }

    /*
    @OnClick(R.id.fabWrite)
    public void onViewClicked() {
        Intent intent = new Intent (MainActivity.this,WriteAcivity.class );
        startActivity( intent );

    }
    */
}
