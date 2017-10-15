package com.hodzi.stackviewer.users

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.hodzi.stackviewer.R
import com.hodzi.stackviewer.adapters.UsersRRAdapter
import com.hodzi.stackviewer.di.Injector
import com.hodzi.stackviewer.model.User
import com.hodzi.stackviewer.utils.base.BaseFragment
import com.hodzi.stackviewer.utils.ui.ActivityInfo
import com.hodzi.stackviewer.utils.ui.ActivityListInfo
import kotlinx.android.synthetic.main.fragment_users.*
import kotlinx.android.synthetic.main.view_progress_bar.*

class UsersFragment : BaseFragment<UsersView, UsersPresenter>(), UsersView {
    override fun showArray(array: Array<User>) {
        uiUsersRv.adapter = UsersRRAdapter(array)
    }

    override fun getActivityInfo(): ActivityInfo = ActivityInfo(R.layout.fragment_users,
        activityListInfo = ActivityListInfo(uiProgressBar, uiUsersRv))

    override fun onCreateView(inflater: LayoutInflater?, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        Injector.inject(this)
        return super.onCreateView(inflater, container, savedInstanceState)
    }


}