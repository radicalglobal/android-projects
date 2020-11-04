package com.example.marvelsvideos;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.content.res.Configuration;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.view.View;
import android.webkit.WebChromeClient;
import android.widget.FrameLayout;
import android.widget.ImageView;

import com.pierfrancescosoffritti.androidyoutubeplayer.core.player.YouTubePlayer;
import com.pierfrancescosoffritti.androidyoutubeplayer.core.player.listeners.AbstractYouTubePlayerListener;
import com.pierfrancescosoffritti.androidyoutubeplayer.core.player.listeners.YouTubePlayerFullScreenListener;
import com.pierfrancescosoffritti.androidyoutubeplayer.core.player.views.YouTubePlayerView;

import java.util.ArrayList;

public class VideoFullScreen extends AppCompatActivity implements MyRecyclerViewAdapter.ItemClickListener {

    YouTubePlayerView youTubePlayerView;
    RecyclerView recyclerView;

    ArrayList<DataSetList> arrayList;
    MyRecyclerViewAdapter adapter;
    String link;

    ImageView homeback;

    androidx.appcompat.widget.Toolbar toolbar;

    @SuppressLint("WrongConstant")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_video_full_screen);

        //getting the toolbar
        toolbar = findViewById(R.id.youtubetoolbar);
        homeback = findViewById(R.id.home_back);
        homeback.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(VideoFullScreen.this, MainActivity.class);
                startActivity(intent);
            }
        });

        recyclerView = findViewById(R.id.recycler_view);
        recyclerView.setLayoutManager(new LinearLayoutManager(VideoFullScreen.this));
        recyclerView.setHasFixedSize(true);
        arrayList = new ArrayList<DataSetList>();

        DataSetList dataSetList = new DataSetList("Here Are Marvel’s Next Six Movies After 'Endgame'","https://i.ytimg.com/vi_webp/CX17qmYO0o0/maxresdefault.webp ", "https://www.youtube.com/embed/CX17qmYO0o0");
        arrayList.add(dataSetList);
        dataSetList = new DataSetList("Team Iron Man vs Team Cap - Airport Battle Scene - Captain America: Civil War - Movie CLIP HD","https://i.ytimg.com/vi_webp/cfVY9wLKltA/maxresdefault.webp", "https://www.youtube.com/embed/cfVY9wLKltA");
        arrayList.add(dataSetList);
        dataSetList = new DataSetList("Thor vs Hulk - Fight Scene - The Avengers (2012) Movie Clip HD","https://i.ytimg.com/vi_webp/SLD9xzJ4oeU/maxresdefault.webp", "https://www.youtube.com/embed/SLD9xzJ4oeU");
        arrayList.add(dataSetList);
        dataSetList = new DataSetList("Superman vs Hulk - The Fight (Part 4)","https://i.ytimg.com/vi_webp/pBbsvavno8I/maxresdefault.webp", "https://www.youtube.com/embed/pBbsvavno8I");
        arrayList.add(dataSetList);
        dataSetList = new DataSetList("THE INCREDIBLE HULK (2008) University Battle [HD] Hulk Smash","https://i.ytimg.com/vi/n4tWT-Tzff0/maxresdefault.jpg", "https://www.youtube.com/embed/n4tWT-Tzff0");
        arrayList.add(dataSetList);
        dataSetList = new DataSetList("Iron Man (2008) - Cave Battle Scene (3/9) | Movieclips","https://i.ytimg.com/vi_webp/n4BJBz8GpzI/maxresdefault.webp", "https://www.youtube.com/embed/n4BJBz8GpzI");
        arrayList.add(dataSetList);
        dataSetList = new DataSetList("Iron Man Clip: Gulmira Fight Scene","https://i.ytimg.com/vi/DTqa-NEwUbs/maxresdefault.jpg    ", "https://www.youtube.com/embed/DTqa-NEwUbs");
        arrayList.add(dataSetList);
        dataSetList = new DataSetList("Dogfight - Iron Man","https://i.ytimg.com/vi/7phiJ-vxr0A/sddefault.jpg", "https://www.youtube.com/embed/7phiJ-vxr0A");
        arrayList.add(dataSetList);
        dataSetList = new DataSetList("Iron Man Vs War Machine With Health Bars","https://i.ytimg.com/vi_webp/tclEG6-t3Lo/maxresdefault.webp", "https://www.youtube.com/embed/tclEG6-t3Lo");
        arrayList.add(dataSetList);
        dataSetList = new DataSetList("Avengers Thor vs Ironman vs Captain America","https://i.ytimg.com/vi_webp/CcTHcNkuNUM/maxresdefault.webp", "https://www.youtube.com/embed/CcTHcNkuNUM");
        arrayList.add(dataSetList);
        dataSetList = new DataSetList("Captain America: The Winter Soldier Highway Fight Scene","https://i.ytimg.com/vi/qXPOl6EjbWg/maxresdefault.jpg", "https://www.youtube.com/embed/qXPOl6EjbWg");
        arrayList.add(dataSetList);
        dataSetList = new DataSetList("Captain America vs The Winter Soldier 2nd Fight...with healthbars","https://i.ytimg.com/vi_webp/3e3PEuZipxQ/maxresdefault.webp", "https://www.youtube.com/embed/3e3PEuZipxQ");
        arrayList.add(dataSetList);
        dataSetList = new DataSetList("Black Panther vs Bucky - Rooftop Fight - Chase Scene | Captain America Civil War (2016) Movie Clip","https://i.ytimg.com/vi_webp/pTuyzp6F4V8/maxresdefault.webp", "https://www.youtube.com/embed/pTuyzp6F4V8");
        arrayList.add(dataSetList);
        dataSetList = new DataSetList("Airport Battle - Spider-Man \"Hey Everyone\" - Argument Scene | Captain America Civil War (2016) IMAX","https://i.ytimg.com/vi_webp/wVY-t6BA3fU/maxresdefault.webp", "https://www.youtube.com/embed/wVY-t6BA3fU");
        arrayList.add(dataSetList);
        dataSetList = new DataSetList("Airport Battle - War Machine Falls - Fight Scene | Captain America Civil War (2016) IMAX","https://i.ytimg.com/vi_webp/bBFkn-CGMUc/maxresdefault.webp", "https://www.youtube.com/embed/bBFkn-CGMUc");
        arrayList.add(dataSetList);
        dataSetList = new DataSetList("Iron Man Clip: Iron Man vs Iron Monger - Obadiah's Death","https://i.ytimg.com/vi/OQCy82iyG5o/maxresdefault.jpg", "https://www.youtube.com/embed/OQCy82iyG5o");
        arrayList.add(dataSetList);
        dataSetList = new DataSetList("The Incredible Hulk 2008 Fight Scene","https://i.ytimg.com/vi_webp/pfgmvMHc4us/maxresdefault.webp", "https://www.youtube.com/embed/pfgmvMHc4us");
        arrayList.add(dataSetList);
        dataSetList = new DataSetList("Iron Man and War Machine vs. Hammer Drones - Iron Man 2","https://i.ytimg.com/vi_webp/Nx2mhPEr7kA/maxresdefault.webp", "https://www.youtube.com/embed/Nx2mhPEr7kA");
        arrayList.add(dataSetList);
        dataSetList = new DataSetList("Thor.VS the Frost Giants_.mp4","https://i.ytimg.com/vi/mSbyknf4vJ4/maxresdefault.jpg", "https://www.youtube.com/embed/mSbyknf4vJ4");
        arrayList.add(dataSetList);
        dataSetList = new DataSetList("The AVENGERS {HQ]- \"I'm bringing the Party to you\" [..and Hulk, SMASH]","https://i.ytimg.com/vi_webp/EAjyjbb-Kfw/sddefault.webp", "https://www.youtube.com/embed/EAjyjbb-Kfw");
        arrayList.add(dataSetList);
        dataSetList = new DataSetList("The Avengers (2012) - Stark Death (MOVIE Scene) [HD 1080p]","https://i.ytimg.com/vi_webp/PGMQSnWNTbw/maxresdefault.webp", "https://www.youtube.com/embed/PGMQSnWNTbw");
        arrayList.add(dataSetList);
        dataSetList = new DataSetList("IRONMAN3 - \"Malibu Mansion Attack\" (HD)","https://i.ytimg.com/vi_webp/iqnLPRv2isA/maxresdefault.webp", "https://www.youtube.com/embed/iqnLPRv2isA");
        arrayList.add(dataSetList);
        dataSetList = new DataSetList("Iron Man 3 Tony breaks into the mantion","https://i.ytimg.com/vi/2rjrOk7zZ9Y/maxresdefault.jpg", "https://www.youtube.com/embed/2rjrOk7zZ9Y");
        arrayList.add(dataSetList);
        dataSetList = new DataSetList("Iron Man 3 - Escape Scene","https://i.ytimg.com/vi_webp/i4vAZZ8iLGY/maxresdefault.webp", "https://www.youtube.com/embed/i4vAZZ8iLGY");
        arrayList.add(dataSetList);
        dataSetList = new DataSetList("Iron man 3 ( final battle )","https://i.ytimg.com/vi/QLC8TN1Vqmg/sddefault.jpg", "https://www.youtube.com/embed/QLC8TN1Vqmg");
        arrayList.add(dataSetList);
        dataSetList = new DataSetList("Dark elves against asgardians...","https://i.ytimg.com/vi/AMg1NwzhB8Y/maxresdefault.jpg", "https://www.youtube.com/embed/AMg1NwzhB8Y");
        arrayList.add(dataSetList);
        dataSetList = new DataSetList("Thor: The Dark World (2013) - Battle in Vanaheim","https://i.ytimg.com/vi_webp/opK7mPZtBSI/maxresdefault.webp", "https://www.youtube.com/embed/opK7mPZtBSI");
        arrayList.add(dataSetList);
        dataSetList = new DataSetList("Captain America: The Winter Soldier- Black Widow Ship Fight Scene FULL HD","https://i.ytimg.com/vi/YCxlEi50bS0/maxresdefault.jpg", "https://www.youtube.com/embed/YCxlEi50bS0");
        arrayList.add(dataSetList);
        dataSetList = new DataSetList("Captain America The Winter Soldier Clip - Let's See - OFFICIAL Marvel | HD","https://i.ytimg.com/vi_webp/aHh0XaW0UyQ/sddefault.webp", "https://www.youtube.com/embed/aHh0XaW0UyQ");
        arrayList.add(dataSetList);
        dataSetList = new DataSetList("Captain America 2 - Elevator scene ( HD )","https://i.ytimg.com/vi_webp/jqIBGEcKhGs/maxresdefault.webp", "https://www.youtube.com/embed/jqIBGEcKhGs");
        arrayList.add(dataSetList);
        dataSetList = new DataSetList("Captain America Winter Soldier Car Chase Fight[HD]","https://i.ytimg.com/vi/7Avymog_CEQ/maxresdefault.jpg", "https://www.youtube.com/embed/7Avymog_CEQ");
        arrayList.add(dataSetList);
        dataSetList = new DataSetList("Star lord dance - Guardians of the galaxy scene | HD 720p","https://i.ytimg.com/vi_webp/u8ohTJp3PAA/maxresdefault.webp", "https://www.youtube.com/embed/u8ohTJp3PAA");
        arrayList.add(dataSetList);
        dataSetList = new DataSetList("Tesseract Stolen | Captain America | The First Avenger","https://i.ytimg.com/vi_webp/BbScGx17uxs/maxresdefault.webp", "https://www.youtube.com/embed/BbScGx17uxs");
        arrayList.add(dataSetList);
        dataSetList = new DataSetList("Steve Rogers and Bucky Barnes first look | Captain America-The First Avenger(2011) movie clip\n","https://i.ytimg.com/vi_webp/qRFrpgybUZU/maxresdefault.webp", "https://www.youtube.com/embed/qRFrpgybUZU");
        arrayList.add(dataSetList);
        dataSetList = new DataSetList("Captain America: The First Avenger-Soldier(2/11)\n","https://i.ytimg.com/vi_webp/FrOarhBIsj8/maxresdefault.webp", "https://www.youtube.com/embed/FrOarhBIsj8");
        arrayList.add(dataSetList);
        dataSetList = new DataSetList("The Tesseract Experiment | Captain America | The First Avenger\n","https://i.ytimg.com/vi_webp/_HxVlr1YxyM/sddefault.webp", "https://www.youtube.com/embed/_HxVlr1YxyM");
        arrayList.add(dataSetList);
        dataSetList = new DataSetList("The Masterpiece | Captain America | The First Avenger\n","https://i.ytimg.com/vi_webp/Ovv-JxMu-Ik/sddefault.webp", "https://www.youtube.com/embed/Ovv-JxMu-Ik");
        arrayList.add(dataSetList);
        dataSetList = new DataSetList("Steve Roger (After Transformation Scene)\n","https://i.ytimg.com/vi/FRWNieb1O58/maxresdefault.jpg", "https://www.youtube.com/embed/FRWNieb1O58");
        arrayList.add(dataSetList);
        dataSetList = new DataSetList("The Incredible Hulk (2008) - Alternate Opening In the Arctic\n","https://i.ytimg.com/vi_webp/JzSWaMAcMbg/maxresdefault.webp", "https://www.youtube.com/embed/JzSWaMAcMbg");
        arrayList.add(dataSetList);
        dataSetList = new DataSetList("Tony Saves Yinsen - Iron Man (2008)\n","https://i.ytimg.com/vi_webp/KMnhlduZvY8/maxresdefault.webp", "https://www.youtube.com/embed/KMnhlduZvY8");
        arrayList.add(dataSetList);
        dataSetList = new DataSetList("Avengers: Infinity War (2018) - \"Attack On The Statesman\" | Movie Clip\n","https://i.ytimg.com/vi_webp/X3xJXz7Q8e0/maxresdefault.webp", "https://www.youtube.com/embed/X3xJXz7Q8e0");
        arrayList.add(dataSetList);
        dataSetList = new DataSetList("Hulk vs Thanos - Fight Scenes - Averages Infinity War HD Clip\n","https://i.ytimg.com/vi_webp/bCiT6psniYc/maxresdefault.webp", "https://www.youtube.com/embed/bCiT6psniYc");
        arrayList.add(dataSetList);
        dataSetList = new DataSetList("Thanos Kills Heimdall - Thanos Collects Space Stone - Avengers Infinity War (2018) Movie CLIP 4K HD\n","https://i.ytimg.com/vi_webp/pN9ykgplyZc/maxresdefault.webp", "https://www.youtube.com/embed/pN9ykgplyZc");
        arrayList.add(dataSetList);
        dataSetList = new DataSetList("Thanos Kills Loki - Loki Death Scene - Avengers Infinity War (2018) Movie CLIP 4K ULTRA HD\n","https://i.ytimg.com/vi_webp/t1Hrt_oWauU/maxresdefault.webp", "https://www.youtube.com/embed/t1Hrt_oWauU");
        arrayList.add(dataSetList);
        dataSetList = new DataSetList("Avengers: Infinity War - Getting Into The Q-ship (open matte)\n","https://i.ytimg.com/vi_webp/6PRLI5_2G2U/maxresdefault.webp", "https://www.youtube.com/embed/6PRLI5_2G2U");
        arrayList.add(dataSetList);
        dataSetList = new DataSetList("The Winter Soldier Awakens - Opening Scene | Captain America Civil War (2016) Movie Clip 4K","https://i.ytimg.com/vi_webp/ekeRy3EL4DI/maxresdefault.webp", "https://www.youtube.com/embed/ekeRy3EL4DI");
        arrayList.add(dataSetList);
        dataSetList = new DataSetList("Cap & Bucky Quinjet Talk - Tony Stark Finds Out Bucky Was Framed | Captain America Civil War (2016)","https://i.ytimg.com/vi_webp/6vBE4d2UXXY/maxresdefault.webp", "https://www.youtube.com/embed/6vBE4d2UXXY");
        arrayList.add(dataSetList);
        dataSetList = new DataSetList("Captain America: Civil War - Prison Scene | Mark 46 Suit Up 4k\n","https://i.ytimg.com/vi_webp/7tkZUVNkvDM/maxresdefault.webp", "https://www.youtube.com/embed/7tkZUVNkvDM");
        arrayList.add(dataSetList);
        dataSetList = new DataSetList("Captain America: Civil War - Final Fight Part 1/2 Iron Man vs Captain America and Bucky 4k\n","https://i.ytimg.com/vi_webp/miIdmycUH38/maxresdefault.webp", "https://www.youtube.com/embed/miIdmycUH38");
        arrayList.add(dataSetList);
        dataSetList = new DataSetList("Captain America: Civil War - Final Fight Part 2/2 Iron Man vs Captain America and Bucky 4k\n","https://i.ytimg.com/vi_webp/EUuq31plRuA/maxresdefault.webp", "https://www.youtube.com/embed/EUuq31plRuA");
        arrayList.add(dataSetList);

        adapter = new MyRecyclerViewAdapter(VideoFullScreen.this,arrayList);

        recyclerView.setAdapter(adapter);
        adapter.setClickListener(VideoFullScreen.this);

        link = getIntent().getStringExtra("link");

        youTubePlayerView = findViewById(R.id.full_video);
        getLifecycle().addObserver(youTubePlayerView);

        youTubePlayerView.addYouTubePlayerListener(new AbstractYouTubePlayerListener() {
            @Override
            public void onReady(@NonNull YouTubePlayer youTubePlayer) {
                String videoId = link;
                youTubePlayer.loadVideo(videoId, 0);

            }

        });

        youTubePlayerView.addFullScreenListener(new YouTubePlayerFullScreenListener() {

            @Override
            public void onYouTubePlayerEnterFullScreen() {
                setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_LANDSCAPE);
                toolbar.setVisibility(View.GONE);

            }

            @Override
            public void onYouTubePlayerExitFullScreen() {
                setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);
                toolbar.setVisibility(View.VISIBLE);

            }
        });

        if (savedInstanceState==null) {
            youTubePlayerView.post(new Runnable() {
                @Override
                public void run() {
                    getClassLoader();
                }
            });
        }
    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
        Intent intent = new Intent(VideoFullScreen.this, MainActivity.class);
        this.startActivity(intent);
    }

    @Override //reconfigure display properties on screen rotation
    public void onConfigurationChanged(Configuration newConfig) {
        super.onConfigurationChanged(newConfig);
    }

    @Override
    protected void onSaveInstanceState(Bundle outState )
    {
        super.onSaveInstanceState(outState);

    }

    @Override
    protected void onRestoreInstanceState(Bundle savedInstanceState)
    {
        super.onRestoreInstanceState(savedInstanceState);

    }

    @Override
    public void onItemClick(int position) {

        DataSetList dataSetList = arrayList.get(position);
        String link = dataSetList.getLink();
        String substr = link.substring(link.length() - 11);
        Intent intent = new Intent(VideoFullScreen.this, VideoFullScreen.class);
        intent.putExtra("link", substr);
        this.startActivity(intent);

    }


    private class MyChrome extends WebChromeClient {

        private View mCustomView;
        private WebChromeClient.CustomViewCallback mCustomViewCallback;
        protected FrameLayout mFullscreenContainer;
        private int mOriginalOrientation;
        private int mOriginalSystemUiVisibility;

        MyChrome() {}

        public Bitmap getDefaultVideoPoster()
        {
            if (mCustomView == null) {
                return null;
            }
            return BitmapFactory.decodeResource(getApplicationContext().getResources(), 2130837573);
        }

        public void onHideCustomView()
        {
            ((FrameLayout)getWindow().getDecorView()).removeView(this.mCustomView);
            this.mCustomView = null;
            getWindow().getDecorView().setSystemUiVisibility(this.mOriginalSystemUiVisibility);
            setRequestedOrientation(this.mOriginalOrientation);
            this.mCustomViewCallback.onCustomViewHidden();
            this.mCustomViewCallback = null;
        }

        public void onShowCustomView(View paramView, WebChromeClient.CustomViewCallback paramCustomViewCallback)
        {
            if (this.mCustomView != null)
            {
                onHideCustomView();
                return;
            }
            this.mCustomView = paramView;
            this.mOriginalSystemUiVisibility = getWindow().getDecorView().getSystemUiVisibility();
            this.mOriginalOrientation = getRequestedOrientation();
            this.mCustomViewCallback = paramCustomViewCallback;
            ((FrameLayout)getWindow().getDecorView()).addView(this.mCustomView, new FrameLayout.LayoutParams(-1, -1));
            getWindow().getDecorView().setSystemUiVisibility(3846 | View.SYSTEM_UI_FLAG_LAYOUT_STABLE);
        }
    }
}