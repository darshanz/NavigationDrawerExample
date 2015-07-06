package me.games.navigationdrawerexample;

import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import org.w3c.dom.Text;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {


    private DrawerLayout mDrawerLayout;
    private ActionBarDrawerToggle mDrawerToggle;


    private RecyclerView mRecyclerView;
    private TextView mAppTitle;

    private RecyclerView.LayoutManager layoutManager;
    private DrawerAdapter mDrawerAdapter;

    private ArrayList<DrawerItem> mDrawerItemList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        Toolbar appBar = (Toolbar) findViewById(R.id.appBar);
        setSupportActionBar(appBar);

        mDrawerLayout = (DrawerLayout) findViewById(R.id.drawerLayout);
        mRecyclerView = (RecyclerView) findViewById(R.id.drawerRecyclerView);
        mAppTitle = (TextView) findViewById(R.id.textView);


        //Dummy Data
        mDrawerItemList = new ArrayList<DrawerItem>();
        DrawerItem item = new DrawerItem();
        item.setIcon(R.drawable.inbox);
        item.setTitle("Inbox");
        mDrawerItemList.add(item);

        DrawerItem item2 = new DrawerItem();
        item2.setIcon(R.drawable.send);
        item2.setTitle("Send");
        mDrawerItemList.add(item2);


        DrawerAdapter adapter = new DrawerAdapter(mDrawerItemList);

        mRecyclerView.setLayoutManager(new LinearLayoutManager(this));
        mRecyclerView.setAdapter(adapter);


        mDrawerToggle = new ActionBarDrawerToggle(this, mDrawerLayout, appBar, R.string.open, R.string.close) {
            @Override
            public void onDrawerClosed(View drawerView) {
                super.onDrawerClosed(drawerView);
                //TODO Add some action here
                //Executed when drawer closes

                Toast.makeText(MainActivity.this, "Closed", Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onDrawerOpened(View drawerView) {
                super.onDrawerOpened(drawerView);
                //TODO Add some action here
                //executes when drawer open
                Toast.makeText(MainActivity.this, "Opened", Toast.LENGTH_SHORT).show();
            }
        };
        mDrawerLayout.setDrawerListener(mDrawerToggle);
        mDrawerToggle.syncState();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
