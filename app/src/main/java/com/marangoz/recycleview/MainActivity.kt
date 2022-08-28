package com.marangoz.recycleview

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.StaggeredGridLayoutManager

class MainActivity : AppCompatActivity() {
    private lateinit var ulkelerList: ArrayList<Ulkeler>
    private lateinit var adapter: RcAdapter
    private lateinit var rv : RecyclerView
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        rv = findViewById(R.id.rv)

        rv.setHasFixedSize(true) // tasarımın üstüne tam oturmasını sağlar
        rv.layoutManager = LinearLayoutManager(this) // görüntünün nasıl olacağına karar veri
        //linear layout alt alta görüntülenir

        val ulke1 = Ulkeler(5,"türkiye")
        val ulke2 = Ulkeler(10,"almanya")
        val ulke3 = Ulkeler(15,"fransa")

        ulkelerList = ArrayList<Ulkeler>()
        ulkelerList.add(ulke1)
        ulkelerList.add(ulke2)
        ulkelerList.add(ulke3)

        adapter = RcAdapter(this,ulkelerList) //Rcadaptera parametreleri gönderdik

        rv.adapter = adapter //rvadaper ile Rcadapter sınıfından nesneyi birbirine bağladık


    }
}