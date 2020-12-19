package com.udacity.shoestore
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.navigation.Navigation
import com.udacity.shoestore.databinding.FragmentShoeListingBinding

/**
 * A simple [Fragment] subclass.
 * Use the [ShoeListingFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class ShoeListingFragment : Fragment() {
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val binding = DataBindingUtil.inflate<FragmentShoeListingBinding>(inflater, R.layout.fragment_shoe_listing, container, false)
        binding.shoeListingButton.setOnClickListener {
            Navigation.findNavController(it).navigate(R.id.action_shoeListingFragment_to_shoeDetailFragment)
        }
        return binding.root
    }
}