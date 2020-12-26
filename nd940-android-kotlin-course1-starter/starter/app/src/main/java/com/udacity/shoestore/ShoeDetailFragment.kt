package com.udacity.shoestore
import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.activityViewModels
import androidx.navigation.Navigation
import androidx.navigation.findNavController
import androidx.navigation.fragment.findNavController
import com.udacity.shoestore.databinding.FragmentShoeDetailBinding
import com.udacity.shoestore.models.Shoe

/**
 * A simple [Fragment] subclass.
 * Use the [ShoeDetailFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class ShoeDetailFragment : Fragment() {

    private val viewModel: ShoeListingViewModel by activityViewModels()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val binding = DataBindingUtil.inflate<FragmentShoeDetailBinding>(inflater, R.layout.fragment_shoe_detail, container, false)
        binding.saveButton.setOnClickListener {

            val name = binding.shoeName.text
            val size = binding.shoeSize.text
            val company = binding.shoeCompany.text
            val description = binding.shoeDescription.text

            val isValid = listOf(name, size, company, description).none { it.isBlank() }

            if (isValid) {
                val newShoe = Shoe(name.toString(), size.toString().toDouble(), company.toString(), description.toString())
                binding.shoe = newShoe
                viewModel.addShoe(newShoe)
                binding.invalidateAll()
                Navigation.findNavController(it).navigate(R.id.shoeListingFragment)
            } else {
                Toast.makeText(context, "Please make sure you do not have any blank field", Toast.LENGTH_LONG).show()
            }

        }

        binding.cancelButton.setOnClickListener {
            it.findNavController().navigate(R.id.shoeListingFragment)
        }
        return binding.root
    }

}