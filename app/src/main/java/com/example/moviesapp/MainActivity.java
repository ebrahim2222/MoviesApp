package com.example.moviesapp;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewpager.widget.ViewPager;

import android.os.Bundle;

import com.google.android.material.tabs.TabLayout;

import java.util.ArrayList;
import java.util.List;
import java.util.TimerTask;

public class MainActivity extends AppCompatActivity {
    ViewPager viewPager2;
    List<Movies> moviesList;
    private SliderAdapter adapter;
    TabLayout tabLayout;
    RecyclerView popularRv;
    MoviesAdapter moviesAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        viewPager2 = findViewById(R.id.main_movie_viewpager);
        tabLayout = findViewById(R.id.main_tab);
        moviesList = new ArrayList<Movies>();
        int [] images ={R.drawable.dracula,R.drawable.thedarkknights,R.drawable.noescape};
        String [] names = {"dracula","The Dark Knights","No Escape"};
        String [] desc = {"action film " ,"action film" ,"drama film"};
        String [] rating = {"5" ,"4" ,"3"};
        String [] link = {"" ,"" ,""};
        for(int i=0;i<images.length;i++)
        {
            moviesList.add(new Movies(names[i],desc[i],rating[i],link[i],images[i]));
        }

        adapter = new SliderAdapter(MainActivity.this,moviesList);
        viewPager2.setAdapter(adapter);
        tabLayout.setupWithViewPager(viewPager2);

        java.util.Timer timer = new java.util.Timer();
        timer.scheduleAtFixedRate(new Timer(),4000,6000);

        setUpPopularMoviesRecycler();


    }

    private void setUpPopularMoviesRecycler() {
        moviesAdapter = new MoviesAdapter();
        popularRv = findViewById(R.id.main_popular_rv);
        popularRv.setLayoutManager(new LinearLayoutManager(this,LinearLayoutManager.HORIZONTAL,false));
        popularRv.setAdapter(moviesAdapter);
        setData();

    }

    private void setData() {
        moviesAdapter.setData(MainActivity.this,moviesList);
        adapter.notifyDataSetChanged();
    }


    class  Timer extends TimerTask
    {
        @Override
        public void run() {
            MainActivity.this.runOnUiThread(new Runnable() {
                @Override
                public void run() {
                    if(viewPager2.getCurrentItem() < moviesList.size()-1)
                    {
                        viewPager2.setCurrentItem(viewPager2.getCurrentItem()+1);
                    }else
                    {
                        viewPager2.setCurrentItem(0);
                    }
                }
            });
        }
    }
}