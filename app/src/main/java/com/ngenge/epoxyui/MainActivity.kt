package com.ngenge.epoxyui


import android.graphics.Color
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.ngenge.epoxyui.modelviews.userLayoutView
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        epoxyRecyclerview.setItemSpacingDp(4)
        epoxyRecyclerview.buildModelsWith {
            it.apply {
                User.getSampleUsers()
                    .forEachIndexed { index, user ->
                        userLayoutView {
                            id(index)
                            name(user.name)
                            age("${user.age}")
                            email(user.email)
                            itemClickListener {_ ->
                                Toast.makeText(this@MainActivity,
                                    "You clicked on item ${user.name}",
                                    Toast.LENGTH_SHORT)
                                    .show()
                            }
                            if (index.rem(2)==0) background(Color.GREEN)
                        }
                    }
            }
        }
    }
}
