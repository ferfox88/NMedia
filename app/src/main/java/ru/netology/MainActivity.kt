package ru.netology

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import ru.netology.databinding.ActivityMainBinding
import ru.netology.dto.Post
import ru.netology.dto.translatingCount

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val post = Post(
                id = 1,
                author = "Нетология. Университет интернет-профессий будущего",
                content = "Привет, это новая Нетология! Когда-то Нетология начиналась с интенсивов по онлайн-маркетингу. Затем появились курсы по дизайну, разработке, аналитике и управлению. Мы растём сами и помогаем расти студентам: от новичков до уверенных профессионалов. Но самое важное остаётся с нами: мы верим, что в каждом уже есть сила, которая заставляет хотеть больше, целиться выше, бежать быстрее. Наша миссия — помочь встать на путь роста и начать цепочку перемен → http://netolo.gy/fyb",
                published = "21 мая в 18:36",
                likedByMe = false,
                countLike = 999999,
                countShare = 9999
        )
        with(binding) {
            author.text = post.author
            published.text = post.published
            content.text = post.content
            countLike.text = translatingCount(post.countLike)
            countShare.text = translatingCount(post.countShare)
            if (post.likedByMe) {
                like?.setImageResource(R.drawable.liked)
            }

            like?.setOnClickListener {
                if (post.likedByMe) {
                    post.likedByMe = !post.likedByMe
                    post.countLike--
                    countLike.text = translatingCount(post.countLike)
                    like.setImageResource(R.drawable.ic_baseline_favorite_border_24)
                } else {
                    post.likedByMe = !post.likedByMe
                    post.countLike++
                    countLike.text = translatingCount(post.countLike)
                    like.setImageResource(R.drawable.liked)
                }
            }

            share.setOnClickListener {
                post.countShare++
                countShare.text = translatingCount(post.countShare)
            }
        }
    }
}
