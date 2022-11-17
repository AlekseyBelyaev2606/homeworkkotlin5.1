
data class Post(
    val id: Int = 0,
    val ownerId: Int = 0,
    val fromId: Int = 0,
    val createdBy: String = "",
    val date: Long = 0,
    val text: String = "",
    val replyPostId: Int = 0,
    val friendsOnly: Boolean = false,
    val comments: Comments = Comments(),
    val copyright: Copyright = Copyright(),
    val likes: Likes = Likes(),
    val repost: Repost = Repost(),
    val views: Views = Views(),
    val postType: String = "",
    val signerId: Boolean = false,
    val canPin: Boolean = false,
    val canDelete: Boolean = false,
    val canEdit: Boolean = false,
    val isPinned: Boolean = false,
    val markedAsAds: Boolean = false,
    val isFavorite: Boolean = false,
    val postponedId: Boolean = false,
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
        val link: String = "",
        val name: String = "",
        val type: String = ""
    )

    data class Likes(
        val count: Int = 0,
        val userLikes: Boolean = false,
        val canLike: Boolean = false,
        val canPublish: Boolean = false,
    )
}

class WallService {
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