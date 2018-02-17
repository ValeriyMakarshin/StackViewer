package com.hodzi.stackviewer.users

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.hodzi.stackviewer.R
import com.hodzi.stackviewer.adapters.UsersRAdapter
import com.hodzi.stackviewer.di.Injector
import com.hodzi.stackviewer.model.User
import com.hodzi.stackviewer.utils.base.BaseFragment
import com.hodzi.stackviewer.utils.base.BaseHolder
import com.hodzi.stackviewer.utils.base.BaseRAdapter
import com.hodzi.stackviewer.utils.ui.ActivityInfo
import com.hodzi.stackviewer.utils.ui.ActivityListInfo
import kotlinx.android.synthetic.main.fragment_users.*
import kotlinx.android.synthetic.main.view_progress_bar.*
import kotlinx.android.synthetic.main.view_refresh_button.*

class UsersFragment : BaseFragment<UsersView, UsersPresenter>(), UsersView {
    override fun getAdapter(array: Array<*>): BaseRAdapter<*, out BaseHolder<*>>? {
        return UsersRAdapter(array as Array<User>)
    }

    override fun getActivityInfo(): ActivityInfo = ActivityInfo(R.layout.fragment_users,
        activityListInfo = ActivityListInfo(uiProgressBar, uiUsersRv, uiUsersSrl, uiRefreshBt))

    override fun onCreateView(inflater: LayoutInflater?, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        Injector.inject(this)
        return super.onCreateView(inflater, container, savedInstanceState)
    }
}
