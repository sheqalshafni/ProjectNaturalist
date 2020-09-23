package com.caffeinne.naturalisttracker.Adapter;

import android.content.Context;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.caffeinne.naturalisttracker.Class.AnimalItem;
import com.caffeinne.naturalisttracker.R;

import java.util.ArrayList;

import butterknife.BindView;
import butterknife.ButterKnife;

import static android.content.ContentValues.TAG;

public class AnimalAdapter extends RecyclerView.Adapter<AnimalAdapter.AnimalViewHolder> {

    private ArrayList<AnimalItem> mAnimalItems;
    public View.OnClickListener onClickListener;

    public static class AnimalViewHolder extends RecyclerView.ViewHolder {


        TextView animalName, animalPrice, sampledStatus, sampledQuantity;
        Button _btnStampSample, _btnAddSample, _btnDeductSample;

        public AnimalViewHolder(@NonNull View itemView) {
            super(itemView);

            animalName = itemView.findViewById(R.id._animalName);
            animalPrice = itemView.findViewById(R.id._animalPrice);
            sampledStatus = itemView.findViewById(R.id._sampledStatus);
            sampledQuantity = itemView.findViewById(R.id._sampledQuantity);
            _btnStampSample = itemView.findViewById(R.id._stampSample);
            _btnAddSample = itemView.findViewById(R.id._addAmount);
            _btnDeductSample = itemView.findViewById(R.id._deductAmount);
        }
    }

    public AnimalAdapter(ArrayList<AnimalItem> animalItems) {
        mAnimalItems = animalItems;
    }

    @NonNull
    @Override
    public AnimalViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.animal_cardview_item, parent, false);
        AnimalViewHolder animalViewHolder = new AnimalViewHolder(view);

        return animalViewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull final AnimalViewHolder holder, int position) {
        final AnimalItem animalItem = mAnimalItems.get(position);
        final int[] increaseSample = {0};

        holder.animalName.setText(animalItem.getAnimalName());
        holder.animalPrice.setText(animalItem.getAnimalPrice());
        holder.sampledStatus.setText(animalItem.getSampledStatus());
        holder.sampledQuantity.setText(animalItem.getSampledQuantity());

        if (holder.sampledStatus.getText().equals("Stamped")) {
            holder._btnStampSample.setText("Unstamp");
        }

        holder._btnStampSample.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                int sampleQuantity;
                sampleQuantity = Integer.parseInt(holder.sampledQuantity.getText().toString());

                if (holder.sampledStatus.getText().equals("Unstamped") && sampleQuantity < 0) {
                    /*Do nothing*/
                } else if (holder.sampledStatus.getText().equals("Unstamped") && sampleQuantity > 0) {
                    holder.sampledStatus.setText("Stamped");
                    holder._btnStampSample.setText("Unstamp");
                    increaseSample[0]--;
                    String a = String.valueOf(increaseSample[0]);
                    holder.sampledQuantity.setText(a);
                }
            }
        });

        holder._btnAddSample.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                //increased sample value by 1
                increaseSample[0]++;
                String a = String.valueOf(increaseSample[0]);
                holder.sampledQuantity.setText(a);

                /*if the sample quantity is less than 0
                 * disable deduct button sample and change text color*/

                /* Since the button is not being constantly checked, it will be checked when
                 * add button is clicked*/
                if (holder.sampledQuantity.getText().equals("0")) {
                    holder._btnDeductSample.setClickable(false);
                    holder._btnDeductSample.setTextColor(Color.parseColor("#F0F0F0"));
                } else {

                    /*set deduct button back to original state if sample > 0*/
                    holder._btnDeductSample.setClickable(true);
                    holder._btnDeductSample.setTextColor(Color.parseColor("#000000"));
                }

                /*if sample is = 10 disable add sample button and change the text color*/
                if (holder.sampledQuantity.getText().equals("10")) {
                    holder._btnAddSample.setTextColor(Color.parseColor("#F0F0F0"));
                    holder._btnAddSample.setClickable(false);
                }

            }
        });

        holder._btnDeductSample.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                /*prevent value from becoming negative*/
                if (increaseSample[0] <= 0) {
                    increaseSample[0] = 0;
                    holder._btnDeductSample.setClickable(false);
                    holder._btnDeductSample.setTextColor(Color.parseColor("#F0F0F0"));
                }
                /*decrease sample value by 1*/
                else {
                    increaseSample[0]--;
                    String a = String.valueOf(increaseSample[0]);
                    holder.sampledQuantity.setText(a);

                    /*set add sample button back to its original state*/
                    holder._btnAddSample.setTextColor(Color.parseColor("#000000"));
                    holder._btnAddSample.setClickable(true);
                    holder._btnDeductSample.setTextColor(Color.parseColor("#000000"));

                    /*disable deduct button when sample = 0*/
                    if (holder.sampledQuantity.getText().equals("0")) {
                        holder._btnDeductSample.setClickable(false);
                        holder._btnDeductSample.setTextColor(Color.parseColor("#F0F0F0"));
                    }
                }
            }
        });

    }

    @Override
    public int getItemCount() {
        return mAnimalItems.size();
    }
}
