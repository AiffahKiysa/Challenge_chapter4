package com.example.challenge_chapter4

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.challenge_chapter4.dao.NoteDatabase
import com.example.challenge_chapter4.dao.NoteViewModel
import com.example.challenge_chapter4.databinding.FragmentHomeBinding

class HomeFragment : Fragment() {
    lateinit var binding: FragmentHomeBinding
    var NoteDB : NoteDatabase? = null
    lateinit var adapterNote : NoteAdapter
    private val viewModel : NoteViewModel by viewModels()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding = FragmentHomeBinding.inflate(inflater,container,false)
        viewModel.getNote().observe(viewLifecycleOwner){ listNote ->
            binding.rvNote.layoutManager = LinearLayoutManager(requireContext())
            binding.rvNote.adapter = NoteAdapter(requireContext(),listNote)
        }
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

//        NoteDB = NoteDatabase.getInstance(this)
        binding.btnAddNote.setOnClickListener {
            findNavController().navigate(R.id.action_homeFragment_to_addNoteFragment)
        }
//        getAllNote()
    }

}