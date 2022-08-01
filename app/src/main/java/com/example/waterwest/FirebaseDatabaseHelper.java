package com.example.waterwest;

import androidx.annotation.NonNull;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.List;

public class FirebaseDatabaseHelper {

    private FirebaseDatabase DB;
    private DatabaseReference DBR;
    private List<Day> days = new ArrayList();

    public interface DataStatus{ //what is the idea behind this interface?
        void DataIsLoaded(List<Day> days, List<String>keys);
        void DataIsInserted();
        void DataIsUpdated();
        void DataIsDeleted();

    }
    public FirebaseDatabaseHelper(){
        DB = FirebaseDatabase.getInstance("https://waterwest-default-rtdb.firebaseio.com/");
        DBR = DB.getReference("RasberryIds");
    }

    public void readDays(final DataStatus datastatus){
        DBR.child("ID").addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                days.clear();
                List<String> keys = new ArrayList<>();
                for (DataSnapshot keyNode: snapshot.getChildren()){
                    keys.add(keyNode.getKey());

                    //casting from FirebaseDatabase to Java Class
                    Day day = keyNode.getValue(Day.class);

                    days.add(day);
                }
                datastatus.DataIsLoaded(days,keys);
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });
    }

}
