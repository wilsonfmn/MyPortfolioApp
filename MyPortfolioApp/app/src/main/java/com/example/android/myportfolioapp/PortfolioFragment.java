package com.example.android.myportfolioapp;

import android.content.Context;
import android.content.res.Resources;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Adapter;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.Toast;

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
        ArrayList<String> buttonLabelList = new ArrayList<>();
        buttonLabelList.add(getString(R.string.popular_button_label));
        buttonLabelList.add(getString(R.string.stock_button_label));
        buttonLabelList.add(getString(R.string.buildit_button_label));
        buttonLabelList.add(getString(R.string.material_button_label));
        buttonLabelList.add(getString(R.string.ubiquitous_button_label));
        buttonLabelList.add(getString(R.string.capstone_button_label));

        // Consigo pegar diretamente do rootView, tornando a busca menor
        ListView forecastView = rootView.findViewById(R.id.listview_portfolio);

        // Preciso usar um custom adapter para ter controle sobre os eventos do que acontece em cada list item. Se fosse somente um TextView, um ArrayAdapter simples bastaria.
        ButtonListAdapter listAdapter = new ButtonListAdapter(getActivity(), R.layout.list_item_portfolio, buttonLabelList);
        forecastView.setAdapter(listAdapter);
        // Tirando as linhas entre os itens
        forecastView.setDivider(null);

        return rootView;
    }

}
