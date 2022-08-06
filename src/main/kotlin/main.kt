import java.util.*

data class Post(
    val id: Int,
    val ownerId: Int,
    val fromId: Int,
    val createdBy: String,
    val date: Long,
    val text: String,
    val replyPostId: Int,
    val friendsOnly: Boolean,
    val comments: Comments,
    val copyright: Copyright,
    val likes: Likes,
    val repost: Repost,
    val views: Views,
    val postType: String,
    val signerId: Boolean,
    val canPin: Boolean,
    val canDelete: Boolean,
    val canEdit: Boolean,
    val isPinned: Boolean,
    val markedAsAds: Boolean,
    val isFavorite: Boolean,
    val postponedId: Boolean,
){
    data class Views(
        val count: Int = 0
    )
    data class Repost(
        val count: Int = 0,
        val userReposted: Boolean = false
    )

    data class Comments(
        val count: Int = 0,
        val canPost: Boolean = false,
        val groupsCanPost: Boolean = false,
        val canClose: Boolean = false,
        val canOpen: Boolean = false
    )

    data class Copyright(
        val id: Int = 0,
        val link: String,
        val name: String,
        val type: String
    )

    data class Likes(
        val count: Int = 0,
        val userLikes: Boolean = false,
        val canLike: Boolean = false,
        val canPublish: Boolean = false,
    )

}

fun main() {
}

object WallService {
    private var posts = emptyArray<Post>()
    private var id = 0

    fun add(post: Post): Post {
        posts += post.copy(id = ++id)
        return posts.last()
    }

    fun update(post: Post): Boolean {
        for (savedPostIndex in posts.indices){
            val savedPost = posts[savedPostIndex]
        if (savedPostIndex == post.id) {
            posts[savedPostIndex] = post.copy(
                fromId = savedPost.fromId,
                date = savedPost.date
            )
        }
                return true
            }
        return false
    }
}