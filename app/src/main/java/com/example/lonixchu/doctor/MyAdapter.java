package com.example.lonixchu.doctor;

import android.content.Context;
import android.support.annotation.NonNull;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

public class MyAdapter extends ArrayAdapter<String> {

    String[] names;
    String[] subjects;
    String[] addresses;
    String[] phones;
    int[] flags;
    Context mContext;

    public MyAdapter(Context context, String[] Name, String[] Subject, String[] Address, String[] Phone, int[] countryFlags) {
        super(context, R.layout.list_item);
        this.names = Name;
        this.subjects = Subject;
        this.addresses = Address;
        this.phones = Phone;
        this.mContext = context;
        this.flags = countryFlags;
    }

    static class ViewHolder {
        ImageView mFlag;
        TextView mName;
        TextView mSubject;
        TextView mAddress;
        TextView mPhone;
    }

    @Override
    public int getCount() {
        return names.length;
    }

    @NonNull
    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ViewHolder mViewHolder = new ViewHolder();
        if (convertView == null) {
            LayoutInflater mInflater = (LayoutInflater) mContext.
                    getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            convertView = mInflater.inflate(R.layout.list_item, parent, false);
            mViewHolder.mFlag = (ImageView) convertView.findViewById(R.id.imageView);
            mViewHolder.mName = (TextView) convertView.findViewById(R.id.doctorname);
            mViewHolder.mSubject = (TextView) convertView.findViewById(R.id.subject);
            mViewHolder.mAddress = (TextView) convertView.findViewById(R.id.address);
            mViewHolder.mPhone = (TextView) convertView.findViewById(R.id.phone);
            convertView.setTag(mViewHolder);
        } else {
            mViewHolder = (ViewHolder) convertView.getTag();
        }
        mViewHolder.mFlag.setImageResource(flags[0]);
        mViewHolder.mName.setText(names[position]);
        mViewHolder.mSubject.setText(subjects[position]);
        mViewHolder.mAddress.setText(addresses[position]);
        mViewHolder.mPhone.setText(phones[position]);

        return convertView;
    }


}