package ru.netology.repository

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import ru.netology.dto.Post
import ru.netology.dto.translatingCount

class PostRepositoryInMemoryImpl : PostRepository {

    var post = Post(
        id = 1,
        author = "Нетология. Университет интернет-профессий будущего",
        content = "Привет, это новая Нетология! Когда-то Нетология начиналась с интенсивов по онлайн-маркетингу. Затем появились курсы по дизайну, разработке, аналитике и управлению. Мы растём сами и помогаем расти студентам: от новичков до уверенных профессионалов. Но самое важное остаётся с нами: мы верим, что в каждом уже есть сила, которая заставляет хотеть больше, целиться выше, бежать быстрее. Наша миссия — помочь встать на путь роста и начать цепочку перемен → http://netolo.gy/fyb",
        published = "21 мая в 18:36",
        likedByMe = false,
        countLike = 0,
        countShare = 0
    )

    private val data = MutableLiveData(post)

    override fun get(): LiveData<Post> = data

    override fun like() {
        post = if (post.likedByMe) {
            val countLikes = post.countLike - 1
            post.copy(likedByMe = !post.likedByMe, countLike = countLikes)
        } else {
            val countLikes = post.countLike + 1
            post.copy(likedByMe = !post.likedByMe, countLike = countLikes)
        }
        data.value = post
    }

    override fun share() {
        val countShares = post.countShare + 1
        post = post.copy(countShare = countShares)
        data.value = post
    }
}