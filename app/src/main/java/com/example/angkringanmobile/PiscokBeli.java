package com.example.angkringanmobile;

import androidx.appcompat.app.AppCompatActivity;

import android.app.LoaderManager;
import android.content.ContentValues;
import android.content.CursorLoader;
import android.content.Intent;
import android.content.Loader;
import android.database.Cursor;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.angkringanmobile.Database.OrderContract;

public class PiscokBeli extends AppCompatActivity implements LoaderManager.LoaderCallbacks<Cursor> {

    //CEKOUT, PLUS MINUS HARGA
    ImageView imageView;
    ImageButton plusquantity, minusquantity;
    TextView quantitynumber, namaSateTelur, rupiahSateTelur;
    Button addtoCart;
    int quantity;
    public Uri mCurrentCartUri;
    boolean hasAllRequiredValues = false;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.infopiscok);

        imageView = findViewById(R.id.imageViewInfo);
        plusquantity = findViewById(R.id.addquantity);
        minusquantity = findViewById(R.id.subquantity);
        quantitynumber = findViewById(R.id.quantity);
        namaSateTelur = findViewById(R.id.NasiKucingnama);
        rupiahSateTelur = findViewById(R.id.NasiKucingHarga);
        addtoCart = findViewById(R.id.addtocart);


        namaSateTelur.setText("Piscok");
        imageView.setImageResource(R.drawable.cartpiscok);

        addtoCart.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(PiscokBeli.this, SummaryActivity.class);
                startActivity(intent);

                SaveCart();
            }
        });



        plusquantity.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //harga pas di cekout
                int basePrice = 1500;
                quantity++;
                displayQuantity();
                int coffePrice = basePrice * quantity;
                String setnewPrice = String.valueOf(coffePrice);
                rupiahSateTelur.setText(setnewPrice);

            }
        });

        minusquantity.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //harga pas di cekout
                int basePrice = 1500;
                if (quantity == 0){
                    Toast.makeText(PiscokBeli.this, "Harus pesan minimal 1", Toast.LENGTH_SHORT).show();
                }else{
                    quantity--;
                    displayQuantity();
                    int coffePrice = basePrice * quantity;
                    String setnewPrice = String.valueOf(coffePrice);
                    rupiahSateTelur.setText(setnewPrice);
                }
            }

        });

    }
    //Menyimpan di database

    private boolean SaveCart() {
        String name = namaSateTelur.getText().toString();
        String price = rupiahSateTelur.getText().toString();
        String quantity = quantitynumber.getText().toString();

        ContentValues values = new ContentValues();
        values.put(OrderContract.OrderEntry.COLUMN_NAME, name);
        values.put(OrderContract.OrderEntry.COLUMN_PRICE, price);
        values.put(OrderContract.OrderEntry.COLUMN_QUANTITY, quantity);

        if (mCurrentCartUri == null){
            Uri newUri = getContentResolver().insert(OrderContract.OrderEntry.CONTENT_URI, values);
            if (newUri == null){
                Toast.makeText(this,"Gagal Menambahkan ke Keranjang", Toast.LENGTH_SHORT).show();
            }else {
                Toast.makeText(this, "Berhasil Ditambahkan ke Keranjang !", Toast.LENGTH_SHORT).show();
            }
        }
        hasAllRequiredValues = true;
        return hasAllRequiredValues;

    }

    private void displayQuantity(){
        quantitynumber.setText(String.valueOf(quantity));
    }

    @Override
    public Loader<Cursor> onCreateLoader(int id, Bundle args) {
        String[] projection = {OrderContract.OrderEntry._ID,
                OrderContract.OrderEntry.COLUMN_NAME,
                OrderContract.OrderEntry.COLUMN_PRICE,
                OrderContract.OrderEntry.COLUMN_QUANTITY};

        return new CursorLoader(this, mCurrentCartUri, projection, null,null,null);
    }

    @Override
    public void onLoadFinished(Loader<Cursor> loader, Cursor cursor) {

        if (cursor == null || cursor.getCount() < 1){
            return;
        }

        if (cursor.moveToFirst()){
            int name = cursor.getColumnIndex(OrderContract.OrderEntry.COLUMN_NAME);
            int price = cursor.getColumnIndex(OrderContract.OrderEntry.COLUMN_PRICE);
            int quantity = cursor.getColumnIndex(OrderContract.OrderEntry.COLUMN_QUANTITY);

            String nameofdrink = cursor.getString(name);
            String priceofdrink = cursor.getString(price);
            String quantityofdrink = cursor.getString(quantity);

            namaSateTelur.setText(nameofdrink);
            rupiahSateTelur.setText(priceofdrink);
            quantitynumber.setText(quantityofdrink);
        }

    }

    @Override
    public void onLoaderReset(Loader<Cursor> loader) {

        namaSateTelur.setText("");
        rupiahSateTelur.setText("");
        quantitynumber.setText("");

    }
}