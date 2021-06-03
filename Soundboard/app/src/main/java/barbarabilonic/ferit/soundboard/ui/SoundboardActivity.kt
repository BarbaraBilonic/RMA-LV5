package barbarabilonic.ferit.soundboard.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import barbarabilonic.ferit.soundboard.databinding.ActivitySoundboardBinding

import org.koin.androidx.viewmodel.ext.android.viewModel

class SoundboardActivity : AppCompatActivity() {

    private val viewModel by viewModel<SoundboardViewModel>()
    private lateinit var binding: ActivitySoundboardBinding


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding= ActivitySoundboardBinding.inflate(layoutInflater).also {
            setContentView(it.root)
            it.ibHelloDarkness.setOnClickListener{playSound(1)}
            it.ibSpongebob.setOnClickListener {playSound(2)}
            it.ibWinXp.setOnClickListener { playSound(3) }

        }

    }

    private fun playSound(soundNumber:Int){
        viewModel.playSound(soundNumber)
    }
}