package ma.ens.starsgallery.adapter;

import android.app.AlertDialog;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Filter;
import android.widget.Filterable;
import android.widget.ImageView;
import android.widget.RatingBar;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.request.RequestOptions;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

import ma.ens.starsgallery.R;
import ma.ens.starsgallery.beans.Star;
import ma.ens.starsgallery.service.StarService;

public class StarAdapter extends RecyclerView.Adapter<StarAdapter.StarViewHolder> implements Filterable {

    private final Context context;
    private final List<Star> originalStars;
    private List<Star> displayedStars;

    public StarAdapter(Context context, List<Star> stars) {
        this.context = context;
        this.originalStars = stars;
        this.displayedStars = new ArrayList<>(stars);
    }

    @NonNull
    @Override
    public StarViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View row = LayoutInflater.from(context).inflate(R.layout.star_item, parent, false);
        return new StarViewHolder(row);
    }

    @Override
    public void onBindViewHolder(@NonNull StarViewHolder holder, int position) {
        Star currentStar = displayedStars.get(position);

        holder.idText.setText(String.valueOf(currentStar.getId()));
        holder.nameText.setText(currentStar.getName().toUpperCase(Locale.ROOT));
        holder.ratingBar.setRating(currentStar.getStar());

        Glide.with(context)
                .load(currentStar.getImg())
                .apply(new RequestOptions()
                        .placeholder(R.drawable.star)
                        .error(R.drawable.star)
                        .centerCrop())
                .into(holder.photo);

        holder.itemView.setAlpha(0f);
        holder.itemView.setTranslationY(40f);
        holder.itemView.animate()
                .alpha(1f)
                .translationY(0f)
                .setDuration(450)
                .setStartDelay(position * 70L)
                .start();

        holder.itemView.setOnClickListener(view -> showRatingDialog(currentStar, holder.getAdapterPosition()));
    }

    @Override
    public int getItemCount() {
        return displayedStars.size();
    }

    private void showRatingDialog(Star selectedStar, int adapterPosition) {
        if (adapterPosition == RecyclerView.NO_POSITION) {
            return;
        }

        View dialogView = LayoutInflater.from(context).inflate(R.layout.star_edit_item, null, false);

        TextView hiddenId = dialogView.findViewById(R.id.idss);
        ImageView dialogImage = dialogView.findViewById(R.id.imgDialog);
        RatingBar dialogRating = dialogView.findViewById(R.id.ratingBar);

        hiddenId.setText(String.valueOf(selectedStar.getId()));
        dialogRating.setRating(selectedStar.getStar());

        Glide.with(context)
                .load(selectedStar.getImg())
                .apply(new RequestOptions()
                        .placeholder(R.drawable.star)
                        .error(R.drawable.star)
                        .centerCrop())
                .into(dialogImage);

        AlertDialog dialog = new AlertDialog.Builder(context)
                .setTitle("Modifier la note")
                .setMessage("Donner une nouvelle note entre 1 et 5 :")
                .setView(dialogView)
                .setNegativeButton("Annuler", null)
                .setPositiveButton("Valider", (dialogInterface, which) -> {
                    int id = Integer.parseInt(hiddenId.getText().toString());
                    float newScore = dialogRating.getRating();

                    Star starToUpdate = StarService.getInstance().findById(id);

                    if (starToUpdate != null) {
                        starToUpdate.setStar(newScore);
                        StarService.getInstance().update(starToUpdate);
                        notifyItemChanged(adapterPosition);
                    }
                })
                .create();

        dialog.show();
    }

    @Override
    public Filter getFilter() {
        return starFilter;
    }

    private final Filter starFilter = new Filter() {
        @Override
        protected FilterResults performFiltering(CharSequence constraint) {
            List<Star> filteredList = new ArrayList<>();

            if (constraint == null || constraint.length() == 0) {
                filteredList.addAll(originalStars);
            } else {
                String typedText = constraint.toString().toLowerCase(Locale.ROOT).trim();

                for (Star star : originalStars) {
                    if (star.getName().toLowerCase(Locale.ROOT).contains(typedText)) {
                        filteredList.add(star);
                    }
                }
            }

            FilterResults results = new FilterResults();
            results.values = filteredList;
            results.count = filteredList.size();

            return results;
        }

        @Override
        protected void publishResults(CharSequence constraint, FilterResults results) {
            displayedStars = (List<Star>) results.values;
            notifyDataSetChanged();
        }
    };

    public static class StarViewHolder extends RecyclerView.ViewHolder {

        ImageView photo;
        TextView nameText;
        TextView idText;
        RatingBar ratingBar;

        public StarViewHolder(@NonNull View itemView) {
            super(itemView);

            photo = itemView.findViewById(R.id.img);
            nameText = itemView.findViewById(R.id.name);
            idText = itemView.findViewById(R.id.ids);
            ratingBar = itemView.findViewById(R.id.stars);
        }
    }
}
