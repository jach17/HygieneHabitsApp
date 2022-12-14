package com.devsolutions.hygienehabitsapp.Core

import android.content.Context
import android.content.Intent
import android.widget.Toast

class Component {



    companion object {
        fun showMessage(context: Context, message:String){
            Toast.makeText(context, message, Toast.LENGTH_SHORT).show()
        }

        const val EMPTY_ID=0
        const val RESULT_OK="1"

        const val GET_DATE = 0
        const val GET_TIME = 1


        const val YEAR=0
        const val MONTH=1
        const val DAY=2
    }


}