package com.example.easyfood.ui

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.fragment.app.DialogFragment
import com.bumptech.glide.Glide
import com.example.easyfood.R
import com.example.easyfood.ui.activites.MealDetailesActivity
import com.example.easyfood.util.Constants.Companion.CATEGORY_NAME
import com.example.easyfood.util.Constants.Companion.MEAL_AREA
import com.example.easyfood.util.Constants.Companion.MEAL_ID
import com.example.easyfood.util.Constants.Companion.MEAL_NAME
import com.example.easyfood.util.Constants.Companion.MEAL_STR
import com.example.easyfood.util.Constants.Companion.MEAL_THUMB

class MealBottomDialog : DialogFragment() {
    private var mealName = ""
    private var mealId = ""
    private var mealImg = ""
    private var mealCountry = ""
    private var mealCategory = ""

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setStyle(STYLE_NORMAL, R.style.AppBottomSheetDialogTheme)
        arguments?.let {
            mealName = it.getString(MEAL_NAME, "")!!
            mealId = it.getString(MEAL_ID, "")!!
            mealImg = it.getString(MEAL_THUMB, "")!!
            mealCategory = it.getString(CATEGORY_NAME, "")!!
            mealCountry = it.getString(MEAL_AREA, "")!!
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.bottom_sheet_dialog, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        prepareView(view)

        view.setOnClickListener {
            val intent = Intent(context, MealDetailesActivity::class.java).apply {
                putExtra(MEAL_ID, mealId)
                putExtra(MEAL_STR, mealName)
                putExtra(MEAL_THUMB, mealImg)
            }
            startActivity(intent)
        }
    }

    private fun prepareView(view: View) {
        val tvMealName = view.findViewById<TextView>(R.id.tv_meal_name_in_btmsheet)
        val tvMealCategory = view.findViewById<TextView>(R.id.tv_meal_category)
        val tvMealCountry = view.findViewById<TextView>(R.id.tv_meal_country)
        val imgMeal = view.findViewById<ImageView>(R.id.img_category)

        Glide.with(view)
            .load(mealImg)
            .into(imgMeal)
        tvMealName.text = mealName
        tvMealCategory.text = mealCategory
        tvMealCountry.text = mealCountry
    }


}