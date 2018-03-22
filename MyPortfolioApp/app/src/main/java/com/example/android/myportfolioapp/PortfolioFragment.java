package com.example.android.myportfolioapp;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ListAdapter;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.List;

/**
 * Fragmento responsável por criar a lista de botões do aplicativo de portfolio
 * Created by willf on 22/03/2018.
 */

public class PortfolioFragment extends Fragment {

    public PortfolioFragment() {
        // vazio por enquanto
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstances) {

        // Com inflate eu consigo montar a hierarquia de layout
        View rootView = inflater.inflate(R.layout.porfolio_fragment, container, false);

        // criando a lista de labels dos botões
        List<String> fakeData = new ArrayList<>();
        fakeData.add(getString(R.string.popular_button_label));
        fakeData.add(getString(R.string.stock_button_label));
        fakeData.add(getString(R.string.buildit_button_label));
        fakeData.add(getString(R.string.material_button_label));
        fakeData.add(getString(R.string.ubiquitous_button_label));
        fakeData.add(getString(R.string.capstone_button_label));

        // Criando a lista de item
        ListAdapter listAdapter = new ArrayAdapter<String>(getActivity(), R.layout.list_item_portfolio, R.id.list_item_portfolio_button, fakeData);
        // Consigo pegar diretamente do rootView, tornando a busca menor
        ListView forecastView = rootView.findViewById(R.id.listview_portfolio);
        forecastView.setAdapter(listAdapter);

        return rootView;
    }

}
