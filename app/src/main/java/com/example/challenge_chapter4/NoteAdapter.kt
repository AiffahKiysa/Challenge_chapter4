package com.example.challenge_chapter4

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.Toast
import androidx.navigation.Navigation
import androidx.recyclerview.widget.RecyclerView
import com.example.challenge_chapter4.dao.DataNote
import com.example.challenge_chapter4.dao.NoteDatabase
import com.example.challenge_chapter4.databinding.ItemNoteBinding
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.async


class NoteAdapter(var requireContext: Context ,var  listNote : List<DataNote>): RecyclerView.Adapter<NoteAdapter.ViewHolder>() {

    var DBNote : NoteDatabase? = null
    class ViewHolder(var binding: ItemNoteBinding): RecyclerView.ViewHolder(binding.root){
//        fun data(itemData : DataNote){
//            binding.datanote = itemData
//        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        var view = ItemNoteBinding.inflate(LayoutInflater.from(parent.context),parent,false)

        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.binding.id.text = listNote[position].title
        holder.binding.judul.text = listNote[position].content
        val data = listNote[position]

        holder.binding.delete.setOnClickListener{
            DBNote = NoteDatabase.getInstance(it.context)
            GlobalScope.async {
                val del = DBNote?.noteDao()?.deleteNote(data)
                if ( del != 0){
                    Toast.makeText(it.context, "Data ${listNote[position].id} Data dihapus", Toast.LENGTH_SHORT).show()
                }else{
                    Toast.makeText(it.context, "Data ${listNote[position].id} Data Gagal dihapus ", Toast.LENGTH_SHORT).show()
                }
            }
        }

        holder.binding.edit.setOnClickListener{
            var bundle = Bundle()
            bundle.putInt("id", data.id)
            bundle.putString("content", data.content)
            bundle.putString("title", data.title)
            Navigation.findNavController(it).navigate(R.id.action_homeFragment_to_editFragment, bundle)
        }
//        holder.binding.edit.setOnClickListener{
//            Navigation.findNavController(R.id.action_editFragment_to_homeFragment)
////            var move = Intent(it.context, R.id.action_homeFragment_to_editFragment::class.java)
////            move.putExtra("dataedit", data)
////            it.context.startActivity(move)
//            val actionToFragmentEdit =
//                HomeFragmentDirections.actionHomeFragmentToEditFragment()
//                actionToFragmentEdit
////            FragmentKeduaDirections.actionFragmentKeduaToFragmentKetiga()
////            actionToFragmentKetiga.name = binding.etName.text.toString()
////            view.findNavController().navigate(actionToFragmentKetiga)
////            val getDataNote = getActivity()?.getIntent()?.getSerializableExtra("dataedit") as DataNote
////
////        binding.editTitle.setText(getDataNote.title)
////        binding.editNotee.setText(getDataNote.content)
////        binding.idNote.setText(getDataNote.id.toString())
//        }

    }


    override fun getItemCount(): Int {
        return listNote.size
    }


}