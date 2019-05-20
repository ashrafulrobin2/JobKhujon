package com.example.jobkhujon.fragment;


import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.widget.DrawerLayout;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.BaseExpandableListAdapter;
import android.widget.ListView;
import android.widget.TextView;

import com.example.jobkhujon.R;
import com.example.jobkhujon.model.Category;
import com.example.jobkhujon.model.Data;
import com.example.jobkhujon.web_api.Retrofit;
import com.example.jobkhujon.web_api.client;

import java.util.ArrayList;
import java.util.List;

import es.dmoral.toasty.Toasty;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

import static android.content.Context.MODE_PRIVATE;

/**
 * A simple {@link Fragment} subclass.
 */
public class Dashboard extends Fragment {
    ListView listView;
    client iClientServer;
    public static final String mypreference = "mypref";
    SharedPreferences sharedPreferences;


    public Dashboard() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view=inflater.inflate(R.layout.fragment_dashboard, container, false);
        listView = view.findViewById(R.id.category_list);
        SharedPreferences sharedPreferences = getContext().getSharedPreferences(mypreference, MODE_PRIVATE);
        String cat1 = sharedPreferences.getString( "categoryName1", "" );
        String cat2 = sharedPreferences.getString( "categoryName2", "" );
        String cat3 = sharedPreferences.getString( "categoryName3", "" );
        String cat4 = sharedPreferences.getString( "categoryName4", "" );
        String cat5 = sharedPreferences.getString( "categoryName5", "" );
        String cat6 = sharedPreferences.getString( "categoryName6", "" );
        String cat7 = sharedPreferences.getString( "categoryName7", "" );
        String cat8 = sharedPreferences.getString( "categoryName8", "" );
        String cat9 = sharedPreferences.getString( "categoryName9", "" );
        String cat10 = sharedPreferences.getString( "categoryName10", "" );
        String cat11 = sharedPreferences.getString( "categoryName11", "" );


        ArrayList<String>category=new ArrayList<>();
        category.add(cat1);
        category.add(cat2);
        category.add(cat3);
        category.add(cat4);
        category.add(cat5);
        category.add(cat6);
        category.add(cat7);
        category.add(cat8);
        category.add(cat9);
        category.add(cat10);
        category.add(cat11);
        //String[] category={"apple","orage"};
        ArrayAdapter<String> adapter = new ArrayAdapter(getContext(), android.R.layout.simple_list_item_1, category);
        listView.setAdapter(adapter);
        iClientServer = Retrofit.getRetrofitInstance().create(client.class);
        getCategoryData();
        return view;
    }

    public void getCategoryData() {


        Call<Category> categoryCall = iClientServer.getSubmenu();
        categoryCall.enqueue(new Callback<Category>() {
            @Override
            public void onResponse(Call<Category> call, Response<Category> response) {
                Category category = response.body();

                getApiResponse(category.getData());

            }

            @Override
            public void onFailure(Call<Category> call, Throwable t) {
                Toasty.error(getContext(), "Error" + t.getMessage(), Toasty.LENGTH_LONG).show();
            }
        });

    }
    private void getApiResponse(List<Data> data) {


        String categoryName1 = null;
        String categoryName2 = null;
        String categoryName3 = null;
        String categoryName4 = null;
        String categoryName5 = null;
        String categoryName6 = null;
        String categoryName7 = null;
        String categoryName8 = null;
        String categoryName9 = null;
        String categoryName10 = null;
        String categoryName11 = null;


        int size = data.get(0).getSubmenu().size();
        int size1 = data.get(1).getSubmenu().size();
        int size2 = data.get(2).getSubmenu().size();
        int size3 = data.get(3).getSubmenu().size();
        int size4 = data.get(4).getSubmenu().size();
        /* int size5=category.getData().get(5).getSubmenu().size();*/
        int size6 = data.get(6).getSubmenu().size();
        int size7 = data.get(7).getSubmenu().size();
        int size8 = data.get(8).getSubmenu().size();
        int size9 = data.get(9).getSubmenu().size();
        int size10 = data.get(10).getSubmenu().size();
        int size11 = data.get(11).getSubmenu().size();

        for (int i = 0; i < size; i++) {
            categoryName1 = data.get(0).getSubmenu().get(i).getCategoriesName();
            // Toasty.success(getContext(), "data[0]" + categoryName1, Toasty.LENGTH_LONG).show();
        }

        for (int i = 0; i < size1; i++) {
            categoryName2 = data.get(1).getSubmenu().get(i).getCategoriesName();
            //Toasty.success(getContext(), "data[1]" + categoryName2, Toasty.LENGTH_LONG).show();
        }

        for (int i = 0; i < size2; i++) {
            categoryName3 = data.get(2).getSubmenu().get(i).getCategoriesName();
            //Toasty.success(getContext(), "data[2]" + categoryName3, Toasty.LENGTH_LONG).show();
        }

        for (int i = 0; i < size3; i++) {

            categoryName4 = data.get(3).getSubmenu().get(i).getCategoriesName();
            //Toasty.success(getContext(), "data[3]" + categoryName4, Toasty.LENGTH_LONG).show();
        }


        for (int i = 0; i < size4; i++) {

            categoryName5 = data.get(4).getSubmenu().get(i).getCategoriesName();
            // Toasty.success(getContext(), "data[4]" + categoryName5, Toasty.LENGTH_LONG).show();
        }

              /*  for(int i=0;i<size5;i++){

                    String getProductName=category.getData().get(5).getSubmenu().get(i).getCategoriesName();
                    Toasty.success(getContext(),"data[5]"+getProductName,Toasty.LENGTH_LONG).show();

                }*/

        for (int i = 0; i < size6; i++) {

            categoryName6 = data.get(6).getSubmenu().get(i).getCategoriesName();
            //Toasty.success(getContext(), "data[6]" +  categoryName6, Toasty.LENGTH_LONG).show();
        }

        for (int i = 0; i < size7; i++) {

            categoryName7 = data.get(7).getSubmenu().get(i).getCategoriesName();
            //Toasty.success(getContext(), "data[7]" + categoryName7, Toasty.LENGTH_LONG).show();
        }

        for (int i = 0; i < size8; i++) {

            categoryName8 = data.get(8).getSubmenu().get(i).getCategoriesName();
            //Toasty.success(getContext(), "data[8]" + categoryName8, Toasty.LENGTH_LONG).show();
        }

        for (int i = 0; i < size9; i++) {

            categoryName9 = data.get(9).getSubmenu().get(i).getCategoriesName();
            // Toasty.success(getContext(), "data[9]" + categoryName9, Toasty.LENGTH_LONG).show();
        }

        for (int i = 0; i < size10; i++) {

            categoryName10 = data.get(10).getSubmenu().get(i).getCategoriesName();
            // Toasty.success(getContext(), "data[10]" + categoryName10, Toasty.LENGTH_LONG).show();
        }

        for (int i = 0; i < size11; i++) {

            categoryName11 = data.get(11).getSubmenu().get(i).getCategoriesName();
            //Toasty.success(getContext(), "data[11]" + categoryName11, Toasty.LENGTH_LONG).show();
        }

        sharedPreferences = getContext().getSharedPreferences(mypreference, MODE_PRIVATE);
        SharedPreferences.Editor editor = sharedPreferences.edit();
        editor.putString("categoryName1", categoryName1);
        editor.putString("categoryName2", categoryName2);
        editor.putString("categoryName3", categoryName3);
        editor.putString("categoryName4", categoryName4);
        editor.putString("categoryName5", categoryName5);
        editor.putString("categoryName6", categoryName6);
        editor.putString("categoryName7", categoryName7);
        editor.putString("categoryName8", categoryName8);
        editor.putString("categoryName9", categoryName9);
        editor.putString("categoryName10", categoryName10);
        editor.putString("categoryName11", categoryName11);
        editor.apply();
        editor.commit();



       /* ArrayList<String> category = new ArrayList<>();

        category.add(categoryName1);
        category.add(categoryName2);
        category.add(categoryName3);
        category.add(categoryName4);
        category.add(categoryName5);
        category.add(categoryName6);
        Toasty.success(getContext(), "data[success] " + category, Toasty.LENGTH_LONG).show();*/
    }
}
