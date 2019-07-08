package com.cz.weather.future

import androidx.lifecycle.ViewModelProviders
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.cz.weather.R


class SevenDaysFragment : Fragment() {

    companion object {
        fun newInstance() = SevenDaysFragment()
    }

    private lateinit var viewModel: SevenDaysViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.seven_days_fragment, container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        viewModel = ViewModelProviders.of(this).get(SevenDaysViewModel::class.java)
        // TODO: Use the ViewModel
    }

}
