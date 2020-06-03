package com.example.misfitcoders;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.firebase.ui.firestore.FirestoreRecyclerAdapter;
import com.firebase.ui.firestore.FirestoreRecyclerOptions;

public class Adapter extends FirestoreRecyclerAdapter<Card, Adapter.Holder> {

    public Adapter(@NonNull FirestoreRecyclerOptions<Card> options) {
        super(options);
    }

    @Override
    protected void onBindViewHolder(@NonNull Holder holder, int position, @NonNull Card model) {

        holder.textViewName.setText(model.getName());
        holder.textViewMembers.setText(model.getMembers());
        holder.textViewSeats.setText(String.valueOf(model.getSeats()));
        holder.textViewDestination.setText(model.getDestination());
        holder.textViewTime.setText(model.getTime());
        holder.textViewPhoneNo.setText(model.getPhoneNo());
    }

    @NonNull
    @Override
    public Holder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.card_item,
                parent, false);
        return new Holder(v);
    }
    public void deleteItem(int position) {
        getSnapshots().getSnapshot(position).getReference().delete();
    }

    class Holder extends RecyclerView.ViewHolder{
        TextView textViewName;
        TextView textViewMembers;
        TextView textViewSeats;
        TextView textViewDestination;
        TextView textViewTime;
        TextView textViewPhoneNo;

        public Holder(View itemView) {
            super(itemView);
            textViewName = itemView.findViewById(R.id.text_view_name);
            textViewMembers = itemView.findViewById(R.id.text_view_members);
            textViewSeats = itemView.findViewById(R.id.text_view_seats);
            textViewDestination = itemView.findViewById(R.id.text_view_Destination);
            textViewTime = itemView.findViewById(R.id.text_view_time);
            textViewPhoneNo = itemView.findViewById(R.id.text_view_PhoneNo);

        }

    }
}
