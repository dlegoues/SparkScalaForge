package org.personal.sparkscalaforge.model

object Model{
    
    case class modelStreaming (
        row_id: String,
        id: String,
        title: String,
        year: String,
        rotten_tomatoes: String,
        netflix: String,
        hulu: String,
        prime_video: String,
        disney: String,
        `type`: String
    )
}