package com.deltabit.bakingapp;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.deltabit.bakingapp.model.Ingredient;

import java.util.ArrayList;
import java.util.List;


public class IngredientRecyclerViewAdapter extends RecyclerView.Adapter<IngredientRecyclerViewAdapter.ViewHolder> {

    private final List<Ingredient> ingredients = new ArrayList<>();

    public IngredientRecyclerViewAdapter(List<Ingredient> items) {
        ingredients.add(new Ingredient("Amount","Ingredient Name"));
        ingredients.addAll(items);
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.fragment_ingredient, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(final ViewHolder holder, int position) {
        holder.ingredient = ingredients.get(position);
        String quantityMeasure = holder.ingredient.getQuantity() + holder.ingredient.getMeasure() ;
        holder.textViewIngredientId.setText(quantityMeasure);
        holder.textIngredientDescription.setText(holder.ingredient.getIngredient());

    }

    @Override
    public int getItemCount() {
        return ingredients.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        public final View viewHolder;
        public final TextView textViewIngredientId;
        public final TextView textIngredientDescription;
        public Ingredient ingredient;

        public ViewHolder(View view) {
            super(view);
            viewHolder = view;
            textViewIngredientId = (TextView) view.findViewById(R.id.textviewIngredientId);
            textIngredientDescription = (TextView) view.findViewById(R.id.textviewIngredientContent);
        }

        @Override
        public String toString() {
            return super.toString() + " '" + textIngredientDescription.getText() + "'";
        }
    }
}
