package com.example.nikhilgupta.myappportfolio;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.LayoutInflater;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

import static android.app.PendingIntent.getActivity;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });

        ArrayList<AppRow> ar=new ArrayList<AppRow>();
        ar.add(new AppRow("Spotify Streamer"));
        ar.add(new AppRow("Super Duo (2 buttons: Football Scores App and Library App)"));
        ar.add(new AppRow("Build It Bigger"));
        ar.add(new AppRow("XYZ Reader"));
        ar.add(new AppRow("Capstone"));
        ListAdapter adapter = new ListAdapter(MainActivity.this,ar);
        ListView atomPaysListView = (ListView)findViewById(R.id.list_view_of_buttons);
        atomPaysListView.setAdapter(adapter);

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

    public void click(View view) {

        Toast.makeText(getApplicationContext(), "This button will launch my "+((AppRow) (((ListView) (view.getParent().getParent())).getItemAtPosition((((ListView) (view.getParent().getParent())).getPositionForView((LinearLayout)view.getParent()))))).name+" app!",
                Toast.LENGTH_SHORT)
                .show();
    }
}

class ListAdapter extends ArrayAdapter<AppRow> {

    private Context context;
    private ArrayList<AppRow> data = new ArrayList<AppRow>();

    public ListAdapter(Context context, ArrayList<AppRow> dataItem) {
        super(context, R.layout.list_item_button,dataItem);
        this.data = dataItem;
        this.context = context;
    }

    @Override
    public View getView(final int position, View convertView, ViewGroup parent) {
        ViewHolder viewHolder;
        if (convertView == null) {
            LayoutInflater inflater = LayoutInflater.from(context);
            convertView = inflater.inflate(R.layout.list_item_button, null);
            viewHolder = new ViewHolder();
            viewHolder.text = (TextView) convertView
                    .findViewById(R.id.text);
            viewHolder.button = (Button) convertView
                    .findViewById(R.id.button);
            convertView.setTag(viewHolder);
        } else {
            viewHolder = (ViewHolder) convertView.getTag();
        }
        final String temp = getItem(position).name;
        viewHolder.text.setText(temp);


        return convertView;
    }

    public class ViewHolder {
        TextView text;
        Button button;
    }
}
