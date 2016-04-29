package com.yogi.spinginandroid;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

/**
 * Created by ril on 4/29/16.
 */
public class ModuleListFragment extends DemoFragment {

    private String[] data;
    private ModuleAdapter adapter;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_module_list,null);
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        RecyclerView mRecyclerView = (RecyclerView) view.findViewById(R.id.list);
        mRecyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));

        adapter = new ModuleAdapter();
        mRecyclerView.setAdapter(adapter);
    }

    public void setData(String[] data) {
        this.data = data;
    }


    private class ModuleAdapter extends RecyclerView.Adapter<ModuleHolder>{

        @Override
        public ModuleHolder onCreateViewHolder(ViewGroup parent, int viewType) {
            View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.list_item_module, parent, false);
            return new ModuleHolder(view);
        }

        @Override
        public void onBindViewHolder(ModuleHolder holder, final int position) {
            holder.itemName.setText(data[position]);
            holder.itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    if(getActivity() instanceof MainActivity){
                        ((MainActivity)getActivity()).itemClick(position);
                    }
                }
            });
        }

        @Override
        public int getItemCount() {
            if (data == null)
                return 0;
            return data.length;
        }
    }

    private class ModuleHolder extends RecyclerView.ViewHolder{

        private TextView itemName;
        public ModuleHolder(View itemView) {
            super(itemView);
            itemName = (TextView) itemView.findViewById(R.id.item_name);
        }
    }
}
