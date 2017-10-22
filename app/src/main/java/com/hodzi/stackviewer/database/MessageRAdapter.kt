package com.hodzi.stackviewer.database

import com.hodzi.stackviewer.database.entities.Message
import com.hodzi.stackviewer.utils.base.BaseRAdapter

class MessageRAdapter(array: Array<Message>) :
    BaseRAdapter<Message, MessageHolder>(array, MessageHolder.creator())