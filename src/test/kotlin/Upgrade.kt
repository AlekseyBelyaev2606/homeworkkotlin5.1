import WallService.add
import org.junit.Test

import org.junit.Assert.*

class Upgrade {

    @Test
    fun update(post: Post) {

        val resultId = post.id
        val resultDate = post.date
        val result = update(Post())

        assertEquals(resultId, post.id)
        assertEquals(resultDate, post.date)
            }
    }
}