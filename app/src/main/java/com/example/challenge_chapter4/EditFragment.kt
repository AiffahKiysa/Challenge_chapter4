package com.example.challenge_chapter4

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import com.example.challenge_chapter4.dao.DataNote
import com.example.challenge_chapter4.dao.NoteViewModel
import com.example.challenge_chapter4.databinding.FragmentEditBinding
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.async

class EditFragment : Fragment() {
    private var _binding : FragmentEditBinding? = null
    private val binding get() = _binding!!
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        _binding = FragmentEditBinding.inflate(inflater,container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.btnEditNote.setOnClickListener {
            updateNote(it)
        }
    }

    fun updateNote(it : View?){
        GlobalScope.async {
            var title = binding.editTitle.text.toString()
            var note  = binding.editNotee.text.toString()
            val viewModel : NoteViewModel by viewModels()
            val data = DataNote(1, title = title, content = note)

            viewModel.updateNote(data)
        }
        Toast.makeText(context, "Data Berhasil Dimasukkan", Toast.LENGTH_SHORT).show()
        findNavController().navigate(R.id.action_editFragment_to_homeFragment)
    }
//        val getDataNote = getActivity()?.getIntent()?.getSerializableExtra("dataedit") as DataNote
//
//        binding.editTitle.setText(getDataNote.title)
//        binding.editNotee.setText(getDataNote.content)
//        binding.idNote.setText(getDataNote.id.toString())
//    }
//    override fun onCreateView(
//        inflater: LayoutInflater, container: ViewGroup?,
//        savedInstanceState: Bundle?
//    ): View? {
//        // Inflate the layout for this fragment
//        binding = FragmentEditBinding.inflate(inflater,container,false)
//        return binding.root
//
//    }
//
//
//    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
////        super.onViewCreated(view, savedInstanceState)
//////        val getDataNote = getActivity()?.getIntent()?.getSerializableExtra("dataedit") as DataNote
//////
//////        binding.editTitle.setText(getDataNote.title)
//////        binding.editNotee.setText(getDataNote.content)
//////        binding.idNote.setText(getDataNote.id.toString())
//////        val getDataNote = arguments?.getString(NoteAdapter.DATA_EDIT)
////
////        val getDataNote = getActivity()?.getIntent()?.getStringExtra(NoteAdapter.DATA_EDIT) as DataNote
//////        binding.editTitle.text = getDataNote.title
////        binding.editTitle.setText(getDataNote.title)
////        binding.editNotee.setText(getDataNote.content)
////        binding.idNote.setText(getDataNote.id.toString())
//
//        super.onViewCreated(view, savedInstanceState)
//
//        val getDataNote = arguments?.getString(NoteAdapter.DATA_EDIT) as DataNote
//        binding.btnEditNote.setOnClickListener(){ view ->
//            if (binding.editTitle.text.isNullOrEmpty()){
//                Toast.makeText(requireContext(), "Data harus terisi", Toast.LENGTH_SHORT).show()
//            }
//            else{
//                val actionToFragmentEdit =
//                    EditFragmentDirections.actionEditFragmentToHomeFragment()
//                binding.editTitle.setText(actionToFragmentEdit.toString())
////                val actionToFragmentKetiga =
////                    FragmentKeduaDirections.actionFragmentKeduaToFragmentKetiga()
////                actionToFragmentKetiga.name = binding.etName.text.toString()
//                view.findNavController().navigate(actionToFragmentEdit)
//            }
//        }
//
////        binding.btnToFragmentKetiga.setOnClickListener{ view ->
////            if (binding.etName.text.isNullOrEmpty()){
////                Toast.makeText(requireContext(), "Kolom Nama masih kosong", Toast.LENGTH_SHORT).show()
////            }
////            else{
////                val actionToFragmentKetiga =
////                    FragmentKeduaDirections.actionFragmentKeduaToFragmentKetiga()
////                actionToFragmentKetiga.name = binding.etName.text.toString()
////                view.findNavController().navigate(actionToFragmentKetiga)
////            }
////        }
//
//    }
////    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
////        super.onViewCreated(view, savedInstanceState)
////        var getDataNote = intent.getSerializableExtra("dataedit")
////    }

}