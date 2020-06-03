package com.example.misfitcoders;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.provider.ContactsContract;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.widget.EditText;
import android.widget.NumberPicker;
import android.widget.Toast;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.firestore.CollectionReference;
import com.google.firebase.firestore.FirebaseFirestore;

import java.util.Objects;

public class NewCard extends AppCompatActivity {

    private EditText editTextName;
    private EditText editTextMembers;
    private EditText editTextDestination;
    private EditText editTextTime;
    private EditText editTextPhoneNo;


    private NumberPicker numberPickerSeat;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_new_card);
        Objects.requireNonNull(getSupportActionBar()).setHomeAsUpIndicator(R.drawable.ic_close);
        setTitle("Add Request");



        editTextName = findViewById(R.id.edit_text_Name);
        editTextMembers = findViewById(R.id.edit_text_Members);
        editTextDestination = findViewById(R.id.edit_text_Destination);
        editTextTime = findViewById(R.id.edit_text_time);
        editTextPhoneNo = findViewById(R.id.edit_text_PhoneNo);
        numberPickerSeat = findViewById(R.id.number_picker_seats);
        numberPickerSeat.setMinValue(1);
        numberPickerSeat.setMaxValue(6);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater menuInflater = getMenuInflater();
        menuInflater.inflate(R.menu.card_view, menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId()) {
            case R.id.save_note:
                saveCard();
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }

    private void saveCard(){
        String name = editTextName.getText().toString();
        String members = editTextMembers.getText().toString();
        String destination = editTextDestination.getText().toString();
        String time = editTextTime.getText().toString();
        String phoneNo = editTextPhoneNo.getText().toString();
        int seats = numberPickerSeat.getValue();
        if (name.trim().isEmpty() || members.trim().isEmpty() || destination.trim().isEmpty() || time.trim().isEmpty() || phoneNo.trim().isEmpty()) {
            Toast.makeText(this, "Please insert all details", Toast.LENGTH_SHORT).show();
            return;
        }
        CollectionReference notebookRef = FirebaseFirestore.getInstance()
                .collection("SharingCabs");
        notebookRef.add(new Card(name, members,seats,destination,time,phoneNo));
        Toast.makeText(this, "Card added", Toast.LENGTH_SHORT).show();
        finish();
    }
}
