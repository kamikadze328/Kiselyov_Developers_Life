package com.kamikadze328.developerslife.ui.main

import android.content.Context
import android.util.Log
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.lifecycle.Lifecycle
import androidx.viewpager2.adapter.FragmentStateAdapter
import com.kamikadze328.developerslife.additional.CATEGORY

class ScreenSlidePagerAdapter(
    fragmentManager: FragmentManager,
    lifecycle: Lifecycle,
    var context: Context
) : FragmentStateAdapter(fragmentManager, lifecycle) {

    val fragments: MutableList<MemLayoutFragment?> = MutableList(itemCount) { null }
    override fun getItemCount(): Int = CATEGORY.values().size

    override fun createFragment(position: Int): Fragment {
        Log.v("kek", "FragmentStateAdapter createFragment - ${position + 1}")
        val f = MemLayoutFragment.newInstance(position + 1, context.resources.getString(CATEGORY.values()[position].resourceId))
        fragments.add(position, f)
        return f
    }
}
