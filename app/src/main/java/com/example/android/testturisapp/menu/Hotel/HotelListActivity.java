package com.example.android.testturisapp.menu.Hotel;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.android.testturisapp.R;

import com.example.android.testturisapp.menu.Hotel.dummy.ModeloHotel;

import java.util.List;

/**
 * An activity representing a list of Hoteles. This activity
 * has different presentations for handset and tablet-size devices. On
 * handsets, the activity presents a list of items, which when touched,
 * lead to a {@link HotelDetailActivity} representing
 * item details. On tablets, the activity presents the list of items and
 * item details side-by-side using two vertical panes.
 */
public class HotelListActivity extends AppCompatActivity {

    /**
     * Whether or not the activity is in two-pane mode, i.e. running on a tablet
     * device.
     */
    private boolean mTwoPane;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_hotel_list);

        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        toolbar.setTitle(getTitle());

        ///arrow
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
      /**/
            FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
            fab.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                            .setAction("Action", null).show();
                }
            });

            if (findViewById(R.id.hotel_detail_container) != null)
            {
                // The detail container view will be present only in the
                // large-screen layouts (res/values-w900dp).
                // If this view is present, then the
                // activity should be in two-pane mode.
                mTwoPane = true;
            }

        View recyclerView = findViewById(R.id.hotel_list);
        assert recyclerView != null;
        setupRecyclerView((RecyclerView) recyclerView);
    }

    private void setupRecyclerView(@NonNull RecyclerView recyclerView) {
        recyclerView.setAdapter(new SimpleItemRecyclerViewAdapter(this, ModeloHotel.ITEMS, mTwoPane));
    }

    public static class SimpleItemRecyclerViewAdapter
            extends RecyclerView.Adapter<SimpleItemRecyclerViewAdapter.ViewHolder> {

        private final HotelListActivity mParentActivity;
        private final List<ModeloHotel.Hotel> mValues;
        private final boolean mTwoPane;
        private final View.OnClickListener mOnClickListener = new View.OnClickListener() {
            @Override
            public void onClick(View view)
            {
                ModeloHotel.Hotel item = (ModeloHotel.Hotel) view.getTag();
                if (mTwoPane)
                {
                    Bundle arguments = new Bundle();

                    arguments.putString(HotelDetailFragment.ARG_ITEM_ID, item.id);
                    HotelDetailFragment fragment = new HotelDetailFragment();
                    fragment.setArguments(arguments);

                    mParentActivity.getSupportFragmentManager().beginTransaction()
                            .replace(R.id.hotel_detail_container, fragment)
                            .commit();
                }
                else
                    {
                    Context context = view.getContext();
                    Intent intent = new Intent(context, HotelDetailActivity.class);
                    intent.putExtra(HotelDetailFragment.ARG_ITEM_ID, item.id);

                    context.startActivity(intent);
                    }
            }
        };

        SimpleItemRecyclerViewAdapter(HotelListActivity parent,
                                      List<ModeloHotel.Hotel> items,
                                      boolean twoPane) {
            mValues = items;
            mParentActivity = parent;
            mTwoPane = twoPane;
        }

        @Override
        public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
            View view = LayoutInflater.from(parent.getContext())
                    .inflate(R.layout.hotel_list_content, parent, false);
            return new ViewHolder(view);
        }

        @Override
        public void onBindViewHolder(final ViewHolder holder, int position)
        {
            holder.mNombreView.setText(mValues.get(position).nombre);
            holder.mDescripcionView.setText(mValues.get(position).descripcion);
            holder.mUbicacionView.setText(mValues.get(position).ubicacion);
            holder.mImagenView.setImageResource(mValues.get(position).imagen);

            holder.itemView.setTag(mValues.get(position));
            holder.itemView.setOnClickListener(mOnClickListener);
        }

        @Override
        public int getItemCount()
        {
            return mValues.size();
        }

        class ViewHolder extends RecyclerView.ViewHolder
        {
            final TextView mNombreView;
            final TextView mDescripcionView;
            final TextView mUbicacionView;
            final ImageView mImagenView;


            ViewHolder(View view)
            {
                super(view);
                mNombreView = (TextView) view.findViewById(R.id.txt_nombre);
                mDescripcionView = (TextView) view.findViewById(R.id.txt_description);
                mUbicacionView = (TextView) view.findViewById(R.id.txt_ubication);
                mImagenView = (ImageView) view.findViewById(R.id.image_id);
            }
        }
    }
}
