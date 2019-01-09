package com.example.commonservice.article

/**
 * @author
 * @Date 2019/1/8
 * @description
 * @since 1.0.0
 */
data class ResponseArticleData(
    var date: ResponseArticleDateInfo,
    var author: String,
    var title: String,
    var digest: String,
    var content: String,
    var wc: Int
)