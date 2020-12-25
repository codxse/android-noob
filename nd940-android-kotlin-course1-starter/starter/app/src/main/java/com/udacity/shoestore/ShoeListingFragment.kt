package com.udacity.shoestore
import android.app.ActionBar
import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import android.widget.Toast
import androidx.core.view.marginLeft
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.Navigation
import com.udacity.shoestore.databinding.FragmentShoeListingBinding
import com.udacity.shoestore.models.Shoe
import kotlinx.android.synthetic.main.fragment_shoe_listing.*

/**
 * A simple [Fragment] subclass.
 * Use the [ShoeListingFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class ShoeListingFragment : Fragment() {

    private lateinit var viewModel: ShoeListingViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val binding = DataBindingUtil.inflate<FragmentShoeListingBinding>(inflater, R.layout.fragment_shoe_listing, container, false)
        binding.floatingAddBtn.setOnClickListener {
            Navigation.findNavController(it).navigate(R.id.action_shoeListingFragment_to_shoeDetailFragment)
        }

        Log.i("ShoeListingViewModel", "called ViewModelProvider")


        viewModel = ViewModelProvider(this).get(ShoeListingViewModel::class.java)

        viewModel.shoes.observe(viewLifecycleOwner, Observer {
            shoeFromArgs()?.let { shoe ->
                it.add(shoe)
            }
            drawShoesList(binding.shoesContainer, it)
            arguments?.clear()
        })

        return binding.root
    }

    fun drawShoesList(container: ViewGroup?, shoes: MutableList<Shoe>) {
        if (container != null) {
            for (shoe in shoes) {
                val shoeName = TextView(context)
                shoeName.text = shoe.name
                container.addView(shoeName)

                val shoeCompany = TextView(context)
                shoeCompany.text = shoe.company
                container.addView(shoeCompany)

                val shoeSize = TextView(context)
                shoeSize.text = shoe.size.toString()
                container.addView(shoeSize)

                val shoeDescription = TextView(context)
                shoeDescription.text = shoe.description
                container.addView(shoeDescription)

                val divider = View(context)
                divider.setPadding(8, 3, 8, 16)
                container.addView(divider)
            }
        }
    }

    fun shoeFromArgs(): Shoe? {
        arguments?.let {
            Log.i("ARGS", it.size().toString())
            if (it.size() == 4) {
                val args = ShoeListingFragmentArgs.fromBundle(it)
                // Toast.makeText(context, "name ${args?.name}, size ${args?.size}, company ${args?.company}, desc ${args?.description}", Toast.LENGTH_SHORT).show()
                val shoe = Shoe(name = args.name.toString(), size = args.size.toString().toDouble(), company = args.company.toString(), description = args.description.toString())
                return shoe
            }
        }
        return null
    }
}