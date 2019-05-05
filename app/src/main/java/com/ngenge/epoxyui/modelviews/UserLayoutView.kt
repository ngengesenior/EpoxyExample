package com.ngenge.epoxyui.modelviews

import android.content.Context
import android.util.AttributeSet
import android.view.View
import android.widget.TextView
import androidx.constraintlayout.widget.ConstraintLayout
import com.airbnb.epoxy.CallbackProp
import com.airbnb.epoxy.ModelProp
import com.airbnb.epoxy.ModelView
import com.airbnb.epoxy.TextProp
import com.ngenge.epoxyui.R

@ModelView(autoLayout = ModelView.Size.MATCH_WIDTH_WRAP_HEIGHT)
class UserLayoutView @JvmOverloads constructor(
    context: Context,
    attributeSet: AttributeSet?= null,
    defStyle:Int = 0

): ConstraintLayout(context,attributeSet,defStyle) {
    private val rootLayout:ConstraintLayout
    private val nameTextView:TextView
    private val emailTextView:TextView
    private val ageTextView:TextView

    init {
        View.inflate(context,R.layout.item_layout,this)
        rootLayout = findViewById(R.id.itemLayout)
        nameTextView = findViewById(R.id.nameTextView)
        emailTextView = findViewById(R.id.emailTextView)
        ageTextView = findViewById(R.id.ageTextView)
    }


    @TextProp
    fun setName(name:CharSequence) {
        nameTextView.text = name
    }

    @TextProp
    fun setEmail(email:CharSequence) {
        emailTextView.text = email
    }

    @TextProp
    fun setAge(age:CharSequence) {
        ageTextView.text = age
    }

    @CallbackProp
    fun setItemClickListener(listener: OnClickListener?) {
        rootLayout.setOnClickListener(listener)
    }

    @ModelProp
    fun setBackground(backGround:Int) {
        rootLayout.setBackgroundColor(backGround)
    }




}