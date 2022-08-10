import org.junit.Test
import org.junit.Assert.*

class Upgrade {

    @Test
    fun updateExistPostShouldReturnsTrue() {
        val initialPost = Post(text = "initial post")
        val updatedPost = Post(id = 1, text = "updated post")

        WallService.add(initialPost)
        val result = WallService.update(updatedPost)

        assertTrue(result)
            }


    @Test
    fun updateAbsentPostShouldReturnsFalse() {
        val updatedPost = Post(id = 1, text = "updated post")
        val result = WallService.update(updatedPost)

        assertFalse(result)
    }

    @Test
    fun addPostShouldIncrementId() {
        val initialPost = Post(text = "initial post")
        WallService.add(initialPost)
        val updatedPost = Post(id = 1, text = "updated post")
        WallService.add(updatedPost)
        val result = WallService.update(updatedPost)
        assertTrue(result)

        assertEquals(initialPost.id + 1, updatedPost.id)
    }
}