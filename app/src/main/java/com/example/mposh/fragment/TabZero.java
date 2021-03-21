package com.example.mposh.fragment;

import android.content.DialogInterface;
import android.graphics.Color;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.CalendarView;
import android.widget.SimpleAdapter;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AlertDialog;
import androidx.fragment.app.Fragment;
import androidx.loader.content.AsyncTaskLoader;
import androidx.recyclerview.widget.RecyclerView;

import com.example.mposh.R;
import com.example.mposh.SurfaceView1;
import com.google.android.material.dialog.MaterialAlertDialogBuilder;

import java.util.Calendar;
import java.util.Formatter;
import java.util.Map;

public class TabZero extends Fragment {

    MViewModel viewModel = new MViewModel();

//    SurfaceView1 surfaceView1 = new SurfaceView1(getActivity());

    Button countryChooseButt;
    Button dayChooseButt;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        View rootView = inflater.inflate(R.layout.fragment_country_day, container, false);

        countryChooseButt = rootView.findViewById(R.id.country_choose_button);
        dayChooseButt     = rootView.findViewById(R.id.day_choose_button);

        countryChooseButt.setOnClickListener(countryClickListener);
        dayChooseButt.setOnClickListener    (dayClickListener);

        return rootView;
    }

    View.OnClickListener dayClickListener = new View.OnClickListener() {
        @Override
        public void onClick(View view) {
            LayoutInflater li;
            View promptsView;
            MaterialAlertDialogBuilder mDialogBuilder;
            AlertDialog alertDialog = null;

            //Получаем вид с файла popup_new_project.xml, который применим для диалогового окна:
            li = LayoutInflater.from(getActivity());
            promptsView = li.inflate(R.layout.popup_choose_day, null);

            //Создаем AlertDialog
            mDialogBuilder = new MaterialAlertDialogBuilder(getActivity());

            //Настраиваем popup_new_project.xml для нашего AlertDialog:
            mDialogBuilder.setView(promptsView);

            //Настраиваем сообщение в диалоговом окне:
            mDialogBuilder
                    .setCancelable(false)
                    .setPositiveButton(R.string.ok,
                            new DialogInterface.OnClickListener() {
                                public void onClick(DialogInterface dialog, int id) {
                                    CalendarView calendar = promptsView.findViewById(R.id.calendar);
                                    final String[] date = {""};
                                    calendar.setOnDateChangeListener(new CalendarView.OnDateChangeListener() {
                                        @Override
                                        public void onSelectedDayChange(@NonNull CalendarView calendarView, int year, int month, int dayOfMonth){
                                            date[0] = dayOfMonth + " " + month + " " + year;
                                            Log.d("TAG", "onClick: " + dayOfMonth + " " + month + " " + year);
                                        }
                                    });
                                    calendar.setDate(calendar.getDate());
                                    Log.d("TAG", "onClick: " + date[0]);
//                                    viewModel.setDay(calendar.getDay);

                                }
                            })
                    .setNegativeButton(R.string.cancel,
                            new DialogInterface.OnClickListener() {
                                public void onClick(DialogInterface dialog, int id) {
                                    dialog.cancel();
                                }
                            });

            alertDialog = mDialogBuilder.create();

            alertDialog.show();
        }
    };

    View.OnClickListener countryClickListener = new View.OnClickListener() {
        @Override
        public void onClick(View view) {
            LayoutInflater li;
            View promptsView;
            MaterialAlertDialogBuilder mDialogBuilder;
            AlertDialog alertDialog = null;

            //Получаем вид с файла popup_new_project.xml, который применим для диалогового окна:
            li = LayoutInflater.from(getActivity());
            promptsView = li.inflate(R.layout.popup_choose_country, null);

            //Создаем AlertDialog
            mDialogBuilder = new MaterialAlertDialogBuilder(getActivity());

            RecyclerView recyclerView = promptsView.findViewById(R.id.recyclerview);

//            recyclerView.setAdapter(new SimpleAdapter());

            //Настраиваем popup_new_project.xml для нашего AlertDialog:
            mDialogBuilder.setView(promptsView);

            //Настраиваем сообщение в диалоговом окне:
            mDialogBuilder
                    .setCancelable(false)
                    .setPositiveButton(R.string.ok,
                            new DialogInterface.OnClickListener() {
                                public void onClick(DialogInterface dialog, int id) {


//                                    viewModel.setDay(calendar.getDay);

                                }
                            })
                    .setNegativeButton(R.string.cancel,
                            new DialogInterface.OnClickListener() {
                                public void onClick(DialogInterface dialog, int id) {
                                    dialog.cancel();
                                }
                            });

            alertDialog = mDialogBuilder.create();

            alertDialog.show();
        }
    };

    /*private void chooseTown() {
        String[] items = new String[]{
                "Country 1", "Country 2", "Country 3", "Country 4",
        };

        ArrayAdapter<String> adapter = new ArrayAdapter<String>(getActivity(), android.R.layout.simple_spinner_item, items);
        dropdown.setAdapter(adapter);
        dropdown.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                Log.v("item", (String) parent.getItemAtPosition(position));
                ((TextView) parent.getChildAt(0)).setTextColor(Color.WHITE);
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });
    }*/

}
