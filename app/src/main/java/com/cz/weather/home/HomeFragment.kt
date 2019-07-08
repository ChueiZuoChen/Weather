package com.cz.weather.home

import androidx.lifecycle.ViewModelProviders
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import com.cz.weather.R
import com.cz.weather.data.WeatherAPIService
import kotlinx.android.synthetic.main.home_fragment.*
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch
import org.jetbrains.anko.AnkoLogger
import org.jetbrains.anko.doAsync
import org.jetbrains.anko.uiThread
import retrofit2.await


class HomeFragment : Fragment(),AnkoLogger{


    companion object {
        fun newInstance() = HomeFragment()
    }

    private lateinit var viewModel: HomeViewModel

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        return inflater.inflate(R.layout.home_fragment, container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        viewModel = ViewModelProviders.of(this).get(HomeViewModel::class.java)

        // TODO: Use the ViewModel
        val apiService = WeatherAPIService()

//        GlobalScope.launch(Dispatchers.Main){
//
//            val current = apiService.getCurrentWeather("Perth").await()
//            textView.text = current.toString()
//        }

        doAsync {
            var current= apiService.getCurrentWeather("Perth").execute().body()
            uiThread {
                textView.text = current!!.toString()
            }
        }

    }

}
