package com.hodzi.stackviewer.adapters

import com.hodzi.stackviewer.adapters.holders.UsersHolder
import com.hodzi.stackviewer.model.User
import com.hodzi.stackviewer.utils.base.BaseRAdapter

class UsersRRAdapter(array: Array<User>) :
    BaseRAdapter<User, UsersHolder>(array, UsersHolder.creator())