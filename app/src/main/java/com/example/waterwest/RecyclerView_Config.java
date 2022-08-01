package com.example.waterwest;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class RecyclerView_Config {
    private Context mContext;
    private  DayAdapter mDayAdapter;
    public void setConfig(RecyclerView recyclerView, Context context, List<Day> days, List<String> keys){
        mContext = context;
        mDayAdapter = new DayAdapter(days, keys);
        recyclerView.setLayoutManager(new LinearLayoutManager(context));
        recyclerView.setAdapter(mDayAdapter);

    }

    class DayItemView extends RecyclerView.ViewHolder{
        private TextView waterLevel, valueOne, valueTwo,valueThree;
        private String key;

        public DayItemView(ViewGroup parent) {
            super(LayoutInflater.from(mContext).
                    inflate(R.layout.activity_main, parent, false));

            //Finding relevant fields in Xml file
            /*
            valueOne = itemView.findViewById(R.id.firstChild);
            valueTwo = itemView.findViewById(R.id.secondChild);
            valueThree = itemView.findViewById(R.id.waterusage);*/
           waterLevel = itemView.findViewById(R.id.todayL);
        }
    
        public void bind(Day day, String key){

            //List containing all values of the branch
            ArrayList<Map.Entry<String, String>> nth = day.getTimes();
            //getting the last child on the branch
            Map.Entry<String, String> justice = nth.get(nth.size() - 1);

            //Setting values on Xml file
           // valueOne.setText(justice.getKey());
            waterLevel.setText(justice.getValue());
            //waterLevel.setText(day.getDate());
           // valueThree.setText(Double.toString(day.GetUsedAmount()));

            //ignore
            this.key = key;
        }
    }

    class DayAdapter extends RecyclerView.Adapter<DayItemView>{

        private List<Day> mDayList;
        private List<String> mKeys;

        public DayAdapter(List<Day> days, List<String> keys) {
            this.mDayList = days;
            this.mKeys = keys;
        }

        @NonNull
        @Override
        public DayItemView onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
            return new DayItemView(parent);
        }

        @Override
        public void onBindViewHolder(@NonNull DayItemView holder, int position) {
holder.bind(mDayList.get(position), mKeys.get(position));
        }

        @Override
        public int getItemCount() {
            return mDayList.size();
        }
    }

}
