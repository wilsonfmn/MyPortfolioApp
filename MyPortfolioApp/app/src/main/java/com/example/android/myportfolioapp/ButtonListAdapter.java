package com.example.android.myportfolioapp;

import android.app.Activity;
import android.content.Context;
import android.content.res.Resources;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Toast;

import java.util.List;

/**
 * Adapter customizado para gerenciar os eventos de click nos botões
 * Created by willf on 23/03/2018.
 */

public class ButtonListAdapter extends ArrayAdapter<String> {

    private List<String> buttonLabelList;
    private Activity activity;

    public ButtonListAdapter (Context context, int buttonViewResourceId, List<String> labelList) {
        super(context, buttonViewResourceId, labelList);
        this.buttonLabelList = labelList;
        this.activity = (Activity) context;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        LayoutInflater inflater = this.activity.getLayoutInflater();

        View view = inflater.inflate(R.layout.list_item_portfolio, null);

        Button button = (Button) view.findViewById(R.id.list_item_portfolio_button);
        button.setText(buttonLabelList.get(position));

        // inicializando meu listener para capturar eventos de click
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Context parentContext = v.getContext();
                Resources contextResources = parentContext.getResources();
                String buttonLabel = ((Button) v).getText().toString();

                if (buttonLabel.equals(contextResources.getString(R.string.popular_button_label))) {
                    pressToToast(parentContext, contextResources.getString(R.string.popular_toast));
                } else if (buttonLabel.equals(contextResources.getString(R.string.stock_button_label))) {
                    pressToToast(parentContext, contextResources.getString(R.string.stock_toast));
                } else if (buttonLabel.equals(contextResources.getString(R.string.buildit_button_label))) {
                    pressToToast(parentContext, contextResources.getString(R.string.buildit_toast));
                } else if (buttonLabel.equals(contextResources.getString(R.string.material_button_label))) {
                    pressToToast(parentContext, contextResources.getString(R.string.material_toast));
                } else if (buttonLabel.equals(contextResources.getString(R.string.ubiquitous_button_label))) {
                    pressToToast(parentContext, contextResources.getString(R.string.ubiquitous_toast));
                } else if (buttonLabel.equals(contextResources.getString(R.string.capstone_button_label))) {
                    pressToToast(parentContext, contextResources.getString(R.string.capstone_toast));
                } else {
                    pressToToast(parentContext, contextResources.getString(R.string.where_is_my_button_toast));
                }
            }
        });

        return view;
    }

    private void pressToToast(Context parentContext, String message) {
        Toast simpleToast = Toast.makeText(parentContext, message, Toast.LENGTH_SHORT);
        simpleToast.show();
    }

}
