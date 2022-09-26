package com.example.challenge_chapter4

import android.content.Context
import android.content.SharedPreferences
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.example.challenge_chapter4.databinding.FragmentRegisterBinding

class RegisterFragment : Fragment() {
    lateinit var binding: FragmentRegisterBinding
    lateinit var  sharedPref : SharedPreferences

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding = FragmentRegisterBinding.inflate(inflater,container,false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        sharedPref = requireActivity().getSharedPreferences("registerData", Context.MODE_PRIVATE)

        binding.register.setOnClickListener{
            registerBtn()
        }

        binding.login.setOnClickListener{
            findNavController().navigate(R.id.action_registerFragment_to_loginFragment)
        }
    }
    fun registerBtn (){
        val email = binding.email.text.toString()
        val username = binding.username.text.toString()
        val password = binding.password.text.toString()
        val password2 = binding.password2.text.toString()
        if (password == password2){
            var addData = sharedPref.edit()
            addData.putString("email", email)
            addData.putString("username", username)
            addData.putString("password", password)
            addData.apply()
            Toast.makeText(requireContext(), "Data Save", Toast.LENGTH_SHORT).show()
        }
        else
            Toast.makeText(requireContext(), "Password Not Match", Toast.LENGTH_SHORT).show()
    }
}