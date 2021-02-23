package com.rjteste.sorteio

import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.AppCompatEditText
import androidx.appcompat.widget.AppCompatTextView
import com.google.android.gms.ads.AdRequest
import com.google.android.gms.ads.MobileAds
import com.rj.sorteio.R
import kotlinx.android.synthetic.main.activity_main.*
import kotlin.random.Random
import android.view.View as View1
import com.google.android.gms.ads.AdView

@Suppress("DEPRECATION")
class MainActivity : AppCompatActivity(){

    lateinit var mAdView : AdView
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


        MobileAds.initialize(this) {}

        mAdView = findViewById(R.id.adView2)
        val adRequest = AdRequest.Builder().build()
        mAdView.loadAd(adRequest)
 



        button2.setOnClickListener {
    if( appCompatEditText.length()==0){
        appCompatEditText.setError(getString(R.string.limpaSemDados))
        appCompatEditText2.setError(getString(R.string.limpaSemDados))
        appCompatEditText3.setError(getString(R.string.limpaSemDados))
        Toast.makeText(applicationContext, getString(R.string.limpaSemDados), Toast.LENGTH_SHORT).show()
    }
    else {
        this.appCompatEditText.setText("")
        appCompatEditText2.setText("")
        appCompatEditText3.setText("")
        textView4.setText("")
    }


}

}

fun <T> shuffle(list: MutableList<T>) {

    //START FROM END OF THE LIST
    for (i in list.size - 1 downTo 1) {
        //get a random index j such that 0 <= j <= i
        val j = Random.nextInt(i + 1)


        //swap elementa at i'th position in the lista with element
        val temp = list[i]
        list[i] = list[j]
        list[j] = temp
    }

}

fun getSet(view: View1) {

    if (appCompatEditText.length()==0){
        Toast.makeText(applicationContext, getString(R.string.SortSemNumero), Toast.LENGTH_SHORT).show()
    }
    else {

        val num0 = findViewById<AppCompatEditText>(R.id.appCompatEditText)
        val num1 = findViewById<AppCompatEditText>(R.id.appCompatEditText2)
        val num2 = findViewById<AppCompatEditText>(R.id.appCompatEditText3)

        val n0 = num0.text.toString().toInt()
        val n1 = num1.text.toString().toInt()
        val n2 = num2.text.toString().toInt() - 1

        val list: MutableList<Int?> = (n0..n1).toMutableList()
        shuffle(list)

        val list2 = (list.slice(0..n2))


        val result2 = list2.toString()

        findViewById<AppCompatTextView>(R.id.textView4).apply()
        {
            text = result2

        }
    }

}

}



