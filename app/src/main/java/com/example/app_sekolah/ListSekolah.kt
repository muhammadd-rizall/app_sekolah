package com.example.app_sekolah

import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.app_sekolah.adapter.AdapterSekolah
import com.example.app_sekolah.model.ModelSekolah

class ListSekolah : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_list_sekolah)

        val listSekolah = listOf(
                ModelSekolah("SMAN 1 Batipuh",
                                "Tanah Datar,Kec.Batipuh",
                                R.drawable.sekolah1,
                                        "(0752)7491167",
                            "SMA negeri ini berdiri sejak 1984. Sekarang SMA Negeri 1 Batipuh memakai panduan kurikulum belajar SMA 2013 IPS. SMAN 1 Batipuh dikepalai oleh seorang kepala sekolah bernama Hendra Arinal dibantu oleh operator bernama Zulfa Indra.",
                            -0.48543521562580416, 100.46549421307562
                    ),

                ModelSekolah("MTI Tanjung Barulak","Tanah Datar,kec.Batipuh",R.drawable.sekolah2,"-",
                    "MA swasta ini mengawali perjalanannya pada tahun 1991. Pada waktu ini MAS Ti Tanjung Barulak masih menggunakan program kurikulum belajar . MAS Ti Tanjung Barulak ditangani oleh seorang operator yang bernama Gusti Ilham.",
                    -0.5187949167363219, 100.49581396638568),
                ModelSekolah("SMKN 1 Batipuh","Tanah Datar,Kec.Batipuh",R.drawable.sekolah3,"(0752)7490076",
                    "SMK negeri ini berdiri sejak 1998. Sekarang SMK Negeri 1 Batipuh memakai panduan kurikulum belajar pemerintah yaitu SMK 2013 REV. Desain Pemodelan dan Informasi Bangunan. SMKN 1 Batipuh berada di bawah naungan kepala sekolah dengan nama Syafren ditangani oleh seorang operator yang bernama Hendra Mustika",
                    -0.47773145871559386, 100.45917023755048),
                ModelSekolah("MAN 2 Tanah Datar","Tanah Datar,Kec.Lima Kaum",R.drawable.sekolah4,"081268823584",
                    "MAN 2 Tanah Datar, merupakan bunga setangkainya bagi Kabupaten Tanah Datar yang sering disebut dengan “ LUHAK NAN TUO”, karena Kabupaten Tanah Datar merupakan pusat kebudayaan Alam Minang Kabau tempo dulu. Kehidupan masyarakatnya yang berbenteng adat dan agama yang sering diungkapkan dalam pepetah  Minang “ ADAT BASANDI SYARAK SAYARAK BASANDI KITABULLAH”. Corak kehidupan masyarakat yang demikian disebabkan oleh pengaruh ulama besar Minang Kabau dulu yang telah berjuang membina masyarakat melalui surau-surau (pesantren=sebutan jawa) dan Madrasah-Madrasah yang mereka dirikan.",
                    -0.46309447284745847, 100.5656396952204),
                ModelSekolah("SMAN 1 Padang Panjang","Padang Panjang",R.drawable.sekolah5,"(0752)83208",
                    "sekolah ini awal dibangun sebagai sekolah guru oleh pemerintah kolonial hindia belanda di tahun 1918",
                    -0.4633180304312669, 100.4060542933752),
                ModelSekolah("SMAN 2 Padang Panjang","Padang Panjang",R.drawable.sekolah6,"(0752)484752",
                    "SMA Negeri 2 Padang Panjang merupakan SMA negeri kedua di kota Padang Panjang. Didirikan didasarkan atas permintaan dan kebutuhan masyarakat serta minat yang tinggi siswa tamatan SLTP untuk melanjutkan pendidikan ke jenjang sekolah menengah atas pada tahun 1996.",
                    -0.4611418727845387, 100.4030043240555),
                ModelSekolah("SMAN 3 Padang Panjang","Padang Panjang",R.drawable.sekolah7,"(0752)484137",
                    "SMA negeri ini mengawali perjalanannya pada tahun 2005. Pada saat ini SMA Negeri 3 Padang Panjang mengimplementasikan panduan kurikulum belajar SMA 2013 MIPA. SMAN 3 Padang Panjang dibawah kepemimpinan seorang kepala sekolah yang bernama Febriace dibantu oleh operator bernama Ardian Fb.",
                    -0.4644290728906324, 100.37911263939564),
                ModelSekolah("SMAN 1 SUMBAR","Padang Panjang",R.drawable.sekolah8,"(0752)485544",
                    "SMA negeri ini memulai kegiatan pendidikan belajar mengajarnya pada tahun 2011. Saat sekarang SMA Negeri 1 Sumatera Barat menggunakan kurikulum belajar SMA 2013 MIPA. SMAN 1 Sumatera Barat dipimpin oleh seorang kepala sekolah yang bernama Surya Netti ditangani oleh seorang operator yang bernama Afnida.",
                    -0.46188232978220717, 100.42717445289054),
                ModelSekolah("SMAN 1 Rambatan","Tanah Datar,Kec.Rambatan",R.drawable.sekolah9,"(0752)7575273",
                    "SMA negeri ini memulai kegiatan pendidikan belajar mengajarnya pada tahun 1985. Saat sekarang SMA Negeri 1 Rambatan mengimplementasikan panduan kurikulum belajar SMA 2013 IPS. SMAN 1 Rambatan dipimpin oleh seorang kepala sekolah yang bernama Ahda dan operator sekolah Nofia Roza.",
                    -0.5074481743505951, 100.5634054952207),
                ModelSekolah("MAN 1 Padang Panjang","Padang Panjang",R.drawable.sekolah10,"(0752)82921",
                    "MA negeri ini pertama kali berdiri pada tahun 1968. Saat ini MAN 1 Kota Padang Panjang mengimplementasikan panduan kurikulum belajar . MAN 1 Kota Padang Panjang dikelolah oleh seorang operator bernama Syifa Kartiwa.",
                    -0.45598567261970807, 100.42104346823065)


        )

        val adapterSekolah = AdapterSekolah(listSekolah)

        val rvWisata : RecyclerView = findViewById(R.id.rv_list)
        rvWisata.adapter = adapterSekolah

        rvWisata.apply {
            layoutManager = LinearLayoutManager(this@ListSekolah)
        }

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
    }
}