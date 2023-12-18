package com.example.liveappcountdown

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.activityViewModels
import androidx.lifecycle.lifecycleScope
import com.example.liveappcountdown.databinding.FragmentCountdownBinding
import kotlinx.coroutines.launch


class CountdownFragment : Fragment() {

    private lateinit var binding: FragmentCountdownBinding
    private val viewmodel: CountdownViewmodel by activityViewModels()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentCountdownBinding.inflate(layoutInflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        viewmodel.timer.observe(viewLifecycleOwner) {secondsLeft ->

            binding.countdownTV.text = secondsLeft.toString()

        }

        binding.button.setOnClickListener {
            viewmodel.stopTimer()
//            binding.button.setText("Stopp")
        }


    }
}