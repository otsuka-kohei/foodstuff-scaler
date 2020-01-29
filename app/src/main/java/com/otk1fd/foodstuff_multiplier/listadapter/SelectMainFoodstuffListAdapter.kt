package com.otk1fd.foodstuff_multiplier.listadapter

import android.app.Activity
import android.util.Log
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import android.widget.TextView
import com.otk1fd.foodstuff_multiplier.Foodstuff
import com.otk1fd.foodstuff_multiplier.R

class SelectMainFoodstuffListAdapter(
    val activity: Activity,
    val foodstuffList: List<Foodstuff>,
    val onClickMainFoddstuff: (index: Int) -> Unit
) :
    BaseAdapter() {

    override fun getView(position: Int, convertView: View?, parent: ViewGroup?): View {
        val view =
            convertView ?: activity.layoutInflater.inflate(R.layout.item_main_foodstuff_list, null)
        if (view == null) {
            Log.d("ListView", "View is null")
        }

        if (position % 2 == 0) {
            view.setBackgroundResource(R.color.listItem)
        }

        val candidateFoodstuffTextView: TextView =
            view.findViewById(R.id.candidateFoodstuffTextView)
        candidateFoodstuffTextView.text = foodstuffList[position].name
        candidateFoodstuffTextView.setOnClickListener {
            onClickMainFoddstuff(position)
        }

        return view
    }

    override fun getItem(p0: Int): Any {
        return foodstuffList[p0]
    }

    override fun getItemId(p0: Int): Long {
        return p0.toLong()
    }

    override fun getCount(): Int {
        return foodstuffList.size
    }
}