package ma.ens.starsgallery.ui;

import android.content.Intent;
import android.os.Bundle;
import android.widget.ImageButton;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.SearchView;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import ma.ens.starsgallery.R;
import ma.ens.starsgallery.adapter.StarAdapter;
import ma.ens.starsgallery.service.StarService;

public class ListActivity extends AppCompatActivity {

    private RecyclerView recyclerView;
    private StarAdapter starAdapter;
    private SearchView searchViewStars;
    private ImageButton btnShare;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list);

        recyclerView = findViewById(R.id.recycle_view);
        searchViewStars = findViewById(R.id.searchViewStars);
        btnShare = findViewById(R.id.btnShare);

        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        starAdapter = new StarAdapter(this, StarService.getInstance().findAll());
        recyclerView.setAdapter(starAdapter);

        searchViewStars.clearFocus();
        searchViewStars.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String query) {
                starAdapter.getFilter().filter(query);
                return true;
            }

            @Override
            public boolean onQueryTextChange(String newText) {
                starAdapter.getFilter().filter(newText);
                return true;
            }
        });

        btnShare.setOnClickListener(v -> shareApplication());
    }

    private void shareApplication() {
        String message = "Découvre Stars Gallery : une application Android pour consulter, rechercher et noter des stars.";

        Intent shareIntent = new Intent(Intent.ACTION_SEND);
        shareIntent.setType("text/plain");
        shareIntent.putExtra(Intent.EXTRA_TEXT, message);

        startActivity(Intent.createChooser(shareIntent, "Partager l'application"));
    }
}
