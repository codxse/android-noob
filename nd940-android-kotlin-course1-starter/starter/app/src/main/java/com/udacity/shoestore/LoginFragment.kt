package com.udacity.shoestore

import android.os.Bundle
import android.view.*
import androidx.fragment.app.Fragment
import androidx.databinding.DataBindingUtil
import androidx.navigation.Navigation
import androidx.navigation.findNavController
import com.udacity.shoestore.databinding.FragmentLoginBinding

/**
 * A simple [Fragment] subclass.
 * Use the [LoginFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class LoginFragment : Fragment() {
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val binding = DataBindingUtil.inflate<FragmentLoginBinding>(inflater, R.layout.fragment_login, container, false)
        binding.buttonLogin.setOnClickListener {
            Navigation.findNavController(it).navigate(R.id.action_loginFragment_to_onboardingFragment)
        }
        binding.registerTextAsButton.setOnClickListener {
            Navigation.findNavController(it).navigate(R.id.action_loginFragment_to_onboardingFragment)
        }
        return binding.root
    }
}