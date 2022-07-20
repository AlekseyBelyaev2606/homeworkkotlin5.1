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
    val comments: Objects,
    val copyright: Objects,
    val likes: Objects,
    val repost: Objects,
    val views: Objects,
    val post_type: String,
    val signerId: Boolean,
    val canPin: Boolean,
    val canDelete: Boolean,
    val canEdit: Boolean,
    val isPinned: Boolean,
    val markedAsAds: Boolean,
    val isFavorite: Boolean,
    val postponedId: Boolean,
)

fun main() {
}

object WallService {
    private var posts = emptyArray<Post>()

    fun add(post: Post, id: Int): Post {
        posts += post
        for ((index, post) in posts.withIndex())
            if (post.id == id) {
                posts[index] = post.copy(id = post.id + 1)
            }
        return posts.last()

    }

    fun update(post: Post, id: Int): Boolean {
        for ((index, post) in posts.withIndex())
            if (post.id != id) {
                return true
            }
        return false
    }
}