package com.example.cvbuilderapplication.adapter

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.lifecycle.Lifecycle
import androidx.viewpager2.adapter.FragmentStateAdapter
import com.example.cvbuilderapplication.fragment.AboutFragment
import com.example.cvbuilderapplication.fragment.ContactFragment
import com.example.cvbuilderapplication.fragment.HomeFragment
import com.example.cvbuilderapplication.fragment.WorkFragment
import com.example.cvbuilderapplication.model.Work

class MyViewAdapter(fm: FragmentManager, lc: Lifecycle) : FragmentStateAdapter(fm,lc) {
    override fun getItemCount(): Int = 4
    val workFragment = WorkFragment()
    override fun createFragment(position: Int): Fragment {
        return   when(position){
            0-> HomeFragment()
            1-> AboutFragment()
            2-> workFragment
            3-> ContactFragment()
            else-> Fragment()
        }
    }

    fun addWork(work: Work){
        workFragment.onAddWOrk(work)
    }
}