package com.yogi.spinginandroid.module.cardgrid;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.yogi.spinginandroid.DemoFragment;
import com.yogi.spinginandroid.R;

import java.util.ArrayList;

import it.gmariotti.cardslib.library.internal.Card;
import it.gmariotti.cardslib.library.internal.CardGridArrayAdapter;
import it.gmariotti.cardslib.library.internal.CardHeader;
import it.gmariotti.cardslib.library.view.CardGridView;

public class ShoppingFragment extends DemoFragment {

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
       return inflater.inflate(R.layout.fragment_shopping, container, false);
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);


        CardGridArrayAdapter mCardArrayAdapter = new CardGridArrayAdapter(this.getContext(),getItems());

        CardGridView gridView = (CardGridView) getActivity().findViewById(R.id.myGrid);
        if (gridView!=null){
            gridView.setAdapter(mCardArrayAdapter);
        }
    }

    private ArrayList<Card> getItems(){
        ArrayList<Card> cards = new ArrayList<Card>();

        for (int index = 0; index < 3 ; index++) {
            //Create a Card
            Card card = new Card(getContext());
            CardHeader header = new CardHeader(getContext());
            header.setTitle("Hello");
            card.addCardHeader(header);
            cards.add(card);
        }
        return cards;
    }
}
