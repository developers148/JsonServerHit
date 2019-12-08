package com.example.jsonserverhit;

import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import com.example.jsonserverhit.Contact;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;
import java.util.List;

public class ContactAdapter extends ArrayAdapter {

    List list= new ArrayList();
    public ContactAdapter(Context context, int resource) {
        super(context, resource);
    }

    public void add(Contact object) {
        super.add(object);
        list.add(object);
    }

    @Override
    public int getCount() {
        return list.size();
    }

    @Override
    public Object getItem(int position) {
        return  list.get(position);
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {


        Log.e("ugjh","uhkjhlk");

        View row;
        row=convertView;
        ContactHolder contactHolder;
        if(row==null){
            LayoutInflater layoutInflater =(LayoutInflater) this.getContext().getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            row=layoutInflater.inflate(R.layout.row_layout,parent,false);
            contactHolder= new ContactHolder();

            contactHolder.tx_id = row.findViewById(R.id.tv_id);
            contactHolder.tx_name= (TextView) row.findViewById(R.id.tv_name);
            contactHolder.tx_types= (TextView) row.findViewById(R.id.tv_types);
            contactHolder.tx_colorofeyes= (TextView) row.findViewById(R.id.tv_colorofeyes);
            contactHolder.im_image= (ImageView) row.findViewById(R.id.profile_image);
            row.setTag(contactHolder);
        }
        else {
            contactHolder= (ContactHolder) row.getTag();

        }

        Contact contacts= (Contact) this.getItem(position);

        contactHolder.tx_name.setText(contacts.getName());
        contactHolder.tx_types.setText(contacts.getTypes());
        contactHolder.tx_colorofeyes.setText(contacts.getColorofeyes());
//        contactHolder.im_image.setText(contacts.getImage());


       Log.e("ghdgh",contacts.getImage());

        Picasso.get().load(contacts.getImage()).into(contactHolder.im_image);
        return row;
    }

    static class ContactHolder{

        TextView tx_id,tx_name,tx_types,tx_colorofeyes;
        ImageView im_image;

    }
}