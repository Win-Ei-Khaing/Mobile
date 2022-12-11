package com.example.cvbuilderapplication.fragment

import com.example.cvbuilderapplication.R
import android.annotation.SuppressLint
import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.cvbuilderapplication.adapter.WorkAdapter
import com.example.cvbuilderapplication.dialog.WorkDialog
import com.example.cvbuilderapplication.model.Work

class WorkFragment : Fragment(R.layout.fragment_work) {

    private var workList = mutableListOf<Work>()
    private lateinit var adapter: WorkAdapter
    private lateinit var recyclerView: RecyclerView
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        recyclerView = view.findViewById(R.id.recycler_view)
        if (context != null) {
            workList = mutableListOf(
                Work(
                    getString(R.string.unique_comm),
                    getString(R.string.unique_comm_position),
                    getString(R.string.unique_comm_period),
                    R.drawable.uniquecomm
                ),
                Work(
                    getString(R.string.e_tag),
                    getString(R.string.e_tag_position),
                    getString(R.string.e_tag_period),
                    R.drawable.etag
                ),
                Work(
                    getString(R.string.video_bank),
                    getString(R.string.video_bank_position),
                    getString(R.string.video_bank_period),
                    R.drawable.videobank
                )
            )
            setupRecyclerView()
        }

        val fab: View = view.findViewById(R.id.fab)
        fab.setOnClickListener { showWorkDialog() }
    }

    private fun setupRecyclerView() {
        if (::recyclerView.isInitialized) {
            recyclerView.layoutManager = LinearLayoutManager(context)
            adapter = WorkAdapter(requireContext(), workList)
            recyclerView.adapter = adapter
        }
    }

    private fun showWorkDialog() {
        val dialog = WorkDialog()
        dialog.show(parentFragmentManager, WorkDialog::class.java.name)
    }

    @SuppressLint("NotifyDataSetChanged")
    fun onAddWOrk(work: Work) {
        workList.add(work)
        if (::adapter.isInitialized) {
            adapter.notifyDataSetChanged()
        } else {
            setupRecyclerView()
        }
    }

}