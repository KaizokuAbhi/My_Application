package com.example.myapplication.fragments

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.lifecycle.Observer
import com.example.myapplication.CheckConnection
import com.example.myapplication.Connecivity
import com.example.myapplication.R
import com.example.myapplication.databinding.FragmentHomeNewsBinding
import java.lang.Math.log

class HomeNewsFragment : Fragment() {
private lateinit var connectivity:Connecivity
private val con by lazy {CheckConnection(requireActivity().application)}
lateinit var binding: FragmentHomeNewsBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding= FragmentHomeNewsBinding.inflate(inflater)
        binding.apply {
            con.observe(viewLifecycleOwner, Observer {
                if (it){
                    imageView.setImageResource(R.drawable.baseline_wifi_on)
                    connectiityInfo.text="Connected !"
                }
                else{
                    imageView.setImageResource(R.drawable.baseline_wifi_off)
                    connectiityInfo.text="Internet Disconneted !"
                }
            })
        }
        return binding.root
    }
}