package com.cispl.trental_demo;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewpager2.widget.ViewPager2;




import java.util.List;



public class SliderAdaptor extends RecyclerView.Adapter<SliderAdaptor.SliderImageView>{
private List<SliderItem> sliderItems;

    public SliderAdaptor(List<SliderItem> sliderItems, ViewPager2 viewPager2) {
        this.sliderItems = sliderItems;
        this.viewPager2 = viewPager2;
    }

    private ViewPager2 viewPager2;

    @NonNull
    @Override
    public SliderImageView onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new SliderImageView(LayoutInflater.from(parent.getContext()).inflate(
                R.layout.slider_item_container,
                parent,
                false));
    }

    @Override
    public void onBindViewHolder(@NonNull SliderImageView holder, int position) {
        holder.setCircleImageView(sliderItems.get(position));

        if (position == sliderItems.size() -2){
            viewPager2.post(runnable);
        }
    }


    @Override
    public int getItemCount() {
        return sliderItems.size();
    }

    class  SliderImageView extends RecyclerView.ViewHolder{

        private ImageView circleImageView;

         SliderImageView(@NonNull View itemView) {
            super(itemView);
            circleImageView = itemView.findViewById(R.id.image_slide);

        }
        void setCircleImageView(SliderItem sliderItem){
            circleImageView.setImageResource(sliderItem.getImage());
        }
    }

    private Runnable runnable = new Runnable() {
        @Override
        public void run() {
            sliderItems.addAll(sliderItems);
            notifyDataSetChanged();

        }
    };
}
