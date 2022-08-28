package com.marangoz.recycleview

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.*
import androidx.cardview.widget.CardView
import androidx.recyclerview.widget.RecyclerView
import org.w3c.dom.Text

//adapter veri kümesini alır ve tasarım üzerine yerleştime işlemini yapar

class RcAdapter (private val mContext:Context,private val ulkelerDisaridanGelen:List<Ulkeler>,)
    : RecyclerView.Adapter<RcAdapter.CardViewTasarimNesneleriniTutucu>(){
    //adapterımıza CardviewTasarmtutucu nesneni kalıtım yoluyla bağlamış olduk


    //inner clas içinde clas oluşturmak için kullanılır
    // card xml üzerinde ki görsel nesnelere ulaşmış olduk ama card view xml dosyasına ulaşmıyor !!
    inner class CardViewTasarimNesneleriniTutucu(view : View) : RecyclerView.ViewHolder(view) {
        var satirCardView : CardView
        var satirYazi : TextView
        var noktaView : ImageView

        init {
            satirCardView = view.findViewById(R.id.cardView)
            satirYazi = view.findViewById(R.id.satirYazi)
            noktaView = view.findViewById(R.id.noktaResim)
        }


    }
    // CarViewtutucu içinde view nesnesi oluşturduk ama nesnemizin hangi xml tasarımı olduğunu
    //belirmediğimiz için burada CardViewtutucuya tasarımı gönderiyoruz
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CardViewTasarimNesneleriniTutucu {
        //mContext dışarıdan aldığımız(rcAdapter) parametre ile activityden bir parça istiyor
        //cardview bulunduğu yeri belirtiyoruz
        //paret ise tasarımın yazılımsal şeklidir
        val tasarim = LayoutInflater.from(mContext).inflate(R.layout.card_view,parent,false)

        return CardViewTasarimNesneleriniTutucu(tasarim)
    }

    override fun getItemCount(): Int { // bize recyclerview içinde kaç tane eleman gözükecek onu soruyor
        return ulkelerDisaridanGelen.size + 35
    }

    //veri kümemizi hangi görsel nesnelere aktaracağımıza karar verdiğimiz yerdir
    //mesela ulke adını textview kaydedicez
    //döngü gibi çalışabilir position ile holder ile görsel nesnelere ulaşırız
    override fun onBindViewHolder(holder: CardViewTasarimNesneleriniTutucu, position: Int) {
        var ulke : Ulkeler = Ulkeler(0,"a")
        if (ulkelerDisaridanGelen.size > position){
            ulke = ulkelerDisaridanGelen[position]
        }

        holder.satirYazi.text = ulke.ulkeAd

        holder.satirCardView.setOnClickListener(){
            Toast.makeText(mContext,"${ulke.ulkeAd}",Toast.LENGTH_SHORT).show()
        }

        holder.noktaView.setOnClickListener() {
            val popup = PopupMenu(mContext, holder.noktaView)
            popup.menuInflater.inflate(R.menu.rv_pop_up, popup.menu)
            popup.show()

            popup.setOnMenuItemClickListener { item ->
                when (item.itemId) {
                    R.id.action_sil -> {

                        Toast.makeText(mContext,ulke.ulkeAd,Toast.LENGTH_SHORT).show()
                        true
                    }
                    R.id.action_duzenle ->{
                        Toast.makeText(mContext,ulke.ulkeNo.toString(),Toast.LENGTH_SHORT).show()
                        true
                    }
                    else ->false



                }
            }
        }
    }



}