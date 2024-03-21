package com.example.investman.ui.gallery

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import com.example.investman.R
import com.example.investman.databinding.FragmentGalleryBinding

class GalleryFragment : Fragment() {

    private var _binding: FragmentGalleryBinding? = null

    // This property is only valid between onCreateView and
    // onDestroyView.
    private val binding get() = _binding!!
    private var count = 0

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        val galleryViewModel =
            ViewModelProvider(this).get(GalleryViewModel::class.java)

        _binding = FragmentGalleryBinding.inflate(inflater, container, false)
        val root: View = binding.root

        val counterTextView: TextView = root.findViewById(R.id.counterText)
        counterTextView.text = count.toString()
        val plusBtn: Button = root.findViewById(R.id.plusBtn)
        plusBtn.text = "+1"
        val resetBtn: Button = root.findViewById(R.id.resetBtn)
        resetBtn.text = "Reset"

        plusBtn.setOnClickListener {
            count++
            counterTextView.text = count.toString()
        }
        resetBtn.setOnClickListener {
            count = 0
            counterTextView.text = count.toString()
        }

        return root
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}
