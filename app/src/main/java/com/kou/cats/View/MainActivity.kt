package com.kou.cats.View

import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.bumptech.glide.Glide
import com.kou.cats.Model.Cats
import com.kou.cats.Network.CatsApi
import com.kou.cats.R
import kotlinx.android.synthetic.main.activity_main.*
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import java.io.IOException

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val api=CatsApi.create()





        api.getAcat("ba108335-3055-482c-bded-c9d9a4dacec4","med").enqueue(object:
            Callback<Cats> {
            override fun onResponse(call: Call<Cats>, response: Response<Cats>) {
                if (response.isSuccessful)
                {
                    val cats  = response.body()
                    Glide.with(this@MainActivity).load(cats!![0].url).into(imCat)

                }
            }

            override fun onFailure(call: Call<Cats>, t: Throwable) {
                if (t is IOException)
                    Toast.makeText(this@MainActivity," Ooops it's wifi",Toast.LENGTH_SHORT).show()
            }

        })
    }
}