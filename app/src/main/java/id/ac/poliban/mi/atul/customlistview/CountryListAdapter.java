package id.ac.poliban.mi.atul.customlistview;

import android.graphics.drawable.Drawable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.request.RequestOptions;

import java.util.List;

public class CountryListAdapter extends BaseAdapter {
    private List<Country> countryList;

    public CountryListAdapter(List<Country> countryList) {
        this.countryList = countryList;
    }

    @Override
    public int getCount() {
        return countryList.size();
    }

    @Override
    public Object getItem(int position) {
        return countryList.get(position);
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        convertView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.item_country_list, parent, false);

        //kenalkan view ke object
        ImageView imgFlag = convertView.findViewById(R.id.img_country_flag);
        TextView tvCountryName = convertView.findViewById(R.id.tv_country_name);
        TextView tvCountryDetail = convertView.findViewById(R.id.tv_country_detail);

        //isi object dengan data
        Glide.with(parent.getContext())
                .load(countryList.get(position).getFlag())
                .apply(new RequestOptions().override(90, 55))
                .into(imgFlag);
        tvCountryName.setText(countryList.get(position).getCountryName());
        tvCountryDetail.setText(countryList.get(position).getCountryDetail());

        return convertView;
    }
}
