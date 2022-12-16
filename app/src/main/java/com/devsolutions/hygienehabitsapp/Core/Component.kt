package com.devsolutions.hygienehabitsapp.Core

import android.R
import android.content.ClipData
import android.content.ClipboardManager
import android.content.Context
import android.content.Intent
import android.widget.Toast
import androidx.core.content.ContextCompat

class Component {



    companion object {
        fun showMessage(context: Context, message:String){
            Toast.makeText(context, message, Toast.LENGTH_SHORT).show()
        }

        fun copiarTokenOnClipboard(context:Context, tutorToken: String) {
            val clipboard = ContextCompat.getSystemService(
                context,
                ClipboardManager::class.java
            )
            val clip = ClipData.newPlainText(R.attr.label.toString(), tutorToken)
            clipboard?.setPrimaryClip(clip)
            showMessage(context, "Token: $tutorToken copiado en el portapapeles")

        }

        const val EMPTY_ID=0
        const val RESULT_OK="1"

        const val GET_DATE = 0
        const val GET_TIME = 1

        const val SIZE_DATE_FORMAT = 20


        const val YEAR=0
        const val MONTH=1
        const val DAY=2
    }


}