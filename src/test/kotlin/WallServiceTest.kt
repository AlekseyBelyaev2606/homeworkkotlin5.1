import org.junit.Test
import org.junit.Assert.*

class WallServiceTest {

    @Test
    fun updateExistPostShouldReturnsTrue() {
        val service = WallService()
        service.add(Post(text = "initial post"))
        service.add(Post(id = 1, text = "updated post"))

        val update = Post(1, text = "next update")
        val result = service.update(update)

        assertTrue(result)
    }


    @Test
    fun updateAbsentPostShouldReturnsFalse() {
        val service = WallService()
        val updatedPost = Post(id = 1, text = "updated post")

        val result = service.update(updatedPost)

        assertFalse(result)
    }

    @Test
    fun addPostShouldIncrementId() {
        val service = WallService()
        val initialPost = Post(text = "initial post")
        val updatePost = Post(id = 1, text = "updated post")
        val expectedId = 2

        service.add(initialPost)
        val result = service.add(updatePost)

        assertEquals(expectedId, result.id)

    }
}