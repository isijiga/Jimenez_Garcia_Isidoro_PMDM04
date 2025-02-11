package dam.pmdm.spyrothedragon.adapters;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.VideoView;

import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

import dam.pmdm.spyrothedragon.R;
import dam.pmdm.spyrothedragon.models.Collectible;

public class CollectiblesAdapter extends RecyclerView.Adapter<CollectiblesAdapter.CollectiblesViewHolder> {

    private List<Collectible> list;
    int countGemas = 0;
    private ViewGroup fragmentView;

    public CollectiblesAdapter(List<Collectible> collectibleList, View fragmentView) {
        this.list = collectibleList;
        this.fragmentView = (ViewGroup) fragmentView;
    }

    @Override
    public CollectiblesViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.cardview, parent, false);
        return new CollectiblesViewHolder(view);
    }

    @Override
    public void onBindViewHolder(CollectiblesViewHolder holder, int position) {
        Collectible collectible = list.get(position);
        holder.nameTextView.setText(collectible.getName());

        // Cargar la imagen (simulado con un recurso drawable)
        int imageResId = holder.itemView.getContext().getResources().getIdentifier(collectible.getImage(), "drawable", holder.itemView.getContext().getPackageName());
        holder.imageImageView.setImageResource(imageResId);

        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (collectible.getName().equals("Gemas")) {
                    countGemas++;
                    if (countGemas == 4) {
                        Log.d("GEMAS", "Easter Egg num1");

                        VideoView videoView = new VideoView(holder.itemView.getContext());
                        videoView.setLayoutParams(new ViewGroup.LayoutParams(
                                ViewGroup.LayoutParams.MATCH_PARENT,
                                ViewGroup.LayoutParams.MATCH_PARENT));
                        fragmentView.addView(videoView);

                        videoView.setVideoPath("android.resource://" + holder.itemView.getContext().getPackageName() +
                                "/" + R.raw.eastereggvideo);
                        videoView.start();
                        videoView.setOnCompletionListener(mp -> {
                            fragmentView.removeView(videoView);
                        });

                    }
                }
                if (!collectible.getName().equals("Gemas")) {
                    countGemas = 0;
                    Log.d("GEMAS", "Gemas:" + countGemas);
                    ;
                }
            }
        });


    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public static class CollectiblesViewHolder extends RecyclerView.ViewHolder {

        TextView nameTextView;
        ImageView imageImageView;

        public CollectiblesViewHolder(View itemView) {
            super(itemView);
            nameTextView = itemView.findViewById(R.id.name);
            imageImageView = itemView.findViewById(R.id.image);


        }


    }
}
