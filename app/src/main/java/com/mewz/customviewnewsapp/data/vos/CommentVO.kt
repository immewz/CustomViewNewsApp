package com.mewz.customviewnewsapp.data.vos

import com.google.gson.annotations.SerializedName

data class CommentVO(
    @SerializedName("id") var id: Int = 0,
    @SerializedName("comment_message") var commentMessage: String = "",
    @SerializedName("commented_user") var commentedUser: UserVO? = null
)
