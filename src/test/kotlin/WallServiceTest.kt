import org.junit.Test
import org.junit.Assert.*

class WallServiceTest {

    @Test
    fun updateExistPostShouldReturnsTrue() {
        val service = WallService
        service.add(Post(text = "initial post"))
        service.add(Post(id = 1, text = "updated post"))
        val update = Post(id = 1, text = "next update")

        val result = service.update(update)

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