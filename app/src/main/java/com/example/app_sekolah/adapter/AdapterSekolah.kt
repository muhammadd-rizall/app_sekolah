package com.example.app_sekolah.adapter

import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.cardview.widget.CardView
import androidx.recyclerview.widget.RecyclerView
import com.example.app_sekolah.DetailMapsSekolahActivity
import com.example.app_sekolah.R
import com.example.app_sekolah.model.ModelSekolah

class AdapterSekolah(
    val itemList : List<ModelSekolah>

): RecyclerView.Adapter<AdapterSekolah.MyViewHolder>() {
    class MyViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        //layout pada widget
        val itemGambar : ImageView = itemView.findViewById(R.id.imgSekolah)
        val itemNama : TextView = itemView.findViewById(R.id.txtNamaSekolah)
        val itemLokasi : TextView = itemView.findViewById(R.id.txtLokasi)
        val cardWisata : CardView = itemView.findViewById(R.id.cardSekolah)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        val nView = LayoutInflater.from(parent.context)
            .inflate(R.layout.item_list_sekolah, parent,false)
        return MyViewHolder(nView)
    }

    override fun getItemCount(): Int {
        return itemList.size
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        val currentItem = itemList[position]
        holder.itemGambar.setImageResource(currentItem.gambarSekolah)
        holder.itemNama.setText(currentItem.NamaLokasiSekolah)
        holder.itemLokasi.setText(currentItem.AlamatSekolah)

        //event klik pada card view
        holder.cardWisata.setOnClickListener(){
            val inten = Intent(holder.itemView.context, DetailMapsSekolahActivity::class.java)
            //kirim data list item wisata ke detail wisata activitei
            inten.putExtra("NamaLokasiSekolah",currentItem.NamaLokasiSekolah)
            inten.putExtra("gambarSekolah",currentItem.gambarSekolah)
            inten.putExtra("Deskripsi",currentItem.deskripsiSekolah)
            inten.putExtra("latSekolah",currentItem.latSekolah)
            inten.putExtra("longSekolah",currentItem.longSekolah)

            //menjalankan inten startActivity
            holder.itemView.context.startActivity(inten)
        }
    }

}