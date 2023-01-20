package com.example.youtube.data.model

data class Playlists(
    var kind : String,
    val items: List<Items>,
    val pageInfo: PageInfo
)

data class PageInfo(
    val totalResults : Int
)

data class Items(
    val id: String,
    val snippet: Snippet,
    val contentDetails : ContentDetails
)

data class ContentDetails(
    val itemCount : Int
)

data class Snippet(
    val title: String,
    val thumbnails: Thumbnails
)

data class Thumbnails(
    val standard : Standard
)

data class Standard(
    val url : String
)